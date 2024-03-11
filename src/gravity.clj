(ns gravity
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [world]))

(defn setup []
  (q/frame-rate 60)
  (q/color-mode :rgb)
  (world/make))

(defn update-state [world]
  (world/update world))

(defn draw-world [world]
  (if (empty? world)
    nil
    (let [o (first world)
          [x y] (:position o)
          diameter (condp >= (:mass o)
                     1 3
                     2 5
                     10 10
                     30)]
      (q/ellipse (+ x 500) (+ y 500) diameter diameter)
      (recur (rest world)))))

(defn draw-state [world]
  (q/background 240)
  (let [message (apply str (map #(prn-str (:name %) (map int (:position %))) world))]
    (q/fill 0 0 0)
    (q/text message 10 10))
  (q/fill 0 255 0)
  (draw-world world))


(q/defsketch gravity
  :title "Gravity"
  :size [1000 1000]
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])

(defn -main [& args]
  (println "gravity has begun."))
