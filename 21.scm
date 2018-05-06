(define (MAIN)
  (let* ((n (read-line))
         (k (read-line))
         (numbers 
            (let loop ((ls '()) (line (read-line)))
              (if (eof-object? line)
                (reverse ls)
                (loop (cons (string->number line) ls) (read-line))))))
    (display (- (apply max numbers)
                (apply min numbers)))
    (newline)))

(MAIN)
