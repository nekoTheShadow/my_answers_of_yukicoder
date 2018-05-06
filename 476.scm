(define (solve)
  (let* ((first-line (map string->number (string-split (read-line) #\space)))
         (xs (map string->number (string-split (read-line) #\space)))

         (n (car first-line))
         (a (cadr first-line))
         (avg (/ (fold + 0 xs) n)))
    (if (= avg a) "YES" "NO")))

(begin
  (display (solve))
  (newline))
