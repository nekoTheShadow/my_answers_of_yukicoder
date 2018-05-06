(use util.combinations)

(define (kadomatsu? x y z)
  (and (not (= x y))
       (not (= y z))
       (not (= z x))
       (< x z)
       (or (= y (min x y z))
           (= y (max x y z)))))

(define (increasing-kadomatsu? numbers)
  (let loop ((ls numbers))
    (if (< (length ls) 3)
      #t
      (if (apply kadomatsu? (take ls 3))
        (loop (cdr ls))
        #f))))

(define (MAIN)
    (let loop ((numbers-list (permutations (map string->number (string-split (read-line) #\space)))))
      (if (null? numbers-list)
        "NO"
        (if (increasing-kadomatsu? (car numbers-list))
          "YES"
          (loop (cdr numbers-list))))))
 
 (print (MAIN))
