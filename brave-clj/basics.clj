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
   {:key(* bob jack 3)})
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