(define (solve f0 f1 n)
    (let ((f2 (logxor f0 f1))
          (mod (modulo n 3)))
        (cond ((= mod 0) f0)
              ((= mod 1) f1)
              ((= mod 2) f2))))

(print (apply solve (map string->number (string-split (read-line) #\space))))
