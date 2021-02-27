# L10 - Registri
La memoria è suddivisa in celle, ciascuna delle quali assume un valore binario stabile.
Si può scrivere il valore 0/1 in una cella. Si può leggere il valore di ciascuna cella.

## Registri
### Latch sincrono come elemento di meoria
L'ingresso del clock del bistabile viene utilizzato come segnale di write. È trasparente quando W=1.
![](https://i.imgur.com/k3xp3bs.png)

### Più latch insieme fanno un registro a $n$ bit
![](https://i.imgur.com/qLQOeqq.png)

### Lettura
Lo stato del registro (il contenuto) è sempre disponibile (trasparente) sulle uscite $Q_{0...n}$. La lettura è possibile per tutta la durata del ciclo di clock.

### Scrittura
Ad ogni colpo di clock lo stato del registro assume il valore dell'ingresso dati.

Cosa occore modificare perché il registro venga scritto quando serve? Introdurre una sorta di "apertura del cancello" (ovvero una porta AND). Può essere sincronizzata o meno con il clock.
Il clock apre il passaggio al contenuto di D attraverso il latch. Quando il segnale di write è zero, lo stato non varia.

## Banco di registri
C'è un segnale di write specifico per ogni registro e comunque funziona solo quando il clock è alto.
![](https://i.imgur.com/X4pGFS7.png)

__Problema__: voglio poter scegliere dove scrivere e dove leggere.

### Multiplexer per le uscite
Per selezionare cosa leggere basta che utilizzo un multiplexer. Actually, userò tanti multiplexer quanti sono i bit da leggere (ogni multiplexer ne seleziona 1).
![](https://i.imgur.com/jMQI109.png)

### Decoder per le entrate
Per selezionare quale registro vogliamo scrivere ci avvaliamo di un decoder, che messo in AND con il segnale di write seleziona quale registro vogliamo scrivere.
![](https://i.imgur.com/BzdCgf5.png)
