## Gruppi

Gruppo
 ~ Un monoide si dice gruppo se ogni suo elemento ammette un inverso. Valgono le seguenti prioprietà:
   - il neutro è unico (già dimostrato)
   - l'inverso è unico (già dimostrato)
   - vale $a \star b = a \star c \Rightarrow b = c$
 
Gruppo commutativo o abeliano
 ~ Un gruppo $(G, \, \star)$ si dice commutativo o abeliano se $\star$ è commutativa.
 
Di seguito alcune proprietà dei gruppi.

$a \star b = a \star c \Rightarrow b = c$
 ~ > __Dimostrazione__. Sia $(G, \, \star)$ un gruppo e $a'$ inverso di $a$.
   > Moltiplico $a \star b = a \star c$ a sinistra per $a'$.
   > $a' \star (a \star b) = a' \star (a \star c) \Rightarrow (a' \star a) \star b = (a' \star a) \star c \Rightarrow$
   > essendo $(a' \star a) = e$, $\Rightarrow e \star b = e \star c \Rightarrow b = c$

Equazione a una soluzione
 ~ L'equazione di una incognita ($x$) del tipo $a \star x = b$ ha una e una sola soluzione, che è $x = a^{-1} \star b$.
 
Inverso dell'inverso
 ~ L'inverso dell'inverso di $a$ è $a$, cioè $(a^{-1})^{-1} = a$
 
$(a \star b)^{-1} = b^{-1} \star a^{-1}$

Potenze
 ~ Nei gruppi sono definite le potenze. Posto $a^0 = e$, abbiamo: $$
 a^n = a \star a \, \star \, ... \star \ a \\
 a^{-n} = \underbrace{a^{-1} \star a^{-1} \, \star \, ... \star \ a^{-1}}_{n \text{ volte}}
 $$ Inoltre, $\forall \alpha, \beta \in \mathbb{Z}, \, a^\alpha \star a^\beta = a^{\alpha + \beta}$.
 
Sottoinsieme di un gruppo
 ~ Sia $(G, \, \star)$ un gruppo. Un sottoinsieme $H \subseteq G$ si chiama sottogruppo di $G$ se:
 1. $\forall h_1, h_2 \in H, \, h_1 \star h_2 \in H$;
 2. $e \in H$;
 3. $\forall h \in H, \, h^{-1} \in H$.
 
Funzione di un gruppo
 ~ Sia $(G, \, \star)$ e $(M, \, \circ)$ due gruppi e $f \! : G \rightarrow \Gamma$ una funzione.
 
Omomorfismo
 ~ Diciamo che $f$ è un omomorfismo di gruppi se $\forall g, h \in G$: $$
 \underbrace{f(\overbrace{g \star h}^{\text{Operazione in G}})}_{\in \Gamma} = \overbrace{\underbrace{f(g)}_{\in \Gamma} \star \underbrace{f(h)}_{\in \Gamma}}^{\text{Operazione in } \Gamma}
 $$
 
Endomorfismo
 ~ $f$ omomoforismo si dice endomorfismo se $G = \Gamma$. 
 
Isomorfismo
 ~ Un omomorfismo biettivo (come funzione) si dice isomorfismo.

Anello
 ~ Sia $A$ un insieme, $\star$ e $\circ$ due operazioni su $A$, diciamo che $(A, \, star)$ è un _anello_ se:
    1. $(A, \, \star)$ è un gruppo;
    2. $(A, \circ)$ è un monoide;
    3. proprietà distributiva: $\forall a,b,c \in A, \, a \circ (b \star c) = (a \circ b) \star (a \circ c)$.
 
    Di solito in un anello l'operazione $\star$ si indica con $+$ e l'operazione $\circ$ si indica con $\cdot$. 
    Il neutro rispetto a $+$ si indica con $0_A$, il neutro rispetto a $\cdot$ si indica con $1_A$
    
Elemento unitario
 ~ Sia $(A, \, +, \, \cdot)$ un anello. Se $a \in A$ ammette inverso rispetto all'operazione $\cdot$, $a$ si chiama _elemento unitario_.

Divisore dello zero
 ~ Sia $(A, \, +, \, \cdot)$ un anello. Dico che un elemento $a \in A$ e $a \neq 0_A$ si chiama _divisore dello zero_ se: $$
 \exists b \neq 0_A, \, b \in A \text{ tale che } a \cdot b = 0_A
 $$

__Proposizione__. Sia $(A, \, +, \, \cdot)$ un anello, allora:
1. $\forall a \in A, \, a \cdot 0_A = 0_A \cdot a = 0_A$
    > __Dimostrazione__. 
    > - $a + 0_A = a$ (perché $0_A$ è neutro rispetto a $+$)
    > - $a \cdot (a + 0_A) = a \cdot a$ (moltiplico per $a$ a sinistra)
    > - $a \cdot a + a \cdot 0_A = a \cdot a$ (proprietà distributiva)
    > - $\underbrace{-a \cdot a + a \cdot a}_{0_A} + a \cdot 0_A = \underbrace{-a \cdot a + a \cdot a}_{0_A}$ (sommato $-a \cdot a$ a entrambi in quanto inverso di $a \cdot a$ rispetto a $+$)
    > - $0_A + a \cdot 0_A = 0_A \Rightarrow a \cdot 0_A = 0_A$ ($0_A$ è neutro rispetto a $+$)
    >
2. Se $a$ è unitario o ammette inverso rispetto ad $a$ allora non è divisore dello zero.
    > __Dimostrazione__.
    > - Se $a$ è unitario (cioè $\exists a^{-1} \text{ tale che } a \cdot a^{-1} = a^{-1} \cdot a = 1_A$) allora $a$ non è divisore dello zero.
    > - Sia $b \text{ tale che } a \cdot b = 0_A$ 
    > - $a \cdot b = 0_A$ (voglio mostrare che $b = 0_A$)
    > - $\underbrace{a^{-1} \cdot a}_{1_A} \cdot b = \underbrace{a^{-1} \cdot 0_A}_{0_A}$ (moltiplico a sinistra per $a^{-1}$)
    > - $\underbrace{1_A \cdot b}_b = 0_A$ (per la proposizione __1.__)
    > - $b = 0_A \Rightarrow a \text{ non è divisore dello zero.}$
 
Campo
 ~ Un _campo_ è un anello tale che $(A - 0_A, \, \cdot)$ un gruppo abeliano e $(A, \, +)$ è un gruppo abeliano. 
 Cioè, $(\mathbb{K}, \, +, \, \cdot)$ è campo se:
    1. $(\mathbb{K}, \, +)$ è un gruppo abeliano;
     2. $(\mathbb{K} - \{ 0\}, \, \cdot)$ è un gruppo abeliano (e $(\mathbb{K}, \, \cdot)$ è monoide);
    3. $\forall k_1, k_2, k_3 \in \mathbb{K} , \; k_1 \cdot (k_2 + k_3) = k_1 \cdot k_2 + k_1 + k_3$. 

    Quindi, se $\mathbb{K}$ è campo allora ogni $k \in \mathbb{K} - \{ 0_\mathbb{K} \}$ è invertibile, cioè ogni $k \in \mathbb{K} - \{ 0_\mathbb{K} \}$ è unitario. In particolare, non ci sono divisori dello zero.

