# L5 - Circuiti sincroni

## Circuiti asincroni vs sincroni
I circuiti asincroni:
- Non devono mai aspettare il _tick_ del clock, quindi i segnali viaggiano sempre alla massima velocità però non arrivano tutti insieme
- È improbabile progettare il circuito in un'ottica di __retroazione__
- Quando progetto un circuito asincrono bisogna stare attenti che i cammini critici e tempi transitori non causino problemi

Nei circuiti sincroni, invece, le fasi di elaborazione sono scandite da un __clock__.
- Ad ogni ciclo di clock, la parte combinatoria del circuito ha tempo di elaborare (i segnali si propagano) e quindi il circuito ha tempo di stabilizzarsi. Questo deve avvenire entro il _tick_ successivo

## Clock
![](https://i.imgur.com/IWW23s7.png)

Ha le seguenti proprietà:
- __frequenza__: numero di cicli al secondo; misurato in Hertz (Hz)
- __periodo__: tempo necessario per completare 1 ciclo; misurato in secondi (s)

Il tempo di salita e di discesa è trascurabile, ma esiste.
Ci sono due tipi di dispositivi collegabili al clock:
- __Metodologia sensibile ai livelli:__ le variazioni di stato possono avvenire per tutto il periodo in cui il clock è al livello alto (o basso)
- __Metodologia sensibile ai fronti:__ le variazioni di stato avvengono solo in corrispondenza di un fronte di clock.

Il clock è una variabile che __dipende__ dal cammino critico.

Il clock mi serve perché occorre una sincronizzazione quando si eseguono più operazioni in sequenza.
Ci serve anche una memoria.
