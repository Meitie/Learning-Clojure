;; this will be the fizzbuzz game
; [1 2 fizz 4 buzz 6 7 8 fizz buzz 11 fizz 13 14 fizzbuzz]
;; replace every 3rd - fizz, 5th - buzz, 15 - fizzbuzz

(defn fizz-buzz []
  (loop [i 1]
    (if (<= i 100)
      (do
        (if (and (= (rem i 3) 0) (= (rem i 5) 0))
          (println "FizzBuzz")
          (if (= (rem i 3) 0)
            (println "Fizz")
            (if (= (rem i 5) 0)
              (println "Buzz")
              (println i))))
        (recur (inc i))))))

(fizz-buzz)

;; using macro called "cond". kinda similar to a switch statements in java

(defn fizz-buzz-cond []
  (loop [i 1]
    (if (<= i 100)
      (do
        (cond
          (and (= (rem i 3) 0) (= (rem i 5) 0)) (println "FizzBuzz")
          (= (rem i 3) 0) (println "Fizz")
          (= (rem i 5) 0) (println "Buzz")
          :else (println i))
        (recur (inc i))))))


(fizz-buzz-cond)
