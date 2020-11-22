package main

import (
	"fmt"
	"math/rand"
	"time"
)

const (
	NumeroCartePerSeme = 13
	NumeroCarte        = NumeroCartePerSeme * 4
)

type set []int

func strCarta(carta int) string {
	seme := []string{"cuori", "quadri", "fiori", "picche"}
	valore := []string{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}
	return valore[carta%NumeroCartePerSeme] + " di " + seme[carta/NumeroCartePerSeme]
}

/* Restituisce un mazzo nuovo di zecca. Se mescolatro=true, lo mescola prima di restituirlo */
func mazzoNuovo(mescolato bool) (s set) {
	s = make(set, NumeroCarte)
	for i := 0; i < NumeroCarte; i++ {
		s[i] = i
	}
	if mescolato {
		for n := NumeroCarte; n > 0; n-- {
			pos := rand.Intn(n)
			s[pos], s[n-1] = s[n-1], s[pos]
		}
	} else {
		for i := 0; i < NumeroCarte; i++ {
			s[i] = i
		}
	}
	return
}

func main() {
	rand.Seed(time.Now().UTC().UnixNano())
	m := mazzoNuovo(true)
	mano := m[:5]
	for _, c := range mano {
		fmt.Printf("%s\n", strCarta(c))
	}
}
