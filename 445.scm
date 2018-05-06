(define (f n k)
	(inexact->exact
    (+ (* 50 n)
      (floor (/ (* 50 n)
             (+ (/ 8 10) (* (/ 2 10) k)))))))
             
(define (MAIN)
  (let* ((a (read))
         (b (read)))
    (display (f a b))
    (newline)))

(MAIN)
