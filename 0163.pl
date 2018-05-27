get().split("")
     .map({$_.uc() eq $_ ?? $_.lc() !! $_.uc()})
     .join("")
     .say();
