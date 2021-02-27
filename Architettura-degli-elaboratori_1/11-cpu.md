# Fasi di esecuzione di un'istruzione

## 1. FETCH
- Istruzioni e dati risiedono nella memoria principale, dove sono stati caricati attraverso un'unità di ingresso
- L'esecuzione di un programma inizia quando il registro PC punta alla prima istruzione del programma in memoria
- Il segnale di controllo per la lettura (READ) viene inviato alla memoria
- Trascorso il tempo necessario all'accesso in memoria, la parola indirizzata (in questo caso la prima istruzione del programma) viene letta dalla memoria e trasferita nel registro IR
- Il contenuto del PC viene incrementato in modo da puntare all'istruzione successiva

## 2. DECODE
- L'istruzione contenuta nel registro IR viene decodificata per essere eseguita. ALla fase della decodifica corrisponde la predisposizione della CPU (aperta delle vie di comunicazione appropriate) all'esecuzione dell'istruzione
- In questa fase vengono anche recuperati gli operandi. Nelle architetture MIPS gli operandi possono essere solamente nel Register File oppure letti dalla memoria.

Architetture LOAD/STORE: le istruzioni di caricamento dalla memoria sono separate da quelle artimetico/logiche.

## 3. EXECUTE
- Viene selezionata all'interno della ALU l'operazione prevista dall'istruzione e determinata in fase di decodifica dell'istruzione
- Tra le operazioni previste, c'è anche la formazione dell'indirizzo di memoria da cui leggere o sui scrivere un dato.

## 3. LETTURA/SCRITTURA IN MEMORIA
- In questa fase il dato presente in un registro, viene scritto in memoria oppure viene letto dalla memoria un dato e trasferito ad un registro
- Questa fase non è richiesta da tutte le istruzioni
- Nel caso particolare di architetture LOAD/STORE, quali MIPS, le istruzioni di caricamento dalla memoria sono separate da quelle artimetico/logiche. Se effettuo una lettura/scrittura, non eseguo operazioni artimetico logiche sui dati

## 4. WRITE-BACK
- Scrivo il risultato sul registro

# Costruzione di una CPU per le istruzioni di tipo R

## Componenti
- Banco di registri (Register file)
- Program counter (PC)
- Instruction register (IR)
- ALU
- FPU (Floating Point Unit)
- Unità di controllo


## Fase di fetch
![](https://i.imgur.com/KIq9rx7.png)

## Fase di decode
1. Viene caricato OPCODE nella unità di controllo
2. Vengono caricati i registri


## Fase di execute
- L'unità di controllo fa eseguire all'ALU l'operazione

## Fase di write-back
![](https://i.imgur.com/hyduJa4.png)

# Costruzione di una CPU per le istruzioni di tipo I
L'esempio tratta un'istruzione `lw`:

![](https://i.imgur.com/UEDIf5R.png)

Schema CPU che fa `R`, `lw`, `sw`:
![](https://i.imgur.com/BsazwYK.png)

# CPU + CU
L'unità di controllo è un __circuito combinatorio__.
![](https://i.imgur.com/kT7hLU7.png)

![](https://i.imgur.com/ERPlRfL.png)
