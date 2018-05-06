get().split("")
     .reduce({$^sum + ($^val ~~ /\d/ ?? Int($^val) !! 0)})
     .say();
