Lab10 - lettura da file e stringa - scrittura su file
=====================================================

I/O
package fmt
	famiglia Scan:
   		fmt.Scan, Scanf, Scanln leggono da os.Stdin
			fmt.Scan(&var1, &var2, ...)
		Fscan, Fscanf and Fscanln leggono da un io.Reader
		Sscan, Sscanf and Sscanln leggono da una stringa
		Scan, Fscan, Sscan treat newlines in the input as spaces.
		Scanln, Fscanln and Sscanln stop scanning at a newline and require that the items be followed by a newline or EOF.
		Scanf, Fscanf, and Sscanf parse the arguments according to a format string, analogous to that of Printf.

package bufio
	type Reader
		Read(p []byte) (n int, err error) //Read reads data into p
   		ReadByte() (byte, error)
		ReadRune() (r rune, size int, err error)
		ReadString(delim byte) (string, error)
	type Scanner
		Scan() bool
		Text() string
		Split(split SplitFunc)

package strings
   strings.Fields(s string) []string
   strings.Split(s, sep string) []string

package ioutil
   ReadFile(nomeFile string) ([]byte, error)

_____________________________________________

"Lettura" da stringa
====================

Scrivete un programma IOstring.go che 

- riceve da linea di comando 
una data nel formato gg-mm-aaaa
usa Sscanf per salvare giorno, mese, anno come int
e poi fa una stampa dei dati nel formato:
anno: aaaa, mese: mm, giorno: gg

Esempio
-------
go run IOstring.go 2/12/202
anno: 2020, mese: 12, giorno: 02
_____________________________________________

Lettura da file
===============

Gestione di magazzino
---------------------
 
Scrivere un programma magazzino.go per la gestione di un magazzino. 
Il programma legge da file, il cui nome è passato come parametro sulla linea di comando, una serie di righe nel seguenti formati:

codice,descrizione,prezzoUnitario
+ codice
- codice

Se la riga è del primo tipo, il programma aggiorna il listino dei prodotti, aggiungendo un nuovo prodotto, cioè associando al codice il prodotto corrispondente (descrizione e prezzo unitario) 

Se la riga è del secondo tipo (a magazzino è arrivato un prodotto con quel codice) o del terzo tipo (è uscito dal magazzino un prodotto con quel codice), il programma aggiorna la disponibilità del prodotto con quel codice a magazzino. 
Se il prodotto non è tra quelli presenti nel listino, stampa un messaggio opportuno (Ad es. "prodotto non in listino").

Prima di terminare, il programma stampa la situazione del magazzino (quali prodotti ci sono e in che disponibilità)

---

Che tipo di dato usare per rappresentare un prodotto?
Che tipo di dato usare per rappresentare e gestire il listino?
Che tipo di dato usare per rappresentare e gestire il magazzino?

File di input:

C020,12X020,2.31
C030,12X030,2.31
C040,12X040,2.41
C060,12X060,2.47
C070,12X070,2.52
C080,12X080,2.57
C105,12X105,2.94
C125,12X125,3.20
C150,12X150,3.47
C175,12X175,3.62
C200,12X200,3.83
+ C020
+ C060
+ C175
+ C060
+ C060
+ C175
+ C190
- C180
- C060

_____________________________________________

Convertitore text2Morse
-----------------------

Scrivere un programma morse.go per la traduzione in alfabeto Morse di testo. 
Il programma legge dal file morse.txt la codifica Morse dei caratteri
nel seguente formato:

A . - 
B - . . . 
C - . - . 

Dopodiché il programma legge da standard input del testo e ne stampa la sua codifica in Morse, stampando una parola per riga, e separando la codifica morse di un carattere dalla successiva con /. 
Il programma non fa distinzione tra maiuscole e minuscole.
Il programma termina con EOF (invio + ctrl D da tastiera)

Esempio
-------

$ go run morse.go
ciao
- . - .  / . .  / . -  / - - -  / 
ctrl D


_____________________________________________

Aula
----

Scrivere un programma aula.go per gestire un'aula.

Procedere seguendo le indicazioni qui di seguito.

Definire un tipo Aula per rappresentare e gestire 
un'aula di n file formate ciascuna da m banchi,
in cui l'unico aspetto che interessa è sapere 
quali banchi sono liberi e quali occupati.

Definire le seguenti funzioni:

//crea un'aula delle dimensione specificate
//ritorna l'aula e il valore true se le dimensioni sono corrette (entrambe >= 1)
//ritorna un'aula qualsiasi e false altrimenti
//in un'aula appena creata tutti i banchi sono liberi
func creaAula(nfile, ncol int) (Aula, bool)

//stampa la disposizione di un'aula come una griglia 
//mettendo delle 'x' per i posti occupati 
//e dei '_' per quelli liberi 
//(aggiungendo eventuali //spazi per migliorare l'effetto)
func stampaAula(a Aula)

//metodo che produce una stringa che descrive la disposizione di un'aula 
//come una griglia mettendo delle 'x' per i posti occupati 
//e dei '_' per quelli liberi (aggiungendo eventuali
//spazi per migliorare l'effetto)
func (aula Aula) String() string {

//occupa un "banco" di un'aula corrispondente a una certa posizione
//restituisce false se per qualsiasi motivo l'operazione NON ha esito, 
//cioè se lo stato complessivo dell'aula non cambia
func occupa(a Aula, fila, col int) bool

//libera (cioè rende nuovamente disponibile) un "banco" di un'aula che corrisponde a una certa posizione
//restituisce false se per qualsiasi motivo l'operazione NON ha esito, 
//cioè se lo stato complessivo dell'aula non cambia
func libera(a Aula, fila, col int) bool

//verifica il distanziamento tra banchi
//criterio di distanziamento: 
//nessun banco occupato nelle posizioni immeditamente adiacenti sulla stessa fila e colonna
//restituisce true se e solo se il banco specificato è in posizione "sicura"
func verificaDistanziamento(a Aula, fila, col int) bool



Dotare il programma di un main che crea un'aula 7 x 6; la stampa; poi
legge da un file, il cui nome è passato su linea di comando, righe nel formato

+ [r,c] (occupa il posto nella file r e colonna c)
- [r,c] (libera il posto nella file r e colonna c)
v [r,c] (verifica distanziamento per il posto nella file r e colonna c)
p (stampa l'aula)

e per ciascuna esegue l'operazione corrispondente e ne stampa l'esito.

Suggerimento: per creare una matrice nRighe x nColonne di elementi di tipo Type, potete impostare il codice come segue

matrice = make([][]Type, nRighe)
for i := range matrice {
	matrice[i] = make([]Type, nColonne)

_____________________________________________

Lettura da e scrittura su file
==============================

Copia
-----

Scrivere un programma copia.go che legge il contenuto di un file e lo salva in 
un altro file.
Il nome del file da cui leggere e quello su cui scrivere sono passati da linea di comando in quest'ordine.
_____________________________________________