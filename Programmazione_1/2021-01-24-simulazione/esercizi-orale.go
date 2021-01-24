package main

import (
	"fmt"
	"math"
	"strconv"
	"unicode"
)

// funzione che data una slice di Studenti(creare un tipo Studente con nome,cognome e voto),
// restituisce una slice con gli studenti promossimi (voto >=18)
type Studente struct {
	nome, cognome string
	voto          int
}

func studentiPromossi(slice []Studente) []Studente {
	var res []Studente
	for _, s := range slice {
		if s.voto >= 18 {
			res = append(res, s)
		}
	}
	return res
}

// funzione che data una slice di parole, verifica che per ogni parola ci sia almeno
// una delle possibili rotazioni (vedi sotto)
// esempio: "strada" -> tradas -> radast -> ...
func contaRotazioni(slice []string) int {
	rotazioni := make(map[string]bool)
	for _, s := range slice {
		for i := 0; i < len(s); i++ {
			s = s[1:] + string(s[0])
			rotazioni[s] = true
		}
	}
	count := 0
	for k := range rotazioni {
		for _, s := range slice {
			if k == s {
				count++
			}
		}
	}
	return count
}

// funzione che data slice di bool e un numero k calcola e restituisce l'and dei primi
// k booleani della slice
func primiKBooleani(slice []bool, k int) bool {
	for _, e := range slice[:k] {
		if e == false {
			return e
		}
	}
	return true
}

// funzione che data una slice di stringhe, restituisce la stringa + frequente
// (a parità di frequenza restituirne una qualsiasi)
func stringaPiuFrequente(slice []string) string {
	freq := make(map[string]int)
	for _, s := range slice {
		freq[s]++
	}
	var maxFreq int
	var candidate string
	for s, f := range freq {
		if f > maxFreq {
			maxFreq = f
			candidate = s
		}
	}
	return candidate
}

// funzione che dato un intero b (base) e una slice di interi (slice che rappresenta un numero in base b)
// restituisce il valore decimale del numero
// esempio: [1 0 0] -> 4 (con b = 2)
func daBaseNADecimale(b int, slice []int) int {
	res := 0
	for i := 0; i < len(slice); i++ {
		res += slice[i] * int(math.Pow(float64(b), float64(len(slice)-1-i)))
	}
	return res
}

// funzione che prende una map[string]int e una []stringhe
// restituisce la somma degli interi che corrispondono alle stringhe nella slice
// sommare -1 per le stringhe non presenti nella mappa
func sommaInteriSlice(m map[string]int, slice []string) int {
	sum := 0
	for _, s := range slice {
		val, ok := m[s]
		if !ok {
			val = -1
		}
		sum += val
	}
	return sum
}

// funzione che data una stringa ASCII che contiene cifre e cancelletti (es: #a#1#1)
// restituisce il quadrato del numero segreto (ottenuto cancellando i cancelletti) - il numero di #
func numeroSegreto(str string) int {
	numString := ""
	numHashtags := 0
	for _, c := range str {
		if c == '#' {
			numHashtags++
		}
		if !unicode.IsNumber(c) {
			continue
		}
		numString += string(c)
	}
	num, _ := strconv.Atoi(numString)
	return int(math.Pow(float64(num-numHashtags), 2))
}

// programma (main) che leggendo da riga di comando n (si assuma dispari) stampa una
// x di altezza n fatta di asterischi
func stampaX(n int) {
	for i := 0; i < n; i++ {
		for k := 0; k < n; k++ {
			if i == k {
				fmt.Print("*")
			} else if i == n-k-1 {
				fmt.Print("*")
			} else {
				fmt.Print(" ")
			}
		}
		fmt.Println()
	}
}

// funzione che data una slice di interi e due interi a e b, voglio sapere quanti interi
// dell'insieme (a+1, a+2, ... fino a+b) sono contenuti nella slice
func interiInInsieme(slice []int, a, b int) int {
	count := 0
	for _, el := range slice {
		if el > a && el < a+b {
			count++
		}
	}
	return count
}

