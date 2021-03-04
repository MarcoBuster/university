## Funzioni
Funzione
 ~ $R \subseteq A \times B$ è una funzione se $\forall a \in A, \, \exists! \, b \in B \: \text{ tale che } (a, \, b) \in R$.
 $$
 \underbrace{R}_\text{Funzione}: \underbrace{A}_\text{Dominio} \rightarrow \underbrace{B}_\text{Codominio}
 $$
 
Immagine di una funzione
 ~ $R(A) = \{ b \in B \: | \: \exists \, a \in A \text{ con } b = R(a) \}$.
 
Retroimmagine di una funzione
 ~ Dato $b \in B$, la retroimmagine di $R$ è ogni elemento $a \in A$ tale che $b = R(a)$.

Funzioni uguali
 ~ Date due funzioni $F \! : A \rightarrow B$ e $G \! : A \rightarrow B$ esse si dicono uguali se $\forall a \in A \Rightarrow F(a) = G(a)$
 
Funzione inettiva
 ~ Sia $F \! : A \rightarrow B$ una funzione. Diciamo che $F$ è inettiva se $F(x) = F(y) \Rightarrow x = y$.
 Se due elementi hanno la stessa immagine allora coincidono.
 Ogni elemento di $B$ ha al massimo una retroimmagine.
 
Funzione suriettiva
 ~ Sia $F \! : A \rightarrow B$ una funzione. Diciamo che $F$ è suriettiva se $\forall b \in B, \, \exists \, a \in A \text{ tale che } F(a) = b$
 Ogni elemento di $B$ ha almeno una retroimmagine.
 
Funzione biettiva
 ~ Sia $F \! : A \rightarrow B$ una funzione. Diciamo che $F$ è biettiva se è sia inettiva che suiettiva, ovvero $F$ ha esattamente una retroimmagine.

Funzione composta
 ~ Siano $f \! : A \rightarrow B$ e $g \! : B \rightarrow C$ due funzioni. Allora esiste una funzione $g \circ f \! : A \rightarrow C$ così definita:
 $$
 (g \circ f) := \underbrace{g(\overbrace{f(a)}^{\in B})}_{\in C}
 $$

Funzione identica
 ~ $\text{id}_A \! : A \rightarrow A \text{ tale che } \forall a \in A, \, \text{id}_A(a) = a$

Funzione inversa
 ~ Siano $f \! : A \rightarrow B$ e $g \! : B \rightarrow A$ due funzioni. 
 Diciamo che $g$ è l'inversa di $f \Leftrightarrow f \circ g = \text{id}_B$ e $g \circ f = \text{id}_A$
 Se $f$ è biettiva $\Rightarrow$ $f$ ammette una funzione inversa.
 
