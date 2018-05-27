(define (solve x y z)
    (let loop ((cnt 0)
               (smaller (- y x))
               (bigger (- z x)))
      (if (or (< smaller 1) (< bigger 3))
        (+ x
           cnt
           (max (quotient smaller 5) (quotient bigger 5)))
        (apply loop (+ cnt 1) (sort (list (- smaller 1) (- bigger 3)))))))

(define (MAIN)
  (let ((args (map string->number (string-split (read-line) #\space))))
    (print (apply solve (sort args)))))

(MAIN)
