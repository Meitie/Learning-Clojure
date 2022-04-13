;; (+ 1 2 3 5)

;; ; "the ; is the comments in clojures"

;; (type "String")
;; (type 11)
;; (type nil)
;; (type 12.0)

;; ; 'something = tells clojure to ignore evalutaings the next thing
;; ; ^ the above is called a symbol

;; 'something


;; vars
;; (def temp
;;   'something)

;; temp

;; (comment
;;   ;; comment form so that the code does not actually get submitted
;;   )


;; (vector 1 2 3)

;; (def temp-vector
;;   [1 2 3 "something" \c])

;; (def temp-list 
;;   (list 1 2 3))

;; `(1 2 3)
;; ;; list -> list programming
;; ;; everything is DATA

;; (conj temp-vector 10)
;; (conj temp-list 10)

;; ;; Note for how conj list its added to front but conj vector added to the end

;; ;;polymorphism
;; (coll? temp-vector)
;; (seq? temp-vector)
;; (seq temp-vector)

;; (second temp-list)

;; (set [1 2 3 3 3 3 3])

;; (def temp-set
;;   #{1 2 3})

;; temp-set
;; (comment
;;   temp-vector
;;   temp-list
;;   ;;
;;   )


;;hash maps
(hash-map "a" 1
          "b" 2)

(def temp-map
  {:strings [1 2 {"a" "b"}]
   :some-key :some-value
   :nested-thing {:another-key "value"}})

temp-map

;; get
(get temp-map :some-key)
(get (get temp-map :nested-thing) :another-key)
(get-in temp-map [:nested-thing :another-key])
;; mutations
