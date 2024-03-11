(ns spec-util)

(defn round [v n]
  "round v to n decimals"
  (let [f (apply * (repeat n 10))
        vf (* f v)
        rvf (+ vf 0.5)]
    (/ (long rvf) (double f))))

(defn round6 [v] (round v 6))