#!/bin/bash

# カードの一覧と手の中のカードの種類の一覧を保持しておく。
cards=$(cat /dev/stdin)
types=$(for card in $cards; do echo $card; done | sort -g | uniq)

# 2枚組と3枚組のカードの種類を数える。
double=0
triple=0

for type in $types; do
	cnt=0
	for card in $cards; do
		[ $card -eq $type ] && cnt=$((cnt + 1))
	done
	
	[ $cnt -eq 2 ] && double=$((double + 1))
	[ $cnt -eq 3 ] && triple=$((triple + 1))
done

# 2枚組と3枚組の数から役を判定する。
if [ $triple -eq 1 -a $double -eq 1 ]; then
	echo "FULL HOUSE"
elif [ $triple -eq 1 ]; then
	echo "THREE CARD"
elif [ $double -eq 2 ]; then
	echo "TWO PAIR"
elif [ $double -eq 1 ]; then
	echo "ONE PAIR"
else 
	echo "NO HAND"
fi

