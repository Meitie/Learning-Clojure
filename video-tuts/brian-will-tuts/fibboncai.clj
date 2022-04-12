(defn fib [n]
  (loop [a 1 b 0 cnt n]
    (if (zero? cnt)
      b
      (recur (+ a b) a (dec cnt)))))

(map fib (range 10))