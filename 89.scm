(use math.const)

(let ((c (string->number (read-line))))
    (receive (r R) 
             (apply values (map string->number (string-split (read-line) #\space)))
        (display
            (/ (* (expt pi 2)
                  (expt (- R r) 2)
                  (+ R r)
                  c)
               4))
        (newline)))

