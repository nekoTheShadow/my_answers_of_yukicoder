#!/bin/bash
read x
if ((x==0)) || ((x==4)) || ((x==10)); then
  echo Yes
else
  echo No
fi