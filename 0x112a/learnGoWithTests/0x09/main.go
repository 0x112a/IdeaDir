package main

import (
	"fmt"
	"io"
	"os"
	"time"
)

const finalworld = "Go!"
const countdownStart = 3

type Sleeper interface {
	Sleep()
}

type SpySleeper struct {
	Calls int
}

type ConfigurableSleeper struct {
	duration time.Duration
}

type CountdownOperationsSpy struct {
	Calls []string
}

func (c *CountdownOperationsSpy) Sleep() {
	c.Calls = append(c.Calls, sleep)
}

func (c *CountdownOperationsSpy) Write(p []byte) (n int, err error) {
	c.Calls = append(c.Calls, write)
	return
}

const write = "write"
const sleep = "sleep"

func (c *ConfigurableSleeper) Sleep() {
	time.Sleep(c.duration)
}

func (s *SpySleeper) Sleep() {
	s.Calls++
}

func Countdown(out io.Writer, s Sleeper) {
	for i := countdownStart; i > 0; i-- {
		//time.Sleep(1 * time.Second)
	}

	for i := countdownStart; i > 0; i-- {
		s.Sleep()
		fmt.Fprintf(out, "%d\n", i)
	}
	s.Sleep()
	fmt.Fprintf(out, finalworld)
}

func main() {
	Sleeper := &ConfigurableSleeper{1 * time.Second}
	Countdown(os.Stdout, Sleeper)
}
