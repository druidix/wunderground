(ns wunderground.core-test
  (:require [clojure.test :refer :all]
            [wunderground.core :refer :all]))

(deftest a-test
  (testing "Wunderground returns 200"
    (is (= 200 (-main)))))
