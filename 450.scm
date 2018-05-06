(define (MAIN)
  (let* ((vl (read))
         (vr (read))
         (d (read))
         (w (read)))
    (exact->inexact (* (/ d (+ vl vr)) w))))

(print (MAIN))
