package main

import (
	"./amazon"
	"fmt"
)

// HasLength is any type with an associated Length() method that returns an int
type hasLength interface {
	Length() int
}

func averageLength(x []hasLength) float64 {
	var sum int
	for _, b := range x {
		sum += b.Length()
	}
	return float64(sum) / float64(len(x))
}

type hasVolume interface {
	Volume() float64
}

func averageVolume(x []hasVolume) float64 {
	var sum float64
	for _, b := range x {
		sum += b.Volume()
	}
	return sum / float64(len(x))
}

func main() {
	var scatola amazon.Box
	scatola = amazon.Box{L: 30, H: 20, D: 15}

	fmt.Printf("Volume della scatola: %.f\n", scatola.Volume())
	fmt.Printf("Lunghezza della scatola: %d\n", scatola.Length())

	var y []hasLength
	y = append(y, amazon.Box{L: 30, H: 20, D: 10})
	y = append(y, amazon.Box{L: 50, H: 25, D: 15})
	y = append(y, amazon.Box{L: 32, H: 20, D: 15})
	fmt.Printf("Lunghezza media: %.2f\n", averageLength(y))

	var z []hasVolume
	z = append(z, amazon.Box{L: 30, H: 20, D: 10})
	z = append(z, amazon.Box{L: 50, H: 25, D: 15})
	z = append(z, amazon.Box{L: 32, H: 20, D: 15})
	z = append(z, amazon.Sphere{R: 12})
	z = append(z, amazon.Sphere{R: 16})
	z = append(z, amazon.Sphere{R: 23})
	fmt.Printf("Volume medio: %.2f\n", averageVolume(z))

	fmt.Println(scatola)
}
