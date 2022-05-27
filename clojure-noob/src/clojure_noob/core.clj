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

;; (or +)

;; ((or + -) 1 2 3) => 6
;; because or returns first truthy value (which is +) it then evals to 1+2+3

;; couple more functions that validate and return 6
;; ((and (= 1 1) +) 1 2 3) => 6
;; ((first [+ 0]) 1 2 3) => 6

;; numbers and strings are not functions so (1 2 3 4) / ("test" 1 2 3) would not work

;; WHEN YOU GET THE ERROR "<X> CANNOT BE CAST TO CLOJURE.LANG.IFN" then it means that you
;; are trying to use something as a function when it is not a function.

;; function flexibility syntactically functions can take any expressions as arguments
;; including other functions or return a function "These are called /higher order functions'/"

;; these are said to support first class functions as you can support and treat functions as values the same way you treat data types like numbers and vectors

;; map fn not to be confused by map data structure, creates a new list by applying a function to each member of the collection
;; (inc 1.1) => 2.1
;; (map inc [0 1 2 3]) => (1 2 3 4)

;; clojure evaluates all function arguments recursively before passing them to the function. 
;; here is how clojure would evaluate a function call whose arguments are also function calls;

;; (+ (inc 199) (/ 100 (- 7 2)));
;; -> (+ 200 (/ 100 (- 7 2))); // evaluated to "(inc 199)"
;; -> (+ 200 (/ 100 (5))); / evaluated (-7 2)
;; -> (+ 200 20) / evaltuated (/ 100 5)
;; => 200 / final evaluation.


;;==============================================
;; Function Calls, Macro Calls, Special Forms
;;==============================================

;; the thing that makes a special form `special` is that unlike fn calls, they don't always evaluate all of their
;; opperands, an example of a special form is an if statement

;; (if boolean-form
;;   then-form
;;   optional-else-form)

;; clearly we only want clojure to evaluate only one of the 2 coniditions, and it does so based on `boolean-form`.
;; another note on macro/fn calls is that they cannot be used as arugments to functions.


;;==============================================
;; Defining Functions
;;==============================================

;; Functions are composed with 5 main parts:
;; · defn
;; · Function name
;; · docstring describing fn (optional)
;; · Params listed in brackets
;; · Function body

;; 1&2 : (defn too-enthusiastic 
;; 3   :   "Return a cheer that might be a bit too enthusiastic"
;; 4   :   [name]
;; 5   :   (str "OH, MY. GOD! " name "YOU ARE MOST DEFINITLY LIKE THE BEST!"))

;; (too-enthusiastic "Zelda") -> how to call the fn

;; === The docstring === 
;; is a suseful way to describe and document your code. You can view it in the REPL with `(doc fn-name)` e.g (doc map).

;; === Parameters and Arity ===
;; Clojure fns can be defined with zero or more params, values passed ot fn are called args, adn the args can be any type
;; the number of params in the fn is arity, fns can have differetn arities.

;; (defn no-param 
;;   [] 
;;   "I take no pararms")
;; (defn one-param
;;   [x]
;;   (str "I take one parameter: " x))
;; (defn two-params
;;   [x y]
;;   (str "Two parameters! That's nothing! Pah! I will smoosh them "
;;        "together to spite you! " x y))

;; you can also define a fn with multiple arities, so it runs a different body depending on the reqs.

;; (defn multi-arity
;;   ;; 3-arity arguments and body
;;   ([first-arg second-arg third-arg]
;;    (do-things first-arg second-arg third-arg))
;;   ;; 2-arity arguments and body
;;   ([first-arg second-arg]
;;    (do-things first-arg second-arg))
;;   ;; 1-arity arguments and body
;;   ([first-arg]
;;    (do-things first-arg)))

;; NOTE: that each arity has its own set of parens around it. This is called "arity overload".


;; you can also add `rest parameter`, as in "put the rest of these argurments in a list with the following name".
;; the rest is indicated by an `&`. seen below examples:
;; when you provide arguments to variable-arity fns, the arguments are treated as a list, You can mix the params with normal parameters, but the rest parameter has to come last;
;; (defn codger-communication
;;   [whippersnapper]
;;   (str "Get off my lawn, " whippersnapper "!!!"))

;; (defn codger
;; ➊   [& whippersnappers]
;;   (map codger-communication whippersnappers))

