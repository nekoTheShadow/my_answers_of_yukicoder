(use util.combinations)

(define (solve n)
  (sort
    (map
      (lambda (lst) (* (expt 2 (car lst)) (expt 5 (cadr lst))))
      (cartesian-product (list (iota (+ n 1)) (iota (+ n 1)))))))

(define (MAIN)
  (let ((n (string->number (read-line))))
    (for-each print (solve n))))

(MAIN)