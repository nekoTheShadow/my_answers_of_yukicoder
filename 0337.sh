#!/bin/bash
read n p; ((p == n*p)) && echo '=' || echo '!='
