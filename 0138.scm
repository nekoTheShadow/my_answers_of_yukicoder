(define (solve pivot-version version)
  (let* ((temp-pivot (map string->number (string-split pivot-version ".")))
         (temp (map string->number (string-split version ".")))
         (pivot-a (car temp-pivot))
         (pivot-b (cadr temp-pivot))
         (pivot-c (caddr temp-pivot))
         (a (car temp))
         (b (cadr temp))
         (c (caddr temp)))
    (cond 
      ((< pivot-a a) "NO")
      ((> pivot-a a) "YES")
      (else
        (cond
          ((< pivot-b b) "NO")
          ((> pivot-b b) "YES")
          (else
            (if (< pivot-c c)
              "NO"
              "YES")))))))


(let* ((pivot-version (read-line))
       (version (read-line)))
  (display (solve pivot-version version))
  (newline))
