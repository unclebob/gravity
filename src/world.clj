(ns world
  (:require [object]))

(defn make []
  [(object/make "Star" 10000 [0 0] [0 0])
   (object/make "Planet 0" 1 [50 0] [0 15])
   (object/make "Planet 1" 1 [100 0] [0 10])
   (object/make "Planet 2" 1 [-120 0] [0 -9])
   (object/make "Planet 3" 1 [0 140] [-8 0])
   (object/make "Planet 4" 1 [0 -160] [7.5 0])
   (object/make "Planet 5" 5 [250 0] [0 6])
   (object/make "Planet 6" 5 [-280 0] [0 -5.8])
   (object/make "Planet 7" 10 [350 0] [0 5.3])
   (object/make "Planet 8" 10 [-400 0] [0 -5])
   (object/make "Planet 9" 20 [0 440] [-4.8 0])
   (object/make "Interloper" 500 [0 -2000] [1 0])
   ])

(defn sum-forces [world]
  (map #(object/sum-forces world %) world))

(defn accelerate [world]
  (map object/accelerate world))

(defn move [world]
  (map object/move world))

(defn update [world]
  (-> world sum-forces accelerate move))
