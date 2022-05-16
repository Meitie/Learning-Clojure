; Adapted from https://github.com/juliangamble/clojure-snake

(ns examples.snake
  (:import
   (java.awt Color Dimension)
   (javax.swing JPanel JFrame Timer JOptionPane)
   (java.awt.event ActionListener KeyListener KeyEvent)))

; --------------------------------------
; Functional Model
; --------------------------------------

;constants
(def field-width 50)
(def field-height 30)
(def point-size 15)
(def turn-millis 100)
(def win-length 10)
(def directions
  {KeyEvent/VK_LEFT [-1 0]
   KeyEvent/VK_RIGHT [1 0]
   KeyEvent/VK_UP [0 -1]
   KeyEvent/VK_DOWN [0 1]})

; define a function to create a snake, it takes 0 parameters []
(defn create-snake [] ; it has some keyword fields with values
  {:body (list [3 0] [2 0] [1 0] [0 0]) ;the body, which is a list of length [3 0] is the head and [0 0] is the tail
   :direction [1 0] ;direction is the way it is facing [1 0] is right
   :type :snake ; the type is of snake keyword
   :color (Color. 15 160 70)}) ; it has set colors by default

;define an apple that takes 0 parameters when called (seen by the [])
(defn create-apple [] ; takes a few keywords as fields
  {:location [(rand-int field-width) (rand-int field-height)] ; location, is random int of the height and width
   :color (Color. 210 50 90) ; the color is more red
   :type :apple}) ; the type is a keyword for apple

; uses to convert from fields to pixels, so that it can be drawn and rendered.
; and draws the rectangle based on sizes
(defn point-to-screen-rect [[pt-x pt-y]]
  [(* pt-x point-size) (* pt-y point-size) point-size point-size])

; this is the actual function that moves the snake
; :keys = key, [body direction] = is destructuring the values from them, and saving it as snake
(defn move [{:keys [body direction] :as snake} & grow]
  (assoc snake :body
         (cons 
          (let [[head-x head-y] (first body)
                [dir-x dir-y] direction] ; saves the dir-x/y from direction into that
            [(+ head-x dir-x) (+ head-y dir-y)])
          (if grow body (butlast body)))))
; it will take an if statement, if grow = true, then returns whole new body. else it will call in the () 
; butlast creates a new sequence with everything but the very last element, in body

; takes 2 bindings a snake map and a direction, and returns a new snake and new directions
(defn turn [snake direction]
  (assoc snake :direction direction))

; a true/false ?, takes in the body from the body, if count of body is bigger then length
(defn win? [{body :body}]
  (>= (count body) win-length))

; checks if the head vector, overlaps any of the body vectors
(defn head-overlaps-body? [head body]
  (contains? (set body) head))

; checks if the head ever goes outside of the bounds
(defn head-outside-bounds? [[head-x head-y]]
  (or
   (> head-x field-width)
   (< head-x 0)
   (> head-y field-height)
   (< head-y 0)))

; returns true if game lost, false if not. check's the head and body.
(defn lose? [{[head & body] :body}]
  (or (head-overlaps-body? head body)
      (head-outside-bounds? head)))

; checks if the head of the body overlaps the apple
(defn eats? [{[head] :body} {apple :location}]
  (= head apple))


; --------------------------
; mutable model
; --------------------------
(defn update-position [snake apple]
  (dosync
   (if (eats? @snake @apple)
     (do
       (ref-set apple (create-apple))
       (alter snake move :grow))
     (alter snake move)))
  nil)

(defn update-direction [snake direction]
  (dosync (alter snake turn direction))
  nil)

(defn reset-game [snake apple]
  (dosync
   (ref-set snake (create-snake))
   (ref-set apple (create-apple)))
  nil)

; ---------------------------------------------
; gui
; ---------------------------------------------

(defn fill-point [g pt color]
  (let [[x y width height] (point-to-screen-rect pt)]
    (.setColor g color)
    (.fillRect g x y width height)))

(defmulti paint (fn [g object] (:type object)))

(defmethod paint :apple [g {:keys [location color]}]
  (fill-point g location color))

(defmethod paint :snake [g {:keys [body color]}]
  (doseq [point body]
    (fill-point g point color)))

(defn game-panel [frame snake apple]
  (proxy [JPanel ActionListener KeyListener] []
    ; JPanel
    (paintComponent [g]
      (proxy-super paintComponent g)
      (paint g @apple)
      (paint g @snake))
    (getPreferedSize []
      (Dimension. (* (inc field-width) point-size)
                  (* (inc field-height) point-size)))
    ; ActionListener
    (actionPerformed [e]
      (update-position snake apple)
      (if (lose? @snake)
        (do
          (reset-game snake apple)
          (JOptionPane/showMessageDialog frame "You lose!")))
      (if (win? @snake)
        (do
          (reset-game snake apple)
          (JOptionPane/showMessageDialog frame "You Win!")))
      (.repaint this))
    ; KeyListener
    (KeyPressed [e]
                (let [direction (directions (.getKeyCode e))]
                  (if direction (update-direction snake direction))))
    (KeyPressed [e])
    (keyTyped [e])))

(defn game []
  (let [snake (ref (create-snake))
        apple (ref (create-apple))
        frame (JFrame. "Snake")
        panel (game-panel frame snake apple)
        timer (Timer. turn-millis panel)]
    (.setFocusable panel true)
    (.addKeyListener panel panel)
    
    (.add frame panel)
    (.pack frame)
    (.setDefaultCloseOpertion frame JFrame/EXIT_ON_CLOSE)
    (.setVisitble frame true)
    
    (.start timer)))


(game)