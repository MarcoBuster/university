## Operazioni

Operazione
 ~ Sia $A$ un insieme. Chiamiamo _operazione_ $\star$ su $A$ una funzione:
 $$
 \star \!: A \times A \rightarrow A \\
 (a, \, b) \rightarrow a \star b
 $$
 
Struttura algebrica
 ~ Un insieme su cui siano definite una o più operazioni. Quindi, con le notazioni precedenti, $(A, \, \star)$ è un struttura algebrica.
 Per esempio, le seguenti sono strutture algebriche: $(\mathbb{N}, \, +)$, $(\mathbb{N}, \, \cdot)$, $(\mathbb{Z}, \, +)$, $(A, \, \cap)$, $(A, \, \cup)$, $(\mathbb{Q}-\{0\}, \, :)$, ...

Un'operazione $\star \! : A \times A \rightarrow A$ si dice:

Associativa
 ~ Se $\forall a, b, c \in A$ si ha $(a \star b) \star c = a \star (b \star c)$.
  
Commutativa 
 ~ Se $\forall a, b, \in A$ si ha $a \star b = b \star a$.

Elemento neutro a sinistra
 ~ Un elemento $e_s \in A$ è detto _elemento neutro a sinistra_ se $\forall a \in A , \, e_s \star a = a$.

Elemento neutro a destra
 ~ Un elemento $e_d \in A$ è detto _elemento neutro a destra_ se $\forall a \in A , \, a \star e_d = a$.

Elemento neutro
 ~ Un elemento $e \in A$ è detto _elemento neutro_ se è neutro sia a sinistra che a destra.
 
Esiste solo un elemento neutro
 ~ Se $(A, \, \star)$ è struttura algebrica che ammette un elemento neutro $\Rightarrow$ il neutro è unico.

    > 
    > __Dimostrazione__. Per assurdo, siano $e_1, \, e_2 \in A$ due elementi neutri. 
    >  - Poiché $e_1$ è neutro allora $\forall a \in A, \, e_1 \star a = a$. 
    >  In particolare se $a = e_2$ allora $e_1 \star e_2 = e_2$;
    >  - Poiché $e_2$ è neutro allora $\forall b \in A, \, b \star e_2 = b$.
    >  In particolare, se $b = e_1$ allora $e_1 \star e_2 = e_1$. 
    > 
    > Quindi, $e_1 = e_1 \star e_2 = e_2 \Rightarrow e_1 = e_2$. Assurdo.
    > 

Sia $(A, \, \star)$ una struttura algebrica tale che esiste un elemento neutro $e$. Allora diciamo che ammette:

Elemento inverso a sinistra
 ~ $a$ ammette un _elemento inverso sinistro_ se $\exists a_s \in A \text{ tale che } a_s \star a = e$.
 
Elemento inverso destro
 ~ $a$ ammette un _elemento inverso destro_ se $\exists a_d \in A \text{ tale che } a \star a_d = e$.
 
Elemento inverso
 ~ $a$ ammette un _elemento inverso_ se $\exists a' \in a \text{ tale che } a \star a' = a' \star a = e$.
 
Esiste un solo elemento inverso
 ~ Sia $(A, \, \star)$ una struttura algebrica tale che esiste l'elemento neutro e $\star$ è associativa $\Rightarrow$ se esiste l'elemento inverso di $a \in A$ è unico.
 
    > 
    > __Dimostrazione__. Considero $a \in A$ e $a_1, \, a_2 \in A$ inversi di $A$. Chiamo $e$ l'elemento neutro.
    > - Poiché $a_1$ è inverso di $a$ allora $a_1 \star a = e$;
    > - Poiché $a_2$ è inverso di $a$ allora $a \star a_2 = e$.
    > - Poiché $\star$ è associativa, allora:
    >   - $(a_1 \star a) \star a_2 = a_1 \star (a \star a_2)$
    >   - $(a_1 \star a) \star a_2 = e \star a_2 = a_2$ ($e$ è neutro)
    >   - $a_2 = (a_1 \star a) \star a_2 = a_1 \star (a \star a_2) = a_1 \Rightarrow$ **$a_2 = a_1$** (assurdo!)
    
Rappresentazione tabellare
 ~ Se $A$ è insieme finito posso rappresentare $\star$ in una tabella:
 
    | $\star$ | $a$ | $b$ | $e$ |
    |---------|-----|-----|-----|
    | $a$ | $a \star a$ | $a \star b$ | $a \star e = a$ |
    | $b$ | $b \star a$ | $b \star b$ | $b \star e = b$ |
    | $c$ | $e \star a = e$ | $e \star b = b$ | $e \star e = e$ |
    
    È possibile riconoscere un elemento neutro se si comporta come $e$ nella tabella sopra e stabilire se l'operazione è commutativa guardando se le celle in diagonale hanno lo stesso risultato.

Monoide
 ~ Una struttura algebrica $(M, \, \star)$ è detta monoide se è associativa ed esiste un elemento neutro di $\star$.

