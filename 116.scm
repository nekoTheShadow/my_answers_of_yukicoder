(define (f x y z)
  (and (not (= x y))
       (not (= y z))
       (not (= z x))
       (or (= y (max x y z))
           (= y (min x y z)))))

(define (MAIN)
  (let* ((n (string->number (read-line)))
         (ls (map string->number (string-split (read-line) #\space))))
    (let loop ((numbers ls) (size n) (cnt 0))
      (if (< size 3)
        (print cnt)
        (loop (cdr numbers) 
              (- size 1)
              (if (apply f (take numbers 3)) (+ 1 cnt) cnt))))))


(MAIN)
