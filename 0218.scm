(define (f a b c)
    (let ((normal (ceiling (/ a b)))
          (special (ceiling (/ a c))))
        (>= (* normal (/ 2 3))
            special)))

(define (MAIN)
    (let ((a (read)) (b (read)) (c (read)))
        (display (if (f a b c) "YES" "NO"))
        (newline)))

(MAIN)
