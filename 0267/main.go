package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
	"strconv"
	"strings"
)

func exec(stdin *Stdin, stdout *Stdout) {
	n := stdin.ReadInt()
	cards := make([]string, n)
	for i := 0; i < n; i++ {
		cards[i] = stdin.Read()
	}

	scores := map[string]int{
		"D": 0,
		"C": 1,
		"H": 2,
		"S": 3,
	}
	integers := map[string]int{
		"A": 1,
		"T": 10,
		"J": 11,
		"Q": 12,
		"K": 13,
	}
	for i := 2; i <= 9; i++ {
		integers[strconv.Itoa(i)] = i
	}

	sort.Slice(cards, func(i, j int) bool {
		s1 := scores[cards[i][0:1]]
		s2 := scores[cards[j][0:1]]
		if s1 != s2 {
			return s1 < s2
		}

		t1, _ := integers[cards[i][1:]]
		t2, _ := integers[cards[j][1:]]
		return t1 < t2
	})

	stdout.Println(strings.Join(cards, " "))
}

func main() {
	stdout := NewStdout()
	defer stdout.Flush()
	exec(NewStdin(bufio.ScanWords), stdout)
}

type Stdin struct {
	stdin *bufio.Scanner
}

func NewStdin(split bufio.SplitFunc) *Stdin {
	s := Stdin{bufio.NewScanner(os.Stdin)}
	s.stdin.Split(split)
	s.stdin.Buffer(make([]byte, bufio.MaxScanTokenSize), int(math.MaxInt32))
	return &s
}

func (s *Stdin) Read() string {
	s.stdin.Scan()
	return s.stdin.Text()
}

func (s *Stdin) ReadInt() int {
	n, _ := strconv.Atoi(s.Read())
	return n
}

func (s *Stdin) ReadFloat64() float64 {
	n, _ := strconv.ParseFloat(s.Read(), 64)
	return n
}

type Stdout struct {
	stdout *bufio.Writer
}

func NewStdout() *Stdout {
	return &Stdout{bufio.NewWriter(os.Stdout)}
}

func (s *Stdout) Flush() {
	s.stdout.Flush()
}

func (s *Stdout) Println(a ...interface{}) {
	fmt.Fprintln(s.stdout, a...)
}
