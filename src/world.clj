(ns world
  (:require [object]))

(defn make []
  [(object/make "Star" 1000 [0 0] [0 0])
   (object/make "Planet 1" 1 [300 0] [0 1])
   (object/make "Planet 2" 2 [0 400] [-1 0])
   (object/make "Planet 3" 10 [-400 -400] [1/2 -1/2])
   (object/make "Planet 4" 2 [0 200] [-2 0])
   ])

(defn sum-forces [world]
  (map #(object/sum-forces world %) world))

(defn accelerate [world]
  (map object/accelerate world))

(defn move [world]
  (map object/move world))

(defn update [world]
  (-> world sum-forces accelerate move))
