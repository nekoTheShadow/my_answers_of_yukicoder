package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"time"
)

func main() {
	stdin := bufio.NewScanner(os.Stdin)
	stdin.Split(bufio.ScanWords)
	n, _ := strconv.Atoi(read(stdin))
	h, _ := strconv.Atoi(read(stdin))
	m, _ := strconv.Atoi(read(stdin))
	t, _ := strconv.Atoi(read(stdin))

	now := time.Now()
	x := time.Date(now.Year(), now.Month(), now.Day(), h, m, now.Second(), now.Nanosecond(), now.Location())
	y, _ := time.ParseDuration(fmt.Sprintf("%dm", t))
	for i := 0; i < n-1; i++ {
		x = x.Add(y)
	}
	fmt.Println(x.Hour())
	fmt.Println(x.Minute())
}

func read(stdin *bufio.Scanner) string {
	stdin.Scan()
	return stdin.Text()
}
