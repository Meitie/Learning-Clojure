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