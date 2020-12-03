package main

// V2: La funzione ricorsiva restituisce la sequenza di numeri generata,
// a partire da n, secondo la funzione f

import "fmt"

func recursiveCollatzV2(n int) []int {
	// Non sono riuscito a risolvere questo esercizio
	// senza modificare lo "scheletro" della funzione
	// ovvero senza aggiungere un parametro con la lista
	// da popolare (quindi più o meno come la V3)
	// Ne ho discusso anche con altri colleghi sul gruppo Telegram
	// ma non siamo riusciti a risolvere il problema.
	return []int{n}
}

func main() {
	var n int
	fmt.Print("n: ")
	fmt.Scan(&n)
	res := recursiveCollatzV2(n)
	fmt.Println(res)
}
