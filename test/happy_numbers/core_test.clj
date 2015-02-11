(ns happy-numbers.core-test
  (:require [clojure.test :refer :all]
            [happy-numbers.core :refer :all]))

(defn my-contains [needle haystack]
  (or
   (some #(= needle %) haystack)
   false))


(some #(= % 1) '(1))
; true

(some #(= % 2) '(1))
; nil

(my-contains 1 [1])
; true

(my-contains 2 [1])
; false

