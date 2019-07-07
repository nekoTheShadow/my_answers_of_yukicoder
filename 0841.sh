read s1 s2
c=31
if [[ $s1 =~ ^S ]]; then
  (( c = c + 1 ))
  [[ $s2 =~ ^S ]] && (( c = c + 1 ))
fi
echo "8/$c"