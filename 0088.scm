(use srfi-13)

(define (solve)
    (let* ((player1 (read-line))
           (cnt
               (let loop ((line (read-line)) (x 0))
                   (if (eof-object? line)
                       x
                       (loop (read-line) (+ x (string-count line #[wb]))))))
           (player2 (if (equal? player1 "oda") "yukiko" "oda")))
        (if (even? cnt) player1 player2)))

(begin
    (display (solve))
    (newline))
