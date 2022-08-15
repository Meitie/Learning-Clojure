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