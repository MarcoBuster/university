# L4 - ALU

## Somma

### Half-Adder (HA)

![](https://i.imgur.com/G5ywZdo.png)

| A | B | somma | riporto |
|---|---|-------|---------|
| 0 | 0 | 0 | 0 | 
| 0 | 1 | 1 | 0 | 
| 1 | 0 | 1 | 0 |
| 1 | 1 | 0 | 1 |

In algebra booleana:
$$
S = A \oplus B \\
R = AB
$$

| funzione | cammino | complessità |
|----------|---------|-------------|
| somma | 1 | 1 |
| riporto | 1 | 1 |

### Full Adder

![](https://i.imgur.com/HWOfIpL.png)

| A | B | $r_{in}$ | somma | riporto |
|---|---|----------|-------|---------|
| 0 | 0 | 0 | 0 | 0 | 
| 0 | 1 | 0 | 1 | 0 | 
| 1 | 0 | 0 | 1 | 0 |
| 1 | 1 | 0 | 0 | 1 |
| 0 | 0 | 1 | 1 | 0 | 
| 0 | 1 | 1 | 0 | 1 | 
| 1 | 0 | 1 | 0 | 1 |
| 1 | 1 | 1 | 1 | 1 |

In algebra booleana (semplificato):

$$
S = A \oplus B \oplus r_{in} \\
r_{out} = AB + (A \oplus B) r_{in}
$$

| funzione | cammino | complessità |
|----------|---------|-------------|
| somma | 2 | 2 |
| riporto | 3 | 4 |
| totale | - | 5 |

### Somme a più bit
Per fare operazioni a più bit basta mettere in cascata più full-adder collegando l'$r_{out}$ di ogni full adder all'$r_{in}$ succcessivo.

![](https://i.imgur.com/BR4a8va.png)

### Somma con anticipazione di riporto
Il tempo di propagazione del riporto, man mano che il numero di bit da sommare aumenta aumenta troppo. Possiamo semplificare il circuito? Sì, con carry look-ahead (anticipazione di riporto).

Ci sono due tipi di riporto:
- per __generazione__: quando entrambi i fattori da sommare sono 1, avrò sicuramente il riporto e per controllarlo uso una AND: $g_i = a_ib_i$
- per __propagazione__: quando anche solo uno dei due fattori è 1 e il riporto in ingresso è 1, allora avrò il riporto. Lo controllo con una XOR e una AND: $p_i = (a_i \oplus b_i)r_{i}^{\: in}$

$$
r_i^{\: out} = g_i + p_i r_i^{\: in}
$$
- $g_i = a_i b_i$
- $p_i = a_i + b_i$

![](https://i.imgur.com/LrvTBru.png)

Esempio su 4 bit:
$r_0 = g_0 + p_0r^{in}$
$r_1 = g_1 + p_1r_0 = g_1 + p_1g_0 + p_1p_0r^{in}$
$r_2 = g_2 + p_2r_1 = g_2 + p_2(g_1 + p_1g_0 + p_1p_0r_0) = g_2 + p_2g_1 + p_2p_1g_0 + p_2p_1p_0r^{in}$
$r_3 = g_3 + p_3r_2 = g_3 + p_3(g_2 + p_2g_1 + p_2p_1g_0 + p_2p_1p_0r_0) = g_3 + p_3g_2 + p_3p_2g_1 + p_3p_2p_1g_0 + p_3p_2p_1p_0r^{in}$


## Sottrazione
Per fare la sottrazione basta fare la somma con il termine negativo in complemento a 2 e sommare 1. Come sommiamo 1? È sufficiente accendere il riporto d'ingresso.

![](https://i.imgur.com/GI0LdC0.png)


## Moltiplicazione

### Moltiplicazione mediante shift
Lo shift di un numero a sinistra, di k cifre, corrisponde ad una moltiplicazione per la base elevata alla k-esima potenza.

![](https://i.imgur.com/YcJIjKG.png)


### Moltiplicazione decimale
Possiamo utilizzare il classico processo della moltiplicazione (dalle elementari) anche in architetture. La moltiplicazione di due fattori non è nient'altro che la somma dei prodotti parziali.
In base 2 questa operazione è semplificata dal fatto che per calcolare i prodotti parziali è sufficiente shiftare e mettere 1 se sia moltiplicando che moltiplicatore sono 1 oppure 0, quindi sommarli tutti.

![](https://i.imgur.com/BvkxzBk.png)

Il circuito si può tradurre con i componenti che abbiamo studiato in questo modo:
![](https://i.imgur.com/cxMtU6Z.png)


## ALU
La ALU (Arithmetic logic unit) esegue operazioni aritmetico-logiche ed è costituita da circuiti combinatori. Utilizza i blocchi di base già visti in precedenza. Opera a parole di 32 bit.
L'ALU è composta da:
- una __parte di calcolo__ che fa effettivamente i calcoli
- una __parte di selezione__ che, con multiplexer, seleziona che calcolo deve essere eseguito

Esempio di ALU:
![](https://i.imgur.com/UFPMZqX.png)

## Comparazione
```c
if (a < b)
    s = true
else
    s = false
```
si può anche scirvere in questo modo:
```c 
if ((a-b) < 0)
    s = true
else
    s = false
```
ovvero fare la sottrazione tra `a` e `b` quindi controllare il bit di segno.

## Equivalenza
Attraverso la sottrazione si può capire se `a` e `b` sono uguali.
Basta collegare un OR che ha in ingresso tutte le $n$ uscite dell'ALU e qualora la sua uscita sia 1 vuol dire che i numeri NON sono uguali.

## Overflow detector
![](https://i.imgur.com/dK0jkHk.png)
