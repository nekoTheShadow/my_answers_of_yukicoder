(define (f d1 d2 d3 s)
  (or (= s 1)
      (< (+ d1 d2 d3) 2)))

(define (MAIN)
  (display
    (if (apply f (map string->number (string-split (read-line) #\space)))
      "SURVIVED"
      "DEAD"))
  (newline))
  
(MAIN)

