(use srfi-13)
(use srfi-14)

(define (validate-integer? token)
  (let ((ls (string->list token)))
    (or (and (equal? #\0 (car ls)) (= 1 (length ls)))
        (and (not (equal? #\0 (car ls)))
             (every (cut char-set-contains? char-set:digit <>) ls)))))

(define (validate? token)
  (and (validate-integer? token)
        (let ((x (string->number token)))
          (and (<= 0 x) (<= x 12345)))))

(define (Main)
  (let ((a (read-line)) (b (read-line)))
    (display (if (every validate? (list a b)) "OK" "NG"))
    (newline)))

(Main)
