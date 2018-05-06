(define (solve a b)
    (ceiling (/ b a)))

(define (MAIN)
    (let ((a (read))
          (b (read)))
        (print (solve a b))))

(MAIN)
