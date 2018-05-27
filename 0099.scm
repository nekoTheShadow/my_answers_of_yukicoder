(define (solve)
    (let* ((n (string->number (read-line)))
           (numbers (map string->number (string-split (read-line) #\space))))
        (let ((odd-cnt (count odd? numbers))
              (even-cnt (count even? numbers)))
            (abs (- odd-cnt even-cnt)))))

(begin
    (display (solve))
    (newline))
