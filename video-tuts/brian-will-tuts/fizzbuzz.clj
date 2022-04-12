;; this will be the fizzbuzz game
; [1 2 fizz 4 buzz 6 7 8 fizz buzz 11 fizz 13 14 fizzbuzz]
;; replace every 3rd - fizz, 5th - buzz, 15 - fizzbuzz

(defn fizzbuzz []
  (loop [i 1]
    (if (<= i 100)
      (do
        (if (and (= (rem i 3) 0) (= (rem i 5)) 0)
          (println "FizzBuzz")
          (if (= (rem i 3) 0)
            (println "Fizz")
            (if (= (rem i 5) 0)
              (println "Buzz")
              (println i))))
        (recur (inc i))))))



(defn fizz-buzz []
  (loop [i 1]
    ))




(fizzbuzz [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16])