(ns object-spec
  (:require [object :refer :all]
            [spec-util :refer :all]
            [speclj.core :refer :all]))

(describe "object"
  (it "accelerates"
    (should= [1 1] (:velocity (accelerate {:velocity [0 0] :mass 1 :force [1 1]})))
    (should= [1/2 1/2] (:velocity (accelerate {:velocity [0 0] :mass 2 :force [1 1]})))
    (should= [3/2 3/2] (:velocity (accelerate {:velocity [1 1] :mass 2 :force [1 1]}))))

  (it "moves"
    (should= [1 1] (:position (move {:velocity [1 1] :position [0 0]}))))

  (it "calulates force between two objects"
    (should= [0 0]
             (force-between {:position [0 0] :mass 1} {:position [0 0] :mass 1}))
    (should= [-0.353552 -0.353552]
             (map round6
                  (force-between {:position [0 0] :mass 1} {:position [1 1] :mass 1})))
    )
  )