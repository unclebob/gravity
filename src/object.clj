(ns object
  (:require [vectors :as v]))

(defn make [name mass position velocity]
  {:name name
   :mass mass
   :position position
   :velocity velocity})

(defn force-between [o1 o2]
  (if (= (:position o1) (:position o2))
    [0 0]
    (let [vector-between (v/subtract (:position o1) (:position o2))
          distance (max 1 (v/magnitude vector-between))
          force-magnitude (/ (* (:mass o1) (:mass o2)) (* distance distance))
          force-direction (v/unit-vector vector-between)]
      (v/scale force-direction force-magnitude))))

(defn sum-forces [world object]
  (loop [world world
         force [0 0]]
    (if (empty? world)
      (assoc object :force force)
      (let [f (force-between object (first world))
            new-force (v/add force f)]
        (recur (rest world) new-force)))))

(defn accelerate [{:keys [mass force velocity] :as o}]
  (let [acceleration (v/scale force (/ -1 mass))]
    (assoc o :velocity (v/add velocity acceleration))))

(defn move [{:keys [position velocity] :as o}]
  (assoc o :position (v/add position velocity)))

