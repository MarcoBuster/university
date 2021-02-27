# L8 - ISA
L'ISA (Instruction Set Architecture) definisce le istruzioni messe a disposizione dalla macchina.
- Definizione del __funzionamento__: insieme delle istruzioni (interfaccia verso i linguaggi ad alto livello)
- Definizione del __formato__: codifica delle istruzioni (interfaccia verso l'hardware)

## ARM
L'ARM (Advanced RISC Machine) è una famiglia di architetture di istruzioni.
Vengono vendute le licenze a utilizzare le ISA a società che poi realizzano i loro processori RISC (alcuni come SoC - Systems on Chip) che comprendono memorie, interfacce, radio, ecc...
Viene fornito royalty-free per studio personale.

---

Le istruzioni comprese nel linguaggio macchina di ogni calcolatore possono essere classificate nelle seguenti quattro categorie:
- istruzioni aritmetico-logiche
- istruzioni di trasferimenmto da/verso la memoria (load/store)
- istruzioni di salto condizionato e non condizionato per il controllo del flusso di programma
- istruzioni di trsferimento in ingresso/uscita (I/O)

Le istruzioni e la loro codifica costituiscono l'ISA di un calcolatore.

```c 
for (i=0; i<N; i++) {   // Istruzioni di controllo
    elem = i*N+j;       // Istruzioni aritmetico-logiche
    s = v[elem];        // Istruzioni di accesso a memoria
    z[elem] = s;        // Istruzioni di accesso a memoria
}
```

## Assembler
- Le istruzioni assembler sono una __rappresentazione simbolica__ del __linguaggio macchina__ comprensibile dall'hardware
- È più comprensibile del _vero_ linguaggio macchina in quanto si usano parole e non sequenze di bit
- Rispetto ai linguaggi ad alto livello, l'assembler è molto più limitato


## Registri
- Un registro è un insieme di celle di memoria che vengono lette / scritte in parallelo
- I registri sono associati alle variabili di un programma del compilatore. Contengono i dati
- Un processore possiede un numero limitato di registri: ad esempio il processore MIPS possiede 32 registri composti da 32 bit (word). Essi formano il __register file__
- I registri possono essere direttamente indirizzati mediante il loro numero progressivo (0-31) preceduto da un `$`, ad esempio:
  `$0, $1, ..., $31`
- Per convienzione di utilizzo, sono stati introdotti nomi simbolici significativi. Sono preceduti da `$`, ad esempio:
    - `$s0, $s1, ..., $s7 ($s8)` per indicare variabili C
    - `$t0, $t1, ..., $t9` per indicare variabili temporanee

### Registri per le operazioni floating point
- Esistono 32 registri utilizzati per l'esecuzione delle istruzioni
- Esistono 32 registri per le operazioni floating point (virgola mobile) indicati come
  `$f0, $f1, ..., $f31`
  Per le operazioni in doppia precisione si usano i registri contigui:
  `$f0, $f2, $f4, ...`

## Assembler come linguaggio di programmazione
Alcune applicazioni richiedono un approccio _ibrido_ nel quale le parti più critiche del programma sono scritte in assembly (per massimizzare le prestazioni) e le altre sono scritte in un linguaggio ad alto livello (le prestazioni dipendono dalla capacità di ottimizzazione del compilatore).

### Svantaggi
- Mancanza di portabilità dei programmi su macchine diverse
- Maggiore lunghezza, difficoltà di comprensione e facilità di errore rispetto ai programmi scritti in un linguaggio ad alto livello

### Vantaggi
- Ottimizzazione delle prestazioni
- Massimo sfruttamento delle potenzialità dell'hardware sottostante
- Le strutture di controlo hanno forme limitate
- Non esistono tipi di dati all'infouri di interi, virgola mobile e caratteri
- La gestione delle strutture dati e delle chiamate ap rocedura deve essere fatta in modo esmplicito dal programmatore

# Istruzioni MIPS

## Istruzioni aritmetico logiche
In MIPS, un'istruzione aritmetico logica possiede in generale tre operandi: i due registri contenenti i valori da elaborare (registri sorgente) e il registro contentente il risultato (registro destinazione)
L'ordine degli operandi è fisso, prima il registro contentente il risultato dell'operazione e poi i due operandi:

`OPCODE DEST, SRC1, SRC2`

Le operazioni vengono eseguite esclusivamente su dati presenti nella CPU, non su dati residenti nella memoria.

### `add` e `sub`
```mipsasm
add rd, rs, rt         ; rd <- rs + rt
add $s6, $s7, $s8      ; $s6 <- $s7 + $s8 
```
```mipsasm
sub rd, rs, rt         ; rd <- rs - rt
sub $s6, $s7, $s8      ; $s6 <- $s7 - $s8
```

#### varianti
```mipsasm
addi $s1, $s2, 100     ; add immediate: $s1 = $s2 + 100
addiu $s0, $s1, 100    ; add immediate unsigned: $s0 = $s1 + 100
addu $s0, $s1, $s2     ; add unsigned: $s0 = $s1 + $s2
; non esiste subi. perché?
addi $s1, $s2, -20     ; $s1 = $s2 - 20
```

### `mult`
```mipsasm
mult rs rt             ; signed
multu rs rt            ; unsigned
```

Attenzione: il registro di destinazione è __implicito__. Viene sempre posto in due registri dedicati di una parola denominati Hi (High order word) e Lo (Low order word)
Per spostare il risultato in un altro registro facciamo:

```mipsasm
mfhi rd1               ; move hi to rd1
mflo rd2               ; move lo to rd2
```

## Istruzioni di accesso alla memoria

### Memoria
- La memoria è vista come un unico grande array uni-dimensionale
- Un indirizzo di memoria costituisce un indice all'interno dell'array

![](https://i.imgur.com/cDuQzz1.png)

- La memoria è organizzata in parole composte da $n$-bit che possono essere indirizzate tutte insieme
- Ogni parola di memoria è associata ad un __indirizzo__ composto da $k$-bit
- I $2^k$ indirizzi costituiscono lo __spazio di indirizzamento__ del calcolatore. Ad esempio, un indirizzo di memoria composto da 32-bit genera uno spazio di indirizzamento di $2^{32}$ byte o 4GB


#### Registri e memoria
Una cella di memoria contiene solitamente 1 byte, mentre un registro contiene 1 word (4 byte). Essendo la memoria formata da registri, posso utilizzare un registro per avere 4 celle di memoria. Come li piazzo?
- __Big endian__: prima il bit più significativo
- __Little endian__: prima il bit meno significativo

### `load` e `store`
L'istruzione di `load` trasferisce una copia di un dato/istruzione, contenuto in una specifica locazione di memoria, a un registro della CPU, lasciando inalterata la parola di memoria:
```armasm
load LOC, reg          ; reg <- [LOC] 
```
L'istruzione di `store` funziona in modo analogo:
```armasm
store reg, LOC         ; [LOC] <- reg
```

### `lw` e `sw`
Nel MIPS, l'istruzione `lw` (load word) ha tre argomenti:
- il _registro destinazione_ in cui caricare la parola letta dalla memoria
- una costante o _spiazzamento_ (offset)
- un registro base che contiene il valore dell'indirizzo base da sommare all'offset

L'indirizzo della parola di memoria da caricare nel registro destinazione è ottenuto dalla somma dell'offset e del contenuto del registro base.

```mipsasm
lw $s1, 100($s2)       ; $s1 <- M[ [$s2] + 100 ] 
```

`sw` (store word) funziona in modo analogo:
```mipsasm 
sw $s1, 100($s2)       ; M[ [$S2] + 100 ] <- $s1
```

### Esempio: scrittura di un vettore
Codice in C:
```cpp
a[12] = h + a[8];
```

Codice MIPS:
```mipsasm 
lw $t0, 32($s3)        ; $t0 <- M[ [$s3] + 32 ] 
add $t0, $s2, $t0      ; $t0 <- $s2 + $t0
sw $t0, 48($s3)        ; M[ [$s3] + 48 ] <- $t0
```

## Istruzioni di salto
Le istruzioni di salto sono spesso utilizzate nei cicli:
```c 
for (i=0; i<N; i++) {
    elem = i*N + j;
    s = v[elem];
    z[elem] = s;
}
```

```mipsasm
inizia:
    beq $t0, $s0, esci ; $s0 conteggio fine ciclo 
    ...
    j inizia           ; torna in ciclo
esci:
    ...
```

### `j`
Salta ad etichetta

### `beq` e `bne`
Salta se...
- `beq r1, r2, etichetta` (branch on equal)
- `bne r1, r2, etichetta` (branch on not equal)
