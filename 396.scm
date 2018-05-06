(define (f n m t)
  (let1 g (modulo t (* m 2))
    (if (< g m)
      g
      (- (- (* 2 m) 1) g))))

(define (MAIN)
  (let* ((n (read))
         (m (read))
         (x (read))
         (y (read)))
    (if (= (f n m (- x 1)) (f n m (- y 1)))
      "YES"
      "NO")))

(print (MAIN))
