# L2 - Le porte logiche

## Le operazioni logiche fondamentali
**Qualunque** funzione booleana può essere rappresentata utilizzando combinazioni di questi tre operatori logichi fondamentali:

- AND
- OR
- NOT

### Rappresentazione delle funzioni logiche
$$
(A, \, B, \, C) \rightarrow Y
$$

- $A$, $B$, $C$ sono l'input o **dominio**
- $Y$ è l'output o **codominio**

La tabella della verità (thruth table, TT) descrive tutti gli input per ogni possibile combinazione di ingressi.

## Rappresentazione fisica dei componenti
### Transistor
Il transistor è praticamente un interruttore tra il collettore e l'emittore, comandato dalla tensione su base.

![transistor](https://i.imgur.com/8bXQrv3.png)

Due casi sono possibili:
- Tensione su **base bassa**:
    - collettore ed emittore isolati
    - la corrente non passa
    - il circuito è in stato di **interdizione**
- Tensione su **base alta**:
    - collettore ed emittore collegati
    - la corrente passa
    - il circuito è in stato di **saturazione**

### Tecnologia CMOS
Negli anni '80 si è scelto di passare alla tecnologia CMOS, migliore dei transistor.

Vantaggi:
- tensione di alimentazione "flessibile":
    - $V_\text{cc} = 1/15V$ (vicina a $1V$ quasi sempre)
    - $V_\text{LOW} = 0$ che è circa la *tensione di source*
    - $V_\text{HIGH} = 1$ che è circa la *tensione di drain*
- consumo bassisimo:
    - consuma solo nella transizione
    - in condizioni statiche, il consumo è praticamente nullo!
    
### Tempo di commutazione
**La commutazione NON è instantanea!**
Più porte in cascata generano un ritardo nella commutazione dell'uscita. Inoltre, c'è un numero limitato di porte logiche che si possono collegare in ingresso e in uscita (fan-in / fan-out)

## Algebra booleana
In assenza di parentesi, l'ordine di priorità è il seguente:

- NOT
- AND
- OR

### Manipolazione algebrica

| Proprietà | |
|-----------|---|
| Doppia inversione | $\overline{\overline{x}} = x$

| Proprietà | AND | OR |
| -------- | -------- | -------- |
| Identità | $1x = x$ | $0 + x = x$|
| Elemento nullo | $0x = 0$ | $1 + x = 1$
| Inverso | $\overline x x = 0$ | $\overline x + x = 1$ |
| Idempotenza | $x x = x$ | $x + x = x$ |


| Proprietà | AND rispetto ad OR | OR rispetto ad AND |
| -------- | -------- | -------- |
| Associativa | $(xy)z = x(yz)$ | $(x + y) + z = x + (y + z)$ |
| Commutativa | $xy = yx$ | $x + y = y + x$ |
| Distributiva | $x(y + z) = xy + xz$ | $x + yz = (x + y)(x + z)$ |
| Assorbimento | $x(x + y) = x$ | $x + xy = x$ |


### Teoremi di De Morgan
| Proprietà | |
|-----------|-|
|1° teorema di De Morgan|$\overline x \overline y = \overline x + \overline y$|
|2° teorema di De Morgan|$\overline{x + y} = \overline{x} \overline{y}$|


### Porta universale NOR
Con la porta NOR si possono ricavare tutti gli altri operatori fondamentali:
- NOT A = 0 NOR A
- A OR B = (A NOR B) NOR 0
- A AND B = (A NOR 0) NOR (B NOR 0)
