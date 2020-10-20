package main

import (
	"fmt"
	"math"
)

func main() {
	var a, b, c float64
	fmt.Println("Calccolatore di equazioni di secondo grado. Formato: ax^2 + bx + c = 0")
	fmt.Print("Inserisci a: ")
	fmt.Scan(&a)
	fmt.Print("Inserisci b: ")
	fmt.Scan(&b)
	fmt.Print("Inserisci c: ")
	fmt.Scan(&c)
	if delta := b*b - 4*a*c; math.Abs(delta) < 1e-6 { // Floating point precision fix (delta ~= 0)
		x1 := (-b + math.Sqrt(delta)) / 2 * a
		fmt.Println("Due soluzioni coincidenti.")
		fmt.Println("x_1=", x1)
	} else if delta > 0 {
		x1 := (-b + math.Sqrt(delta)) / 2 * a
		x2 := (-b - math.Sqrt(delta)) / 2 * a
		fmt.Println("Due soluzioni distinte nei reali.")
		fmt.Println("x_1=", x1)
		fmt.Println("x_2=", x2)
	} else {
		fmt.Println("L'equazione non ha soluzioni nei reali. Delta=", delta)
	}
}
