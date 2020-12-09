package main

func main() {
	// Apertura di un file in lettura
	// os.Open("filepath") -> (*File, err)

	// Creazione di un file in scrittura
	// Attenzione! Elimina il file esistente!
	// os.Create("filepath") -> (*File, err)

	// Chiudi il file quando hai finito di usarlo!
	// f.Close()

	// [Lettura / scrittura]
	// Metodi di *File

	// Legge i primi b bytes e li scrive nella slice di input.
	// Ritorna il numero di bytes letti
	// Read(b []byte) (int, err)

	// Scrive i primi b bytes dalla slice di input
	// Ritorna il numero di bytes scritti
	// Write(b []byte) (int, err)
}
