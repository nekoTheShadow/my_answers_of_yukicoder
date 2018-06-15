#!/bin/bash

find . -maxdepth 1 -type f | sed 's/^\.\///; s/\./ /g' | while read id ext; do
  [[ ${#id} -eq 4 ]] && continue
  src="${id}.${ext}"
  dst=$(printf '%04d.%s' ${id} ${ext})
  mv -v ${src} ${dst}
done
