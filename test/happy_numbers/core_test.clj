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
  (happy? n []))

(defn happy? [n visited]
  (if (my-contains n visited)
    (do
      (println (str n " " visited))
      false)
    (if (= 1 n)
      (do
        (println (str n " " (conj visited 1)))
        true)
      (let [sum-of-squares (sum-squared-numbers (split-into-numbers n))
            new-visited (conj visited n)]
        (happy? sum-of-squares new-visited)))))

(count [1 2])

(defn happy-size? [n visited]
  (if (my-contains n visited)
      (- (count visited))
    (if (= 1 n)
      (let [visited (conj visited 1)]
        (count visited))
      (let [sum-of-squares (sum-squared-numbers (split-into-numbers n))
            new-visited (conj visited n)]
        (happy-size? sum-of-squares new-visited)))))

(= (happy? 1 []) true)
(= (happy? 4 []) false)
(= (happy? 7 []) true)

(= (happy-size? 2 []) 9)
(= (happy-size? 1 []) 1)
(happy-size? 7 [])

(apply max '(1 2 3))

(range 1 100)

(map #(happy-size? % []) (range 1 1000))

(apply max (map #(happy-size? % []) (range 1 100)))

(map #(happy-size? % []) '(1 2))


(sum-squared-numbers (split-into-numbers 10))

(happy? 97 [7 49])


(=
 (is-happy-number 1)
 true)

(conj [1] 1)

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

