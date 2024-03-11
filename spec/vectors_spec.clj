(ns vectors-spec
  (:require [speclj.core :refer :all]
            [vectors :refer :all]
            [spec-util :refer :all]))

(describe "vectors"
  (it "adds"
    (should= [2 3] (add [1 1] [1 2])))

  (it "creates vector between two points"
    (should= [1 2] (subtract [2 3] [1 1])))

  (it "calculates magnitude"
    (should= 0.0 (magnitude [0 0]))
    (should= 1.0 (magnitude [0 1]))
    (should= 5.0 (magnitude [3 4])))

  (it "scales a vector"
    (should= [3 6] (scale [1 2] 3)))

  (it "calculates vector of magnitude 1 with same direction"
    (should-throw (unit-vector [0 0]))
    (should= [0.0 1.0] (unit-vector [0 1]))
    (should= [1.0 0.0] (unit-vector [1 0]))
    (should= [0.6 0.8] (map round6 (unit-vector [3 4]))))
  )

