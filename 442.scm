(define (Main)
  (let* ((a (read)) (b (read)))
    (display (gcd (+ a b) (* a b)))
    (newline)))
    
(Main)
