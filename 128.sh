#!/bin/bash

read budget
read person

echo $((budget / person / 1000 * 1000))
