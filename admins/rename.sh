#!/bin/bash

find . -maxdepth 1 -type f | sed 's/^\.\///; s/\./ /g' | while read id ext; do
  src="${id}.${ext}"
  dst=$(printf '%04d.%s' ${id} ${ext})
  mv -v ${src} ${dst}
done
