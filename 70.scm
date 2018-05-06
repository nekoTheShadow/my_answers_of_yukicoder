(define (input->list)
    (let ((n (string->number (read-line))))
        (let loop ((cnt n)
                   (ls '()))
            (if (zero? cnt)
                ls
                (loop (- cnt 1)
                      (cons (map string->number
                                 (string-split (read-line) #[:#\space]))
                            ls))))))

(define (solve)
    (let loop ((items (input->list)) (sum 0))
        (if (null? items)
            sum
            (receive
                (h1 m1 h2 m2)
                (apply values (car items))
                (let* ((min1 (+ (* h1 60) m1))
                       (min2 (+ (* h2 60) m2))
                       (diff  (- min2 min1))
                       (duration (if (> diff 0) diff (+ 1440 diff))))
                    (loop (cdr items) (+ sum duration)))))))

(print (solve))
