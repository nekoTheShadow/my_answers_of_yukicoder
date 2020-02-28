package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

func main() {
	n := readInt()
	a := make([][]int, 0)
	sum := 0
	for i := 0; i < n; i++ {
		p := readInt()
		a = append(a, []int{})
		sum += p
		for j := 0; j < p; j++ {
			a[i] = append(a[i], readInt())
		}
	}

	b := []int{}
	x := 0
	for i := 0; i < sum; i++ {
		for len(a[x]) == 0 {
			x = (x + 1) % n
		}
		b = append(b, a[x][0])
		a[x] = a[x][1:]
		x = (x + 1) % n
	}

	c := []string{}
	for _, v := range b {
		c = append(c, strconv.Itoa(v))
	}
	fmt.Println(strings.Join(c, " "))
}

var stdin *bufio.Scanner

func read() string {
	if stdin == nil {
		stdin = bufio.NewScanner(os.Stdin)
		stdin.Split(bufio.ScanWords)
		stdin.Buffer(make([]byte, bufio.MaxScanTokenSize), int(math.MaxInt32))
	}
	stdin.Scan()
	return stdin.Text()
}

func readInt() int {
	n, _ := strconv.Atoi(read())
	return n
}
