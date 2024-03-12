(ns gravity
  (:require [quil.core :as q]
            [quil.middleware :as m]
            [vectors :as v]
            [world]))

(def SCREEN [1500 1000])
(def CENTER_OFFSET (atom [(/ (first SCREEN) 2)
                          (/ (second SCREEN) 2)]))

(defn setup []
  (q/frame-rate 30)
  (q/color-mode :rgb)
  (world/make))

(defn update-state [world]
  (when (q/mouse-pressed?)
    (reset! CENTER_OFFSET [(q/mouse-x) (q/mouse-y)]))
  (world/update world))

(defn draw-world [world]
  (if (empty? world)
    nil
    (let [o (first world)
          [x y] (:position o)
          diameter (condp >= (:mass o)
                     1 3
                     5 5
                     10 8
                     20 12
                     600 15
                     30)
          color (condp <= (:mass o)
                  100 [255 255 0]
                  [0 255 0])]
      (apply q/fill color)
      (q/ellipse (+ x (first @CENTER_OFFSET))
                 (+ y (second @CENTER_OFFSET))
                 diameter diameter)
      (recur (rest world)))))

(defn draw-state [world]
  (q/background 240)
  (let [messages (map #(prn-str (:name %) (int (v/magnitude (:position %)))) world)]
    (q/fill 0 0 0)
    (q/text (apply str messages) 10 10))

  (q/fill 0 255 0)
  (draw-world world))


(q/defsketch gravity
  :title "Gravity"
  :size SCREEN
  :setup setup
  :update update-state
  :draw draw-state
  :features [:keep-on-top]
  :middleware [m/fun-mode])

(defn -main [& args]
  (println "gravity has begun."))
