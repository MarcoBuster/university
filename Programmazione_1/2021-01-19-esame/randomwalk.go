package main

import (
	"errors"
	"fmt"
	"math/rand"
	"os"
	"strconv"
	"time"
	"unicode"
)

type Location struct {
	x, y int
}

func Newloc(x, y int) Location {
	return Location{x, y}
}

func Move(loc Location, direction rune) (newloc Location, err error) {
	direction = unicode.ToUpper(direction)
	switch direction {
	case 'U':
		return Newloc(loc.x, loc.y+1), nil
	case 'D':
		return Newloc(loc.x, loc.y-1), nil
	case 'R':
		return Newloc(loc.x+1, loc.y), nil
	case 'L':
		return Newloc(loc.x-1, loc.y), nil
	}
	return Location{0, 0}, errors.New("unknown direction")
}

func (l Location) String() string {
	return fmt.Sprintf("(%d,%d)", l.x, l.y)
}

func RandomWalk(start Location, length uint) []Location {
	var i uint
	res := []Location{start}
	for i = 0; i < length; i++ {
		directions := []rune{'U', 'D', 'R', 'L'}
		direction := directions[rand.Intn(4)]
		newPos, _ := Move(res[len(res)-1], direction)
		res = append(res, newPos)
	}
	return res
}

func ContainsLoop(walk []Location) (found bool) {
	seen := make(map[Location]int)
	for _, loc := range walk {
		seen[loc]++
		if seen[loc] > 1 {
			return true
		}
	}
	return false
}

func main() {
	rand.Seed(time.Now().UnixNano())
	if len(os.Args) < 4 {
		_, _ = fmt.Fprintf(os.Stderr, "too few arguments")
		return
	}

	startX, _ := strconv.Atoi(os.Args[1])
	startY, _ := strconv.Atoi(os.Args[2])
	length, _ := strconv.Atoi(os.Args[3])

	verbose := false
	if len(os.Args) == 5 && os.Args[4] == "-v" {
		verbose = true
	}

	startLoc := Newloc(startX, startY)
	walk := RandomWalk(startLoc, uint(length))

	fmt.Println(length)
	if ContainsLoop(walk) {
		fmt.Println("loop")
	} else {
		fmt.Println("no loops")
	}

	if verbose {
		fmt.Println(walk)
	}
}
