# L1 - codifica dell'informazione numerica

## Numeri negativi: complemento a 2
I numeri negativi sono complementari ai numeri positivi: $a + (-a) = 0$.
Per codificare un numero decimale *in complemento a 2* bisogna:
1. Negare gli 0 con 1 e viceversa
2. Sommare 1

Il primo bit è il **bit di segno**.

Esempio:


| Base 2 | Base 10 |
| ------ | ------- |
| $000$ | $\pm 0$ |
| $001$ | $+1$ | 
| $010$ | $+2$ |
| $011$ | $+3$ |
| $100$ | $-4$ |
| $101$ | $-3$ | 
| $110$ | $-2$ | 
| $111$ | $-1$ |

### Capacità di rappresentazione di numeri relativi
Con $N$ bit disponibili posso rappresentare numeri in questo range
$$
-2^{N-1} \leq n \leq 2^{N-1} -1
$$
per un totale di $2^N-1$ numeri.

### Codifica dei numeri relativi interi su $N$ bit
Occorre coprire tutti gli $N$ bit a disposizione. Codifica su 16 bit:

#### Numeri naturali $\in \mathbb{N}$
$$
11_{10} = 1011_2 = 0000 \: 0000 \: 0000 \: 1011_2
$$

Inserisco 0 fino a coprire tutti i bit; gli zeri sono parte integrante del numero

#### Numeri relativi $\in \mathbb{Z}$

$$
+5_{10} = 0101_2 = 0000 \: 0000 \: 0000 \: 0101 \\
-5_{10} = 1011_2 = 1111 \: 1111 \: 1111 \: 1011
$$

## Standard IEEE754
Lo standard IEEE754 si usa per rappresentare numeri reali con codifica floating point. In questo modo si riesce a rappresentare numeri molto grandi e molto piccoli

### Fixed point vs floating point
- In fixed point la risolzuione è fissa ed è pari al peso del bit meno significativo.
  Esempio: su 8 bit: $+1111,101$ la risoluzione per tutti i numeri sarà $1 \cdot 2^{-3} = 0,125$
- In floating point invece la risoluzione è relativa al numero rappresentato. Il bit meno significativo è in 23esima posizione in singola precisione, quindi ne consegue che la risoluzione sarà $2^{-23}$ volte il numero descritto.
  Esempi:
    - $100,....$ = $1,000... \cdot 2^2 \Rightarrow$ la risoluzione sarà $2^{-23} \cdot 2^2 = 2^{-21}$
    - $1,0 \cdot 2^{-126} \Rightarrow$ la risoluzione sarà $2^{-23} \cdot 2^{-126} = 2^{-149}$

### Notazione scientica in base 2
In notazione scientifica, il numero

$$
+6,2735 \cdot 10^2
$$

- $+$ è il segno
- $6,2735$ è la **mantissa**
- $2$ è l'esponente

Per codificare i numeri binari con questa standard li normalizziamo prima. Ovvero li mettiamo in questa forma:
$$
\pm 1, \text{xxxxx}
$$
In notazione a 32 bit:
- 1 bit è per il segno
- 8 bit per l'esponente
- 23 bit per la mantissa

### Distanza fra due numeri
La distanza tra un numero e l'altro è $2^{-23} \cdot 2^\text{exp}$ del numero preso in considerazione.

### Notazioni notevoli

| Mantissa | Esponente | Rappresentazione matematica |
| -------- | -------- | -------- |
| 0 | 00000000 | $0$ |
| 0 | 11111111 | $+\infty$ |
| $\neq$ 0 | 11111111 | NaN |
| $\neq$ 0 | 00000000 | Numero denormalizzato (min: $2^{-149}$) |
