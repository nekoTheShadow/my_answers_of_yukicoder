(use srfi-13)

(define (MAIN) 
  (let ((n (read-line)))
    (let ((x (string-count n #\0))
          (y (string-count "1000000007" #\0)))
      (print (abs (- x y))))))

(MAIN)