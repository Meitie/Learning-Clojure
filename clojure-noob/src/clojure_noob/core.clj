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

;; lists are similar to vectors in that they are a linear collection of values, 

;;okay