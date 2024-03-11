(ns vectors)

(defn add [[x1 y1] [x2 y2]]
  [(+ x1 x2) (+ y1 y2)])

(defn subtract [[x1 y1] [x2 y2]]
  [(- x1 x2) (- y1 y2)])

(defn magnitude [[x y]]
  (Math/sqrt (+ (* x x) (* y y))))

(defn scale [[x y] s]
  [(* x s) (* y s)])

(defn unit-vector [[x y :as v]]
  "preserves direction and sets magnitude to 1"
  (when (and (zero? x) (zero? y))
    (throw (Exception. "cannot create unit vector")))
  (scale v (/ 1.0 (magnitude v)))
  )


