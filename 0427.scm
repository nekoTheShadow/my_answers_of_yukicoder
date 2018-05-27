(define (f h w)
  (if (> h w) "TATE" "YOKO"))

(define (MAIN)
  (let ((h (read)) (w (read)))
    (display (f h w))
    (newline)))

(MAIN)
