package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

const INFINITY = math.MaxInt64/2 - 1

func exec(stdin *Stdin, stdout *Stdout) {
	n := stdin.ReadInt()
	m := stdin.ReadInt()
	a := make([]int, n)
	for i := 0; i < n; i++ {
		a[i] = stdin.ReadInt()
	}
	s := stdin.Read()

	q := NewDeque()
	for _, v := range a {
		q.AppendLast(v)
	}
	for i := 0; i < m; i++ {
		if s[i] == 'L' {
			x := q.PopFirst().(int)
			y := q.PopFirst().(int)
			q.AppendFirst(x + y)
			q.AppendLast(0)
		} else {
			x := q.PopLast().(int)
			y := q.PopLast().(int)
			q.AppendLast(x + y)
			q.AppendFirst(0)
		}
	}

	ans := []string{}
	for !q.IsEmpty() {
		ans = append(ans, fmt.Sprintf("%v", q.PopFirst()))
	}
	stdout.Println(strings.Join(ans, " "))

}

type Deque struct {
	head []interface{}
	tail []interface{}
}

func NewDeque() *Deque {
	return &Deque{
		head: []interface{}{},
		tail: []interface{}{},
	}
}

func (d *Deque) AppendLast(v interface{}) {
	d.tail = append(d.tail, v)
}

func (d *Deque) AppendFirst(v interface{}) {
	d.head = append(d.head, v)
}

func (d *Deque) PopLast() interface{} {
	if len(d.tail) == 0 {
		v := d.head[0]
		d.head = d.head[1:]
		return v
	} else {
		v := d.tail[len(d.tail)-1]
		d.tail = d.tail[:len(d.tail)-1]
		return v
	}
}

func (d *Deque) PopFirst() interface{} {
	if len(d.head) == 0 {
		v := d.tail[0]
		d.tail = d.tail[1:]
		return v
	} else {
		v := d.head[len(d.head)-1]
		d.head = d.head[:len(d.head)-1]
		return v
	}
}

func (d *Deque) IsEmpty() bool {
	return len(d.head) == 0 && len(d.tail) == 0
}

func (d *Deque) PeekFirst() interface{} {
	if len(d.head) == 0 {
		return d.tail[0]
	} else {
		return d.head[len(d.head)-1]
	}
}

func (d *Deque) PeekLast() interface{} {
	if len(d.tail) == 0 {
		return d.head[0]
	} else {
		return d.tail[len(d.tail)-1]
	}
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
	s.stdin.Buffer(make([]byte, bufio.MaxScanTokenSize), INFINITY)
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

func Min(a int, b ...int) int {
	for _, v := range b {
		if v < a {
			a = v
		}
	}
	return a
}

func Max(a int, b ...int) int {
	for _, v := range b {
		if a < v {
			a = v
		}
	}
	return a
}

func Abs(x int) int {
	if x > 0 {
		return x
	} else {
		return x * -1
	}
}

func Pow(x, y int) int {
	z := 1
	for y > 0 {
		if y%2 == 0 {
			x *= x
			y /= 2
		} else {
			z *= x
			y -= 1
		}
	}
	return z
}

func CreateMatrix(x, y int) [][]int {
	matrix := make([][]int, x)
	for i := 0; i < x; i++ {
		matrix[i] = make([]int, y)
	}
	return matrix
}