;; (codger "Billy" "Anne-Marie" "The Incredible Bulk")
;; ; => ("Get off my lawn, Billy!!!" "Get off my lawn, Anne-Marie!!!" "Get off my lawn, The Incredible Bulk!!!")

;; (defn favorite-things
;;   [name & things]
;;   (str "Hi, " name ", here are my favorite things: "
;;        (clojure.string/join ", " things)))

;; (favorite-things "Doreen" "gum" "shoes" "kara-te")
;; ; => "Hi, Doreen, here are my favorite things: gum, shoes, kara-te"



;; === Destructuring === 

;; The basic idea behind destructuring is that it lets you concisely bind names to values within a collection:

;; Returns the first element of a collection
;; (defn my-first
;;   [[first-thing]]
;;   first-thing)
;; (my-first ["oven" "bike" "war-axe"]) => "oven"
;; in the above fn, the first element of the vector, you tell `my-first` to do this with `first-thing` in a vector'

;; when you destructure a vector a list, you can name as many elements as you want and also use a rest param
;; (defn chooser
;;   [[first-choice second-choice & unimportant-choices]]
;;   (println (str "Your first choice is: " first-choice))
;;   (println (str "Your second choice is: " second-choice))
;;   (println (str "We're ignoring the rest of your choices. "
;;                 "Here they are in case you need to cry over them: "
;;                 (clojure.string/join ", " unimportant-choices))))

;; (chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])
;; => Your first choice is: Marmalade 
;; => Your second choice is: Handsome Jack
;; => We're ignoring the rest of your choices. Here they are in case you need to cry over them: Pigpen, Aquaman

;; above the rest params `& unimportant-choses` handles any number of additional choices.

;; You can also destructure maps, in a same way that you tell clojute to desctructure above, but you destructure maps
;; by providaing a map as a parameter
;; (defn announce-treasure-location
;;   [{lat :lat lng :lng}]
;;   (println (str "Treasure lat: " lat))
;;   (println (str "Treasure lng: " lng)))

;; (announce-treasure-location {:lat 28.22 :lng 81.33})
;; => Treasure lat: 28.22
;; => Treasure lng: 81.33

;; We often want to just break keywords out of a map, so theres a shorter syntax for that
;; (defn announce-treasure-location
;;   [{:keys [lat lng]}]
;;   (println (str "Treasure lat: " lat))
;;   (println (str "Treasure lng: " lng)))

;; you can retain access to the previous map arugment by using the `:as` keyword, in the following example, you can 
;; access the following exmaple with the `treasure-location`

;; (defn recieve-treasure-location
;;   [{:keys [lat lng] :as treausre-location}]
;;   (println (str "Treasure lat: " lat)))
;;   (println (str "Treasure lng: " lng)))


;; === Function body === 

;; The function body can contain forms of any kind, Clojure automatically returns the last form evaled.
;; (defn illustrative-fn []
;;  (+ 5 3)
;;  "joe")
;; the above fn returns the value "joe"

;; (defn number-comment
;;   [x]
;;   (if (> x 6)
;;     "Oh my gosh! What a big number!"
;;     "That number's OK, I guess"))

;; (number-comment 5) => "That number's OK, I guess"
;; (number-comment 7) => "Oh my gosh! What a big number!"

;; all functions are created equal, which is the underlying simplicity of Clojure.


;; === Anonymous Functions === 

;; in clojure functions don't always need to have a name, in fact you use anon fn all the time.
;; There are 2 ways to create an annon fn
;; 1. fn and #

;; --- The `fn` form: ---
;; (fn [param-list]
;;    function body)

;; ((fn [x] (* x 3)) 8) => 24

;; You can treat fn nearly identical to defn, as it looks similar. The param list and body work the same,
;; as such you can use argument destructuring, rest params, etc, you can even `def` it to name it.
;; (def my-speical-multi (fn [x] (* x 3)))
;; (my-special-multi 12) => 36

;; --- the `#` form: ---
;; (#(* % 3) 8)
;; # = fn, % = param passed.

;; example passing an annon fn to an argument to a map:
;; (map #(str "Hi, " %)
;;    ["Darth Vader" "Mr. Magoo"]) 
;; => ("Hi, Darth Vader" "Hi, Mr. Magoo")

;; If your annon fn houses more then 1 arg, you can call them with %n, e.g %1 %2 %3