(define (MAIN)
  (let* ((n (string->number (read-line)))
        (numbers (map string->number (string-split (read-line) #\space)))
        (ht (make-hash-table)))
    (for-each
      (lambda (number) (hash-table-put! ht number (+ 1 (hash-table-get ht number 0))))
      numbers)
    (display
      (hash-table-fold ht
                      (lambda (ky val cnt) (if (= val 1) (+ 1 cnt) cnt))
                      0))
    (newline)))

(MAIN)
