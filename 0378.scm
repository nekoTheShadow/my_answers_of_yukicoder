(define (split-number number)
    (let loop ((x number) (numbers (list number)))
      (if (zero? x)
        (cdr numbers)
        (loop (quotient x 2) 
              (cons (quotient x 2) numbers)))))

(define (solve number)
  (let ((numbers (split-number number)))
    (let loop ((points numbers) (sums (list 0 0)))
      (if (null? points)
        (- (apply max sums)
           (reduce + 0 numbers))
        (loop (cdr points)
              (cons (+ (reduce + 0 (cdr points))
                        (* 2 (car points)))
                     sums))))))

(let ((number (read)))
  (display (solve number))
  (newline))
