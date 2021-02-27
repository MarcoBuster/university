# L3 - I circuiti combinatori

## Circuiti combinatori
I **circuiti combinatori** (o logici) sono circuiti in cui le operazioni logiche dipendono solo da una combinazione degli input. Come nelle funzioni algebriche, il risultato è aggiornato immediatamente (nei limiti del tempo di commutazione) dopo il cambiamento dell'input.

Essi sono senza memoria. Ogni volta che si inseriscono in ingresso gli stessi valori, si ottengono le stesse uscite. Il risultato non dipendende dallo stato del circuito.

I circuiti combinatori descrivono delle funzioni booleane. Queste funzioni si ottengono combinando tra loro (in parallelo o in cascata) gli operatori logici: NOT, AND, OR.

Il loro funzionamento può essere descritto come **tabella della verità**.

Dato un circuito è univoca l'espressione algebrica che ne rappresenta il funzionamento e viceversa.


### Definizioni
- __Espressione logica__: combinazione di operatori logici che implementa la funzione logica. Ad ogni espressione logica è associato un ben preciso circuito.
  Esempio: $AB + B \overline{C}$.
- __Funzione logica__: corrispondenza tra un insieme di ingresso (valori possibili di A, B, C) e un insieme di uscita (valori possibili di Y).
  Esempio: $Y = AB + B \overline{C}$

## Forme canoniche
### SOP (Sum Of Products)
La prima forma canica o SOP, si presta bene all'implementazione circuitale.

$$
Y = \overline A B \overline C + AB
$$

| A | B | C | Y |
|---|---|---|---|
| 0 | 0 | 0 | 0 |
| 0 | 0 | 1 | 0 |
| 0 | 1 | 0 | 1 |
| 0 | 1 | 1 | 0 | 
| 1 | 0 | 0 | 0 |
| 1 | 0 | 1 | 0 |
| 1 | 1 | 0 | 1 |
| 1 | 1 | 1 | 1 |

Quindi la funzione si può riscrivere come:
$$
Y = \overline A B \overline C + A B \overline C + A B C
$$

- Un **implicante** è un prodotto delle variabili (in forma asserita o negata) per le quali la funzione vale un certo valore (0 o 1)
- Un __mintermine__ è un implicante che contiene *tutte* le N variabili della funzione quando essa vale 1
- Un __maxtermine__ è un implicante che contiene *tutte* le N variabili della funzione quando essa vale 0

### Product of Sum (POS)
Sempre considerando la tabella sopra, la POS in questo caso è:
$$
Y = (A + B + C)(A + B + \overline C)(A + \overline B + \overline C)(\overline A + B + C)(\overline A + B + \overline C)
$$
Notare come prendo gli implicanti al contrario rispetto alla SOP.

## Criteri di ottimalità

### Complessità

Il numero di porte di un circuito è detto **complessità**. Più porte abbiamo più il costo e l'area occupata dal circuito sarà alto.

### Cammino critico

Il cammino critico è il massimo numero di porte da attraversare tra l'ingresso e l'uscita. Avendo ogni porta un tempo di commutazione, il tempo di commutazione del circuito dipende dal numero delle porte da attraversare e quindi dal cammino critico.

Il cammino critico per ogni porta varia:
- AND/OR: ci si riconduce sempre a porte AND/OR in cascata a 2 ingressi, quindi il cammino critico per una porta a $N$ ingressi è $N-1$.
- NOT: cammino critico 0.

Possiamo riorganizzare le porte ad "albero" piuttosto che in cascata, ma facendo ciò si aumenta l'area del circuito (la complessità). Bisogna valutare.

## Circuiti combinatori notevoli

Abbiamo tre modi per implementare le SOP:
- Logica distribuita
- PLA (Programmable Logic Array): matrici reoglari AND e OR in successione, personalizzabili dall'utente
- ROM (Read Only Memory): circuiti ad-hoc che implementano una particolare funzione in modo irreversibile

