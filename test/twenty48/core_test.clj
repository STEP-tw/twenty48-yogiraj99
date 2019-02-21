(ns twenty48.core-test
  (:require [clojure.test :refer :all]
            [twenty48.core :refer :all]))

(deftest moving-grid-right
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 4)
             (0 0 2 4)
             (0 0 0 4)
             (0 0 0 8))
           (move-grid-right
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-left
  (testing "rows with numbers that repeat"
    (is (= '((4 0 0 0)
             (2 4 0 0)
             (4 0 0 0)
             (8 0 0 0))
           (move-grid-left
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-up
  (testing "rows with numbers that repeat"
    (is (= '((2 2 4 2)
             (0 4 4 4)
             (0 0 0 0)
             (0 0 0 0))
           (move-grid-up
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-down
  (testing "rows with numbers that repeat"
    (is (= '((0 0 0 0)
             (0 0 0 0)
             (0 2 4 2)
             (2 4 4 4))
           (move-grid-down
            '((0 0 2 2)
              (0 2 0 4)
              (2 0 2 0)
              (0 4 4 0)))))))

(deftest moving-grid-right-single
  (testing "move single grid right"
    (is (= '(0 0 0 4)
           (move-grid
            '(0 0 2 2))))))


(deftest transposing-grid
  (testing "transform colomns into rows"
    (is (= '((0 0 0 0)
             (2 4 2 8)
             (4 4 2 2)
             (0 0 0 4))
           (transpose
            '((0 2 4 0)
              (0 4 4 0)
              (0 2 2 0)
              (0 8 2 4)))))))


(deftest summing-up
  (testing "sums up vector"
    (is (= '(8 8 4 16)
           (sum-up
            '((0 4 4 0)
              (0 4 4 0)
              (0 2 2 0)
              (0 8 8 0)))))))


(deftest removes-zero
  (testing "filter out zeros from vector"
    (is (= '(4 4)
           (remove-zeros '(0 4 4 0))))))


