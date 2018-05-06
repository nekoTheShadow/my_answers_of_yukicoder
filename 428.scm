(define D
  (+ 1
     (* (fold (lambda (i sum) (+ (* sum 100) i))
              123456789
              (iota 90 10))
        10)))

(define N (read))

(define (MAIN)
  (let ((x (quotient (* N D) (expt 10 190)))
        (s (number->string (* N D))))

    (display
      (cond
        ((zero? x) (format "0.~A" s))
        ((< x 10)  (format "~A.~A" (substring s 0 1) (substring s 1 (string-length s))))
        ((< x 100)  (format "~A.~A" (substring s 0 2) (substring s 2 (string-length s))))))))

(MAIN)
