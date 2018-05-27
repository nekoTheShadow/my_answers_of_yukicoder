(use srfi-13)

(define (convert ch)
  (if (or (equal? ch #\I) (equal? ch #\l))
    #\1
    (if (or (equal? ch #\O) (equal? ch #\o))
      #\0
      ch)))

(define (MAIN)
  (let ((s (read-line)))
    (print (string-map convert s))))

(MAIN)