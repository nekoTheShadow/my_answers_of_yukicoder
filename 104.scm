(define (solve)
    (let ((line (read-line)))
        (fold
            (lambda (ch road) (if (equal? #\L ch) (* 2 road) (+ 1 (* 2 road))))
            1
            (string->list line))))

(begin
    (display (solve))
    (newline))