### Logica distribuita
Si tratta semplicemente di collegare le AND dei mintermini insieme in una OR:

![](https://i.imgur.com/j2xr9KJ.png)


### PLA
- È un'architettura a due livelli: prima un livello di AND, poi un livello di OR
- La matrice degli AND ha $n$ linee di ingresso: ciascuna porta ha in ingresso le $n$ linee e il loro complemento.
- L'utente specifica per ogni porta AND a disposizione se la linea in ingresso entra direttamente o dopo una negazione. Bruciando in ingresso le porte AND che non servono crea la matrice dei mintermini.
- Le uscite della matrice AND entrano nella matrice OR programmata come la precedente per ottenere l'OR dei mintermini della funzione. Si utilizza una porta OR per ogni funzione calcolata ($m$ OR per $m$ linee di uscita).
- __La complessità dipende dalla funzione logica implementata__

![](https://i.imgur.com/AH9egaM.png)


### ROM

Ora che conosciamo il decoder possiamo studiare la ROM. La ROM può essere scritta solo una volta (a parte casi particolari, come le EEPROM).

È formata da un decoder che mostra tutti i possibili mintermini e maxtermini e delle OR che "selezionano" per ogni uscita i mintermini voluti.

![](https://i.imgur.com/ALjsa5P.png)


### Confronto tra PLA e ROM

- La ROM fornisce un'uscita per ognuna delle combinazioni degli ingressi. Decoder con $2^n$ uscite, dove $n$ è il numero di variabili in ingresso alla ROM. Crescita esponenziale delle uscite. Approccio più generale. Può implementare una qualsiasi funzione, dato un certo numero di input e output

- La PLA contiene solamente i mintermini in uscita al primo stadio. Il loro numero cresce meno che esponenzialmente

### FPGA
Maggiore libertà, è costituta da celle: moduli di PLA e un rete di strutture a 2 livelli.


## Circuiti utili

### Porta XOR $\oplus$

$$
Y = A \oplus B
$$
| A | B | Y |
|---|---|---|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

- **SOP**: $Y = \overline A B + A \overline B$
- __Complessità__: 1
- __Cammino critico__: 1

Sono entrambe 1 perché con i transistor e i CMOS vengono fatte robe che sono efficienti.

### Decoder
Un decoder è caratterizzato da $n$ linee di input e da $2^n$ linee di output.
Esso attiva l'output corrispondente al numero binario dell'input.
Per esempio, se ci sono 4 linee di input e 16 di output (da 0 a 15), se in ingresso arriva il valore 0110 (6 in decimale) in uscita si accende la linea di indice 5 (ovvero la sesta); tutte le altre rimangono spente

__Complessità__: $2^n \cdot (n-1)$
__Cammino critico__: $2$

### Encoder

Come il decoder ma al contrario. Ha $2^n$ linee di ingresso (una sola può essere attiva) e $n$ linee di uscita; il numero binario espresso dalla configurazione delle linee di input rappresenta la linea di ingresso attiva.

### Multiplexer
![](https://i.imgur.com/MMsG0sJ.png)

- Ha la funzione di un sistema di semafori.
- È caratterizzato da:
    - $n$ linee di input (data) - $\{x_i\}$
    - $k$ linee di controllo (selezione) $\{S\}$
    - $1$ linea di output
- In base alla linea di controllo viene connessa all'uscita la linea di ingresso selezionata.

Quante linee di controllo (k) servono?
$$
k = \log_2 n
$$

### Comparatore
- È caratterizzato da:
    - $1$ numero su $n$ bit di ingresso, $A$
    - $1$ numero su $n$ bit di ingresso, $B$
    - $1$ uscita

|$A_0$ | $B_0$ | $C_0$ |
|------|-------|-------|
| $0$ | $0$ | $1$ |
| $0$ | $1$ | $0$ |
| $1$ | $0$ | $0$ |
| $1$ | $1$ | $1$ |

La sua espressione logica è:
$$
C_k = \overline{A_k \oplus B_k}
$$
