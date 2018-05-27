(print
    (let* ((l (read)) (k (read)))
        (receive
            (div mod)
            (div-and-mod l (* k 2))
            (if (zero? mod)
                (* (- div 1) k)
                (* div k)))))
