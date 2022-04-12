; Will throw overflow exception for n greater
; than 20 because * only accepts and returns Long values.
; Recursive

(defn factorial [n]
  (if (= n 0) 1 
      (* n (factorial (dec n)))))

(factorial 20)


; Uses arbitrary precision math function, so it works for n greater than 20.
; On different systems it will reach different stacks before a stack overflow happens
; (this will vary from systme to system.)

(defn factorial-bigint [n]
  (if (= n 0) 1
      ;the function *' returns arbitrary precision numbers (clojure.lang.BigIng)
      (*' n (factorial-bigint (dec n)))))

(factorial-bigint 21)


(defn factorial-bigint-recur [n]
  (if (n = 0) 1
      ; EVALUTAION ERROR! recur is not in tail position
      (* n (recur (dec n)))))

; does not consume additional stack space for each iteration because it is uing 'recur' fn
(defn factorial-bigint-loop [n]
  (if (= n 0) 1 
     (loop [val n i n]
       (if (<= i 1) val 
           (recur (*' val (dec i)) (dec i))))))

(factorial-bigint-loop 100)