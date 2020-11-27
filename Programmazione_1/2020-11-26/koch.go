package main

import (
	"fmt"
	"github.com/holizz/terrapin"
	"image"
	"image/png"
	"math"
	"net/http"
)

func pageA(w http.ResponseWriter, r *http.Request) {
	fmt.Fprint(w, `
	<!doctype html>
	<title>Koch</title>
	<h1>Koch</h1>
	<img src="/koch.png">`)
}

func KockCurve(t *terrapin.Terrapin, lung float64, liv int) {
	if liv == 0 {
		t.Forward(lung)
		return
	}
	KockCurve(t, lung, liv-1)
	t.Left(math.Pi / 3.0)
	KockCurve(t, lung, liv-1)
	t.Right(math.Pi - math.Pi/3.0)
	KockCurve(t, lung, liv-1)
	t.Left(math.Pi / 3.0)
	KockCurve(t, lung, liv-1)
}

func KockSnowflake(t *terrapin.Terrapin, lung float64, liv int) {
	KockCurve(t, lung, liv)
	t.Right(2.0 * math.Pi / 3.0)
	KockCurve(t, lung, liv)
	t.Right(2.0 * math.Pi / 3.0)
	KockCurve(t, lung, liv)
	t.Right(2.0 * math.Pi / 3.0)
}

func postImmagine(w http.ResponseWriter, r *http.Request) {
	i := image.NewRGBA(image.Rect(0, 0, 1000, 1000))
	t := terrapin.NewTerrapin(i, terrapin.Position{500.0, 500.0})
	KockSnowflake(t, 10.0, 3)
	_ = png.Encode(w, i)
}

func main() {
	http.HandleFunc("/kock.html", pageA)
	http.HandleFunc("/koch.png", postImmagine)
	fmt.Println("Listening on http://127.0.0.1:3000")
	http.ListenAndServe(":3000", nil)
}
