(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I am a little teapot!"))




;;====================================
;; Naming Values with def
;;====================================
;; bindings in other languages may want you to assign multiple at once like in ruby

;; severity = :mild
;; error_message = "OH GOD! IT'S A DISASTER! WE'RE "
;; if severity == :mild
;; error_message = error_message + "MILDLY INCONVENIENCED!"
;; else
;; error_message = error_message + "DOOOOOOOMED!"
;; end

;; in Clojure you may be tempted to do similar, but you define 1 error message
;; and take in argument of severity which will allow us to check how sever

;; (defn error-message
;;   [severity]
;;   (str "OH GOD! IT'S A DISASTER! WE'RE "
;;        (if (= severity :mild)
;;          "MILDLY INCONVENIENCED!"
;;          "DOOOMED")))
;; (error-message :mild)



;;====================================
;; Data Structures
;;====================================

;; Numbers have integer, float, ratio
;; int 93, 1.2 float, 1/5 ratio

;; Strings
;; "Lord Voldemort"
;; "\"He who must not be named\""
;; "\"Great cow of Moscow!\" - Hermes Conrad"
;; Can only do string concat with `str` function

;; Maps
;; Key-Value pairs (like dict/hashs), they have hash maps and sorted maps
;; {}
;; {:first-name "Charlie"
;;  :last-name "McFishwich"}
;; Their values can be any type-strings, numbers, maps, vectors or functions.
;; (hash-map :a 1 :b 2)
;; (get {:a 0 :b 1} :b) => 1
;; (get {:a 0 :b {:c "ho hum"}} :b) => {:c "ho hum"}

;; treat the map as a fn, to look up the value
;; ({:name "The Human Coffeepot"} :name) => "The Human Coffeepot"


;;====================================
;; Vectors
;;====================================

;; vectors are 0-indexed collection, that can mix any types. and can also use the get fn
;; [3 2 1] => [3 2 1]
;; (get [3 2 1] 0) => 3
;; (get ["a" {:name "harry"} "c"] 1) => {:name "harry"}
;; (vector "creepy" "full" "moon") => ["creepy" "full" "moon"]

;; (conj [1 2 3] 4) => [1 2 3 4]


;;====================================
;; Lists
;;====================================

;; lists are similar to vectors in that they are a linear collection of values, there are some difference to vectors, e.g. You cannot retrieve a list element with get.
;; To write a list literal, just insert elements with a `'` before parenthesis

;; '(1 2 3 4) => (1 2 3 4)


;; to grab an element use the `nth` fn
;; (nth '(:a :b :c) 0) => :a
;; (nth '(:a :b :c) 2) => :c

;; lists can have any type just like vectors and you can create one with `list` fn
;; (list 1 "two" {3 4}) => (1 "two" {3 4})

;; elements are added to the beginning of a list
;; (conj '(1 2 3) 4) => (4 1 2 3)

;; When should you use a list and when should you use a vector? A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list. Otherwise, you should use a vector. As you learn more, you’ll get a good feel for when to use which.


;;====================================
;; Sets
;;====================================

;; Sets are collections of unique values, clojure has hash sets and sorted sets
;; literal notation for a hash set:

;; #{"kurt vonnegut" 20 :icicle}
;; can also  use  `hash-set` to create a set:

;; (hash-set 1 1 2 2) => #{1 2}
;; NOTE: that double's of a value are edited as you can only have 1 unique value

;; (conj #{:a :b} :b) => #{:a :b}
;; although you can conj to a set, there already exists so it is not added
;; you can also create a set from a vector
;; (set [3 3 3 4 4]) => #{3 4}

;; can check if it has membership with `contains?`, `get` returns the value, `contains?` returns true or false
;; depends if it contains the value or not
;; (contains? #{:a :b} :a) => true
;; (contains? #{:a :b} 3)  => false
;; (contains? #{nil} nil)  => true

;; how to use a keyword
;; (:a #{:a :b}) => :a

;; how you use get
;; (get #{:a :b} :a)     => :a
;; (get #{:a nil} nil)   => nil
;; (get #{:a :b} "kurt") => nil

;; note when using get, to test if a set contains nil, will always return nil, which may be confusing so you could
;; instead use the "contains?" operator to test for nil.



;; ======================================================
;;  FUNCTIONS
;; ======================================================
;;
;; different kinds of `fn's`, 
;; • Calling fns 
;; • How fn different from macros and special forms
;; • Defining fns
;; • Anonymous fns
;; • Returning fns

;;====================================
;; Calling functions:
;;====================================

;; (+ 1 2 3 4)       => 10
;; (* 1 2 3 4)       => 24
;; (first [1 2 3 4]) => 1
;; remember that all clojure opertaions have the same syntax,opening paren -> operator -> operands -> closing parentheis
;; fn operation = where the operatorsis a fn
;; fn expressions = an expression that returns a fn