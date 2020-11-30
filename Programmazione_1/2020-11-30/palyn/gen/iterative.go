package gen

import (
	"math/rand"
)

/* Generates a random lowercase latin letter. */
func genCharacter() string {
	return string('a' + rune(rand.Intn('z'-'a'+1)))
}

/* Generates a random palyndrome word iteratively */
func IterativeGenPalyn(n int) string {
	t := ""
	if n%2 != 0 {
		t = string(genCharacter())
	}
	for i := 0; i < n/2; i++ {
		c := genCharacter()
		t = string(c) + t + string(c)
	}
	return t
}
