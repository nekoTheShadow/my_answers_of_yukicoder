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
	m := make([][]int, n)
	for i := 0; i < n; i++ {
		m[i] = make([]int, n)
	}

	x := 0
	y := 0
	dx := 0
	dy := 1
	diffs := [][]int{
		[]int{0, 1},
		[]int{0, -1},
		[]int{1, 0},
		[]int{-1, 0},
	}
	for i := 1; i <= n*n; i++ {
		m[x][y] = i

		if !(0 <= x+dx && x+dx < n && 0 <= y+dy && y+dy < n && m[x+dx][y+dy] == 0) {
			for _, diff := range diffs {
				ex := diff[0]
				ey := diff[1]
				if 0 <= x+ex && x+ex < n && 0 <= y+ey && y+ey < n && m[x+ex][y+ey] == 0 {
					dx = ex
					dy = ey
					break
				}
			}
		}
		x += dx
		y += dy
	}

	for _, row := range m {
		line := []string{}
		for _, v := range row {
			line = append(line, fmt.Sprintf("%03d", v))
		}
		fmt.Println(strings.Join(line, " "))
	}
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
