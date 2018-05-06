(define (solve n)
  (let loop ((x n) (ls '()))
    (if (zero? x)
      (string-join ls "")
      (loop (quotient (- x 1) 2)
            (cons (if (odd? x) "L" "R") ls)))))

(define (MAIN)
  (let loop ((n (string->number (read-line))) (ls '()))
    (if (zero? n)
      (string-join (reverse ls) "\n")
      (loop (- n 1) 
            (cons (solve (string->number (read-line))) ls)))))


(print (MAIN))
