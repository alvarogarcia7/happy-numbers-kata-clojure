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

(def happy-numbers-less-equal-100
  [1, 7, 10, 13, 19, 23, 28, 31, 32, 44, 49, 68, 70, 79, 82, 86, 91, 94, 97, 100])

(defn is-happy-number [n]
  (= 1 n))

(=
 (is-happy-number 1)
 true)

(=
 (is-happy-number 2)
 false)

(=
 (is-happy-number 7)
 true)

(defn sum-squared-numbers [numbers]
  (reduce
   +
   (map #(* % %)
       numbers)))

(=
 (sum-squared-numbers '(1, 2))
 5)

(=
 (sum-squared-numbers '(1, 2, 3, 4))
 30)

(defn split-into-numbers [n]
  (let [from-int-to  #(- % (int \0))
        from-str-to-int #(int %)]
    (map from-int-to
      (map from-str-to-int (str n))))
  )

(=
 (split-into-numbers 12)
 '(1, 2))

