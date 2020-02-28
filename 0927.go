package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strings"
)

func main() {
	stdin := bufio.NewScanner(os.Stdin)
	stdin.Split(bufio.ScanLines)
	stdin.Buffer(make([]byte, bufio.MaxScanTokenSize), int(math.MaxInt32))

	x := read(stdin)
	chars := strings.Split(x, "")
	sort.Strings(chars)

	p := 0
	for p < len(chars)-1 && chars[p] == chars[p+1] {
		p++
	}

	ok := false
	for i := p; i < len(chars); i++ {
		if chars[p] != chars[i] {
			chars[p], chars[i] = chars[i], chars[p]
			ok = true
			break
		}
	}

	if ok {
		var sb strings.Builder
		for i := len(chars) - 1; i >= 0; i-- {
			sb.WriteString(chars[i])
		}

		y := sb.String()
		if strings.HasPrefix(y, "0") {
			fmt.Println(-1)
		} else {
			fmt.Println(y)
		}
	} else {
		fmt.Println(-1)
	}
}

func read(stdin *bufio.Scanner) string {
	stdin.Scan()
	return stdin.Text()
}
