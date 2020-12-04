package amazon

import (
	"fmt"
	"math"
)

func (x Box) Volume() float64 {
	return float64(x.L * x.H * x.D)
}

func (x Box) Length() int {
	return x.L
}

func (x Box) String() string {
	return fmt.Sprintf("Lunghezza: %d, Altezza: %d, Profondità: %d", x.L, x.H, x.D)
}

func (x Sphere) Volume() float64 {
	return 4 / 3 * math.Pi * math.Pow(float64(x.R), 3)
}
