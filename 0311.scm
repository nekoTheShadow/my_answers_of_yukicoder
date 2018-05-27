(define (solve n)
    (* 2
       (+ (quotient n 3)
          (quotient n 5))))

(define (MAIN)
    (let ((N (read)))
        (print (solve N))))

(MAIN)
