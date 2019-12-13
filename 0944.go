package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
)

func main() {
	n := readInt()
	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = readInt()
	}

	sum := 0
	for _, v := range a {
		sum += v
	}

	factors := []int{}
	for i := 1; i*i <= sum; i++ {
		if sum%i == 0 {
			j := sum / i
			factors = append(factors, i)
			factors = append(factors, j)
		}
	}
	sort.Ints(factors)

	for _, x := range factors {
		if ok(a, x) {
			fmt.Println(sum / x)
			break
		}
	}
}

func ok(a []int, x int) bool {
	sum := 0
	for _, v := range a {
		sum += v
		if sum == x {
			sum = 0
		} else if x < sum {
			return false
		}
	}
	return true
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
