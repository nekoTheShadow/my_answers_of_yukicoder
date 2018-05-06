(define (solve)
    (receive (x y)
             (apply values (map string->number (string-split (read-line) #\space)))
        (let* ((r (* 2 (sqrt (+ (expt x 2) (expt y 2)))))
               (s (ceiling->exact r)))
            (if (= r s) (+ 1 s) s))))

(begin
    (display (solve))
    (newline))
