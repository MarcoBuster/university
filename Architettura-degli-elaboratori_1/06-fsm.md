# L6 - Macchine a stati finiti
La macchina a stati finiti (o di Moore) è definita, in teoria degli automi, dalla seguente sestupla:
$$
\{ X, I, Y, f, g, X_\text{ini} \}
$$

- $X$, __insieme degli stati__ (è un numero finito, da qui il nome _macchina a stati finiti_)
- $I$, __insieme di ingresso__: tutti i simboli che si possono presentare in ingresso
- $Y$, __insieme di uscita__: tutti i simboli che si possono generare in uscita
- $f$, __funzione di stato prossimo__: $X^* = f(X, \, I)$. Definisce l'evoluzione della macchina nel tempo. L'evoluzione è deterministica.
- $g$, __funzione di uscita__: $Y = g(X)$ nelle macchine di Moore.
- $X_\text{ini}$, __stato iniziale__: per il buon funzionamento della macchina è previsto uno stato iniziale, al quale la macchina può essere portata mediante un reset.

La parte __combinatoria__ della macchina a stati finiti è la funzione di stato prossimo e la funzione di uscita.

## Descrizione
### STG: State Transition Graph
Ad ogni nodo è associato uno stato. Un arco orientato da uno stato $x_i$ ad uno stato $x_j$, contrassegnato da un simbolo (di ingresso) $\alpha$, rappresentante una transizione (passaggio di stato) che si verifica quando la macchina, essendo nello stato $x_i$, riceve come ingresso il simbolo $\alpha$.
![](https://i.imgur.com/sYloMLE.png)

### STT: State Transition Table
Per ogni coppia stato presente/ingresso, si definisce l'uscita e lo stato prossimo. La forma è tabella e ricorda le tabelle della verità da cui è derivata.
![](https://i.imgur.com/U2emw30.png)

La STT è da codificare quindi in binario (_"10c"_ non ha senso per un computer) e da sintetizzare tramite tabella della verità.

## Macchina di Huffman
Una FSM implementata in binario prende il nome di macchina di Huffman (uffman)
![](https://i.imgur.com/BoGkdtv.png)