// funzione che data una slice di interi restituisce un'altra slice di interi
// che contiene gli stessi interi senza ripetizioni
func senzaRipetizioni(slice []int) []int {
	m := make(map[int]bool)
	for _, el := range slice {
		m[el] = true
	}
	var res []int
	for el := range m {
		res = append(res, el)
	}
	return res
}

// funzione che dato un numero calcola quanti suoi divisori
// hanno divisori propri (diversi da 1 e da se stesso)
func contaDivisoriDeiDivisori(n int) int {
	var divisori []int
	for i := 2; i < n; i++ {
		if n%i == 0 {
			divisori = append(divisori, i)
		}
	}
	res := 0
	for _, divisore := range divisori {
		for i := 2; i < divisore; i++ {
			if divisore%i == 0 {
				res++
				break
			}
		}
	}
	return res
}

// funzione che date due slice di interi (non contengono ripetizioni) restituisce una slice
// che rappresenta l'intersezione fra la prima e la seconda
func intersezione(sl1, sl2 []int) []int {
	var res []int
	for _, e1 := range sl1 {
		for _, e2 := range sl2 {
			if e1 == e2 {
				res = append(res, e1)
			}
		}
	}
	return res
}

// funzione che data una stringa (anche con caratteri non ascii)
// restituisce quanti caratteri non sono lettere latine minuscole
func contaNonMinuscole(str string) int {
	count := 0
	for _, c := range str {
		if !unicode.IsLetter(c) || !unicode.IsLower(c) {
			count++
		}
	}
	return count
}

// funzione che data una slice di stringhe restituisce true se ci sono stringhe ripetute
func stringheRipetute(slice []string) bool {
	for i1, e1 := range slice {
		for i2, e2 := range slice {
			if i1 != i2 && e1 == e2 {
				return true
			}
		}
	}
	return false
}

// funzione che data una slice di stringhe restituisce una stringa
// calcolata legando le stringhe aggiungendo una virgola tra esse
func stringJoin(slice []string) string {
	// return strings.Join(slice, ",")
	var res string
	for i := 0; i < len(slice); i++ {
		res += slice[i]
		if i != len(slice)-1 {
			res += ", "
		}
	}
	return res
}

// funzione che data una stringa non ascii restituisce una mapp[rune]int, che ha come chiavi
// le rune che compaiono nella stringa e come valore le loro posizioni (assumere che non ci sono ripetizioni)
func contaRipetizioni(str string) map[rune]int {
	res := make(map[rune]int)
	for _, c := range str {
		res[c]++
	}
	return res
}

/*
funzione che data una stringa restituisce il numero di sotto-stringhe che si possono creare
da un indice non dato (a nostra scelta) fino ad un'altro indice (considerare TUTTE le sottostringhe)
le sottostringhe non devono essere ripetute (consiglio: usare una map[string]bool)
esempio: (indice scelto = 0)
cacao
caca
cac
acao
cao
ao
o
c
a
*/
func contaSottostringe(str string) int {
	found := make(map[string]bool)
	for i := 0; i < len(str); i++ {
		for k := i; k < len(str); k++ {
			found[str[i:k+1]] = true
		}
	}
	return len(found)
}

// funzione che data una slice di interi, sommi gli interi in posizioni pari, sommi gli interi in posizioni
// dispari e restituisca la loro differenza
func sommaPariDispari(sl []int) (int, int) {
	sommaPari, sommaDispari := 0, 0
	for i, v := range sl {
		if i%2 == 0 {
			sommaPari += v
		} else {
			sommaDispari += v
		}
	}
	return sommaPari, sommaDispari
}

// funzione che data una slice di rune (rune ammissibili per scrivere una password),
// (si deve produrre una password di 4 caratteri (anche ripetuti) )
// contare quante password si possono creare
func generaPassword(slr [4]rune) int {
	created := make(map[string]bool)
	for i := 0; i < len(slr); i++ {
		for k := 0; k < len(slr); k++ {
			for z := 0; z < len(slr); z++ {
				for h := 0; h < len(slr); h++ {
					password := string(slr[i]) + string(slr[k]) + string(slr[z]) + string(slr[h])
					created[password] = true
				}
			}
		}
	}
	return len(created)
}
