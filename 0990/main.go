package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

func exec(stdin *Stdin, stdout *Stdout) {
	n := stdin.ReadInt()
	m := stdin.ReadInt()
	k := stdin.ReadInt()
	op := stdin.Read()
	a := []int{}
	b := []int{}
	for i := 0; i < m; i++ {
		b = append(b, stdin.ReadInt())
	}
	for i := 0; i < n; i++ {
		a = append(a, stdin.ReadInt())
	}

	ans := 0
	if op == "+" {
		c := NewCounter()
		for i := 0; i < n; i++ {
			c.Increment(a[i] % k)
		}

		for i := 0; i < m; i++ {
			mod := b[i] % k
			if mod == 0 {
				ans += c.Get(0)
			} else {
				ans += c.Get(k - mod)
			}
		}
	} else {
		c := NewCounter()
		d := NewCounter()
		for i := 0; i < n; i++ {
			c.Increment(Gcd(k, a[i]))
		}
		for i := 0; i < m; i++ {
			d.Increment(Gcd(k, b[i]))
		}

		for _, key1 := range c.Keys() {
			for _, key2 := range d.Keys() {
				gcd1, _ := key1.(int)
				gcd2, _ := key2.(int)
				if (gcd1*gcd2)%k == 0 {
					ans += c.Get(key1) * d.Get(key2)
				}
			}
		}
	}

	stdout.Println(ans)
}

func Gcd(x, y int) int {
	if x < y {
		x, y = y, x
	}

	for y > 0 {
		x, y = y, x%y
	}

	return x
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

type Counter map[interface{}]int

func NewCounter() *Counter {
	return &Counter{}
}

func (c *Counter) Increment(key interface{}) {
	d := map[interface{}]int(*c)
	d[key] = c.Get(key) + 1
}

func (c *Counter) Get(key interface{}) int {
	d := map[interface{}]int(*c)
	if v, ok := d[key]; ok {
		return v
	} else {
		return 0
	}
}

func (c *Counter) Keys() []interface{} {
	d := map[interface{}]int(*c)
	keys := []interface{}{}
	for key := range d {
		keys = append(keys, key)
	}
	return keys
}
