(let ((n (read)))
    (display
        (if (even? n)
            (make-string (quotient n 2) #\1)
            (let ((x (- (quotient n 2) 1)))
                (string-append "7" (make-string x #\1)))))
    (newline))
