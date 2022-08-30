1
"a string"
["a" "vector" "of" "strings"]

;; (operator operand1 operand2 ... operandN)

(+ 1 2 3) ;; => 6
(+ 1,2,3) ;; => 6
;; they are the same, as such we don't use the ',' as clojure treats as whitespace

(str "It was the panda " "in the library " "with the dust buster")


;; IF
(if true
  "By Zues's hammer!"
  "By Aquaman's trident")

(if false
  "By Zues's hammer!"
  "By Aquaman's trident")

(if false
  "By Odin's Elbow!")

;; Interestingly as this is operands, the else / then blocks only have 1 form
;; / type of expression so you cannot chain like in other languages thus to chain
;; more info onto it, we use the "do" fn

;; DO
(if true
  (do (println "Success!")
      "By Zues's Hammer!")
  (do (println "Failure!")
      "By Aquaman's Trident"))

;; WHEN
(when true
  (println "Success!")
  "abra cadabra")

;; nil, true, false, Truhiness, Equality, Boolean Expressions
(nil? 1)
(nil? nil)

(if "bears eat beets"
  "bears beets battlestar galactica")

(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

;; Equality
(= 1 1)
(= nil nil)
(= 1 2)

;; OR and AND
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
(or (= 0 1) (= "yes" "no"))
(or nil)

(and :free_wifi :hot_coffee)
(and :feelin_super_cool nil false)

;; Naming with DEF
(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explor" "The Incredible Bulk"])

failed-protagonist-names

;; bindings slightly changed value, depending on values given with it
;; instead of re-assigning values.
(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOMED!")))
(error-message :mild)
(error-message :bob)

;; DATA STRUCTURES
;; Numbers
1   ;;integer
1.2 ;;float
1/5 ;;ratio

;; Strings
"lord voldemort"
"\"He who must not be named\""
"\"Great cow of Moscow!\" - Hermes Conrad"

;; Maps
{}
{:first-name "Charlie"
 :last-name "McFishwich"}
{"string-key" +}
{:name {:first "John" :middle "Harry" :last "Smith"}}

;; using hash-map fn to create a map
(hash-map :a 1 :b 2)

;; getting values from maps
(get {:a 0 :b 1} :b)
(get {:a 0 :b {:c "ho hum"}} :b)

(get {:a 0 :b 1} :c "unicorns?")
(get {:a 0 :b 1} :c {:a "uni"})

;; get-in values from nested maps
(get-in {:a 0 :b {:c "no hum"}} [:b :c])
(get-in {:a 0 :b {:c "no hum"}} [:b])

;; getting values, using dictionary as the fn
({:name "The great Coffepot"} :name)

;; Keywords
:a
:_?

(:a {:a 1 :b 2 :c 3})
;; same as get
(get {:a 1 :b 2 :c 3} :a)
;; default
(:d {:a 1 :b 2 :c 3} "No gnome knows how homes like Noah knows")

;; VECTORS
[3 2 1]

(get [3 2 1] 0)
(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

(vector "creepy" "full" "moon")
(conj [1 2 3] 4)

;; LISTS
'(1 2 3 4)
(nth '(1 2 3 4) 3)

(conj '(1 2 3) 4)

;; SETS
#{"kurt" 20 :icicle}
(hash-set 1 1 2 2)

(conj #{:a :b} :a)

(set [3 3 3 3 3 3 3 4 4])

(contains? #{:a :b} :a)
(contains? #{:a :b} 3)
(contains? #{nil} nil)

(:a #{:a :b})

(get #{:a :b} :a)
(get #{:a nil} nil)
(get #{:a :b} "kurt")


;; FUNCTIONS

;; calling functions
(+ 1 2 3 4)
(* 1 2 3 4)
(first [1 2 3 4])

(or + -)
((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

(inc 1.1)
(map inc [0 1 2 3])

(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2)))
(+ 200 (/ 100 5))
(+ 200 20)
220

(defn too-enthusiastic
  "Return a cheer"
  [name]
  (str "OH MY GOSH " name " Are the best!"))

(too-enthusiastic "Zelda")

(defn no-params
  []
  "I take no parameters!")

(defn one-param
  [x]
  (str "I take one parameter: " x))

(defn two-params
  [x y]
  (str "Two params! I take " x " and " y))

(def do-things)

(defn multi-arity
  ;; 3-arity arugments and body
  ([first-arg second-arg third-arg]
   (do-things first-arg second-arg third-arg))
  ([first-arg second-arg]
   (do-things first-arg second-arg))
  ([first-arg]
   (do-things first-arg)))

(defn x-chop
  "Describe the kind of chop you're inflecting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "!"))
  ([name]
   x-chop name "Karate"))

;; Another way of writing the above code is as follows.
(defn x-chop2 [name & [chop-type]]
  (str "I " (or chop-type "Karate") " chop " name "!"))

(x-chop2 "harry" "slap")

(defn weird-arity
  ([]
   "No Arity will return this string")
  ([number]
   (inc number)))

(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))

(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger "billy" "annie" "hulk")

(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my fav things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "cars")

;; Destructuring

(defn my-first
  [[first-thing second-thing]]
  second-thing)
(my-first ["oven" "car" "bike"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "Your unimportant choice is: "
                (clojure.string/join ", " unimportant-choices))))
(chooser ["Marmalade" "Handsome Jack" "Pigpen" "Aquaman"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treausre Lat: " lat))
  (println (str "Treausre lng: " lng)))

(defn announce-treasure-location2
  [{:keys [lat lng]}]
  (println (str "Treausre lat: " lat))
  (println (str "Treausre lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})
(announce-treasure-location2 {:lat 28.22 :lng 81.33})

;; function body
(defn illustrative-function
  []
  (+ 1 304)
  30
  "Joe")
(illustrative-function)

(defn number-comment
  [x]
  (if (< x 6)
    "Oh my gosh that number is low"
    "Wow what a high number"))
(number-comment 5)
(number-comment 7)

;; Anonymous functions
;;(fn [param-list]
;;  function body)

(map (fn [name] (str "Hi, " name))
     ["Darth Vader" "Magoo"])

((fn [x] (* x 3)) 8)

(def my-spec-multi (fn [x] (* x 3)))
(my-spec-multi 12)

#(* % 3)
(#(* % 3) 8)

(map #(str "Hi, " %)
     ["Darth vader" "Maggoo"])

;; Function call
(* 8 3)
;; Anony Call
#(* % 3)


((fn [bob jack] (* bob jack 3)) 8 5)
(#(* %1 %2 3) 8 5)

((fn [bob jack]
   {:key (* bob jack 3)})
 8 5)

(#(vector (* %1 %2 3)) 8 5)

((fn [bob jack]
   (hash-map :Brian (* bob jack 3)))
 8 5)

(hash-map :meitar (#(* %1 %2 3) 8 5))
(#(hash-map :meitar (* %1 %2 3)) 8 5)


(def hash-map-times-fn
  #(hash-map :Britar (* %1 %2 3)))

(map
  ;; (partial (fn [bob jack] (* bob jack 3)) 5)
  ;; (partial #(* %1 %2 3) 5)
  ;; (partial 
  ;;  (fn [bob jack] 
  ;;   (hash-map :Brian (* bob jack 3))) 5)
 (partial hash-map-times-fn 5)
 [(+ 1 1) 2 3 4])

(+ (* 1 1 (/ 20 5)) 3)

;; anon fn taking multi params
(#(str %1 " and " %2) "cornbread" "butter beans")

;; anon fn taking rest params
(#(identity %&) 1 "blarg" :yip)

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)



;; PUTTING IT ALL TOGETHER
;; HOBBIT MODEL

(def asym-hobbit-body-parts
  [{:name "head" :size 3}
   {:name "left-eye" :size 1}
   {:name "left-ear" :size 1}
   {:name "mouth" :size 1}
   {:name "nose" :size 1}
   {:name "neck" :size 2}
   {:name "left-shoulder" :size 3}
   {:name "left-upper-arm" :size 3}
   {:name "chest" :size 10}
   {:name "back" :size 10}
   {:name "left-forearm" :size 3}
   {:name "abdomen" :size 6}
   {:name "left-kidney" :size 1}
   {:name "left-hand" :size 2}
   {:name "left-knee" :size 2}
   {:name "left-thigh" :size 4}
   {:name "left-lower-leg" :size 3}
   {:name "left-achilles" :size 1}
   {:name "left-foot" :size 2}])

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)

;; LET
(let [x 3]
  x) ;; => 3

(def dalmation-list
  ["Pongo"])
(let [dalmations (take 2 dalmation-list)]
  dalmations)

(def x 0)
(let [x (inc x)] x)

(let [[pongo & dalmations] dalmation-list]
  [pongo dalmations])


(def dalmation-list
  ["Pongo"])
(let [[pongo & [perdita & dalmations]] dalmation-list]
  [pongo perdita dalmations])
(let [[pongo perdita & dalmations] dalmation-list]
  [pongo perdita dalmations])

(def dalmation-list
  ["Pongo" "Perdita"])
(defn bob [pongo & [perdita & dalmations]]
  [pongo perdita dalmations])
(defn bob2 [pongo perdita & dalmations]
  [pongo perdita dalmations])
(bob2 dalmation-list dalmation-list)



(def dalmation-list
  ["Pongo"])
(defn bob [pongo & [perdita & dalmations]]
  [pongo perdita dalmations])
(defn bob2 [pongo perdita & dalmations]
  [pongo perdita dalmations])
(bob (first dalmation-list) (second dalmation-list) (rest (drop 1 dalmation-list)))
(bob2 (first dalmation-list) (second dalmation-list) (rest (drop 1 dalmation-list)))



;; (def dalmation-list
;;   ["Pongo"])

;; (do 
;;   (println "starting code")
;;   (eval `(bob ~@dalmation-list))
;;   (println "bob 1 ran")
;;   (eval `(bob2 ~@dalmation-list))
;;   (println "bob 2 ran"))

;; ~@dalmation-list

;; `(bob ~@dalmation-list)

(into [] (set [:a :a]))

;; Loop

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))

;;same loop above as a fn
(defn recursive-printer
  ([]
    (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))
(recursive-printer)
(recursive-printer 1)

;;REGEX
(re-find #"^left-" "left-eye")
(re-find #"left-" "cleft-chin")
(re-find #"^left-" "cleft-chin")
(re-find #"^left-" "wronglebat")

;; REDUCE
(reduce + [1 2 3 4])
;;can be rewritten as:
(+ (+ (+ 1 2) 3) 4)

(reduce + 15 [ 1 2 3 4])

(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))

(defn better-symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (reduce (fn [final-body-parts part]
            (into final-body-parts (set [part (matching-part part)])))
          []
          asym-body-parts))

(defn hit
  [asym-body-parts]
  (let [sym-parts (better-symmetrize-body-parts asym-body-parts)
        body-part-size-sum (reduce + (map :size sym-parts))
        target (rand body-part-size-sum)]
     (loop [[part & remaining] sym-parts
             accumulated-size (:size part)]
        (if (> accumulated-size target)
          part
          (recur remaining (+ accumulated-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)

;;excersizes
(str "helllo " "bob")
(defn add-onehundred
  [x]
  (+ x 100))
(add-onehundred 20)
(defn dec-maker
  [x]
    #(- % x))
(def dec9 (dec-maker 9))
(dec9 10)


;; CLOJURE CORES
;; using seq
(defn titleize
  [topic]
  (str topic " for the Brave and True"))

(map titleize ["Hamsters" "Ragnarok"])
(map titleize '("Empathy" "Decorating"))
(map titleize #{"Elbows" "Soap Carving"})
(map #(titleize (second %)) {:uncomfortable-thing "Winking"})

(seq '(1 2 3))
(seq [1 2 3])
(seq #{1 2 3})
(seq {:name "bill" :occupation "lol"})

(into {} (seq {:a 1 :b 2 :c 3}))

;; map
(map inc [1 2 3])
(map str ["a" "b" "c"] ["A" "B" "C"])
;;as if map does the following
(list (str "a" "A") (str "b" "B") (str "c" "C"))


;;examples
(def human-consumption [8.1 7.3 6.6 5.0])
(def critter-consumption [0.0 0.2 0.3 1.1])
(defn unify-diet-data
  [human critter]
  {:human human
   :critter critter})

(map unify-diet-data human-consumption critter-consumption)


(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(stats [3 4 10])

(stats [80 1 44 13 6])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :alias identities)

;; reduce
(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:max 30 :min 10})

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:human 4.1
         :critter 3.9})

;; take / drop / take-while / drop-while
(take 3 [1 2 3 4 5 6 7 8 9])
(drop 3 [1 2 3 4 5 6 7 8 9])

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)
(drop-while #(< (:month %) 3) food-journal)
(take-while #(< (:month %) 4)
            (drop-while #(< (:month %) 2) food-journal))


;; Filter and Some
(filter #(< (:human %) 5) food-journal)
(filter #(< (:month %) 3) food-journal)


(some #(> (:critter %) 5) food-journal)  
(some #(> (:critter %) 3) food-journal)

(some #(and (> (:critter  %) 3) %) food-journal)