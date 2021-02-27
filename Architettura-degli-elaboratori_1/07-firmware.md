# L7 - Firmware
Il firmware non è né software né hardware, sta in mezzo.
Ha una capacità di elaborazione limitata e non viene programmata ad alto livello.
Tuttavia, permette di eseguire gli stessi programmi su processori diversi, programmi che vengono caricati nell'unità di controllo.

## Firmware vs hardware
- La soluzione hardware è più veloce ma più costosa per numero di porte e complessità dei circuiti.
- La soluzione firmware risolve l'oeprazione complessa emdiante una sequenza di operazioni semplice. È meno veloce, ma più flessibile e potenzialmente adatta ad inserire nuove procedure.
- La soluzione hardware è percorsa per le operazioni frequenti: la velocizzazione di operazioni complesse che vengono utilizzate raramente non aumenta significativamente le prestazioni.

## Moltiplicazione firmware

### Flow chart
![](https://i.imgur.com/tTOcmy0.png)

### Implementazione
![](https://i.imgur.com/aELWurW.png)

### Ottimizzazione
Al posto di shiftare il moltiplicando, posso shiftare una parte di prodotto:
![](https://i.imgur.com/3qbRQB1.png)

Possiamo ottimizzare ulteriormente se shifitiamo il moltiplicatore:
![](https://i.imgur.com/JrQSwnX.png)

### STT
![](https://i.imgur.com/9jaFq5J.png)
