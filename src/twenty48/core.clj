(ns twenty48.core
  (:gen-class))

(def remove-zeros (partial remove zero?))

(def partition-by-identity (partial partition-by identity))

(def partition-by-2
  (comp
   (partial mapcat (partial partition-all 2))
   (partial partition-by-identity)))

(def sum-up
  (partial map (partial apply +)))

(def transpose
  (partial apply mapv vector))

(def move-grid
  (comp
   (partial take-last 4)
   (partial concat (repeat 4 0))
   (partial reverse)
   (partial sum-up)
   (partial partition-by-2)
   (partial reverse)
   (partial remove-zeros)))

(def move-grid-right
  "Moves an entire grid to the right"
  (partial map move-grid))

(def move-grid-left
  "Moves an entire grid to the left"
  (comp
   (partial map reverse)
   (partial move-grid-right)
   (partial map reverse)))

(def move-grid-down
  "Moves an entire grid down"
  (comp
   (partial transpose)
   (partial move-grid-right)
   (partial transpose)))

(def move-grid-up
  "Moves an entire grid up"
  (comp
   (partial transpose)
   (partial map reverse)
   (partial move-grid-right)
   (partial map reverse)
   (partial transpose)))
