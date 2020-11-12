package main

import "fmt"

type dataStruct struct {
	g, m, a int
}

func annoBisestile(anno int) bool {
	return (anno%100 == 0 && anno%400 == 0) || (anno%100 != 0 && anno%4 == 0)
}

func ultimoGiornoDiFebbraioByValue(anno int) dataStruct {
	if annoBisestile(anno) {
		return dataStruct{29, 2, anno}
	}
	return dataStruct{28, 2, anno}
}

func ultimoGiornoDiFebbraioByReference(data *dataStruct) {
	if annoBisestile(data.a) {
		(*data).g = 29
	} else {
		(*data).g = 28
	}
}

func stampaDataStruct(data dataStruct) {
	fmt.Print(data.g, "/", data.m, "/", data.a, "\n")
}

func main() {
	var anno int
	fmt.Print("Inserisci anno: ")
	fmt.Scan(&anno)
	// by value
	stampaDataStruct(ultimoGiornoDiFebbraioByValue(anno))

	// by reference
	var data = dataStruct{1, 2, anno}
	ultimoGiornoDiFebbraioByReference(&data)
	stampaDataStruct(data)
}
