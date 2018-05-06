(define (solve a b)
  (let ((s (+ a b))
        (p (* a b)))
    (cond ((= s p) "E")
          ((< s p) "P")
          ((> s p) "S"))))
 
(define (Main)
  (let* ((a (read)) (b (read)))
    (display (solve a b))
    (newline)))

(Main)
