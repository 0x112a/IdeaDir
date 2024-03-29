package main

import "testing"

func TestWalk(t *testing.T) {
	expect := "Chris"
	var got []string

	x := struct {
		Name string
	}{expect}

	walk(x, func(input string) {
		got = append(got, input)
	})

	if len(got) != 1 {
		t.Errorf("wrong number of function calls,got %d want %d", len(got), 1)
	}
	if got[0] != expect {
		t.Errorf("got '%s', want '%s'", got[0], expect)
	}
}
