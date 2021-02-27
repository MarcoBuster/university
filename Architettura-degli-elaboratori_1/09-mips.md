# L9 - Codifica delle istruzioni MIPS

- Tutte le istruzioni MIPS hanno la __stessa__ dimensione (32 bit) - Architettura RISC.
- I 32 bit hanno un significato diverso a seconda del formato (o tipo) di istruzione. Il tipo di istruzione è riconosciuto in base al valore dei 6 bit più significativi (__OPCODE__).

Le istruzioni MIPS sono di 3 formati:
- __Tipo R (register)__: lavorano prevalentemente su 3 registri
    - Istruzioni aritmetico-logiche
- __Tipo I (immediate)__: lavorano su 2 registri. L'istruzione è suddisvisa in un gruppo di 16 bit contenenti informazioni + 16 bit riservati ad una costante
    - Istruzioni di accesso alla memoria o operazioni con una costante
- __Tipo J (jump)__: lavora senza registri: codice operativo + indirizzo di salto
    - Istruzioni di salto incodizionato

![](https://i.imgur.com/0uJyV73.png)

## Tipo R
Composte da:
- Un codice operativo su 6 bit
- Un registro source (rs) su 5 bit
- Un registro target (rt) su 5 bit
- Un registro destinazione (rd) su 5 bit
- Un numero di posizioni di shift (shift aumount, shamnt) su 5 bit
- Un codice di funzione (selettore ALU) su 6 bit

![](https://i.imgur.com/XvsItIY.png  )

Esempio con l'`add`.
![](https://i.imgur.com/S12eLWo.png)


## Tipo I
- __op__: (6 bit) indica il tipo di operazione
- __rs__: (5 bit) indica il registro sorgente
- __rt__: (5 bit) indica il registro target
- __costante__: (16 bit) nel caso di una lw riporta lo spiazzamento

### Accesso a memoria
![](https://i.imgur.com/tPvG1xg.png)

### Istruzioni aritmetico-logiche
![](https://i.imgur.com/F3i6qih.png)

### Branch
Essendo sempre gli indirizzi delle istruzioni a 4 byte ed essendo quindi gli ultimi 2 bit sempre 00, possiamo "spostare" due bit più a destra il tutto in modo da avere altri due bit (più significativi) aggiuntivi per codificare l'indirizzo (da 16 a 18).

![](https://i.imgur.com/bt0NA7k.png)

## Tipo J
Come nelle istruzioni di tipo I/branch, anche qui codificare gli ultimi 2 bit meno significativi non ha senso perché sono sempre 00, quindi aggiungiamo due bit a sinistra per avere più "spazio di manovra".

Composte da:
- __op__: indica il tipo di operazione
- __indirizzo__ (composto da 26 bit) riporta una parte (26 bit su 32) dell'indirizzo __assoluto__ di destinazione del salto
