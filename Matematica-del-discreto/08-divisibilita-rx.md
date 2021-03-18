## Divisibilità in $\mathbb{R}[x]$
L'anello dei polinomi in una variabile a coefficiente $\in \mathbb{R}$ è $(\mathbb{R}[x], \, +, \, \cdot)$.
In questo anello valgono i risultati di divisibilità su $\mathbb{Z}$.

__Teorema__
Siano $a(x)$ e $b(x)$ polinomi in $\mathbb{R}[x]$ con $b(x) \neq 0$. 
Allora esistono unici $q(x), \, r(x) \in \mathbb{R}[x]$ tali che:
1. $a(x) = b(x) \cdot q(x) + r(x)$
2. $0 \leq \deg(r(x)) < \deg(b(x))$

Massimo Comun Divisore (M.C.D.) in $\mathbb{R}[x]$
 ~ Siano $a(x), \, b(x) \in \mathbb{R}[x] \setminus \{ 0 \}$. Si dice che $d(x) \in \mathbb{R}$ è un $\operatorname{MCD}$ di $a(x)$ e $b(x)$ se:
    1. $d(x) | a(x)$ e $d(x) | b(x)$
    2. $t(x) \in \mathbb{R}[x] \setminus \{ 0 \}$ tale che $t(x) | a(x)$ e $t(x) | b(x)$ allora $t(x) | d(x)$
 
   In questo caso denotiamo $d(x) = \operatorname{MCD}(a(x), \, b(x))$.
   
   __Osservazione__
   Se $d(x)$ è un $\operatorname{MCD}$ di $a(x)$ e $b(x)$ allora anche $\lambda \cdot d(x)$ con $\lambda \in \mathbb{R}$ è un $\operatorname{MCD}$ di $a(x)$ e $b(x)$.

__Teorema__. Algoritmo delle divisioni successive in $\mathbb{R}[x]$
Per ogni coppia di polinomi non nulli $a(x)$ e $b(x)$ in $\mathbb{R}[x] \setminus \{ 0 \}$ esiste un $\operatorname{MCD}$ $d(x)$. Inoltre esistono $h(x), \, k(x) \in \mathbb{R}[x]$ tali che (identità di bezout): $$
d(x) = a(x) \cdot h(x) + b(x) \cdot k(x)
$$

__Teorema__. Teorema di Ruffini
Sia $a(x) \in \mathbb{R}$ e $b(x) = x - \xi$ con $\xi \in \mathbb{R}$. Il resto della divisione di $a(x)$ per $b(x)$ è $a(\xi)$. 
Quindi, $a(x)$ è divisibile per $x - \xi$ se e solo se $a(\xi) = 0$.

Radice
 ~ Sia $a(x) \in \mathbb{R}[x]$. 
 $\xi \in \mathbb{R}$ è una radice di $a(x)$ se: $a(\xi) = 0$

     __Corollario__
     Sia $a(x) \in \mathbb{R}[x]$. Allora: $$
     (x - \xi) | a(x) \Longleftrightarrow a(\xi) = 0 \Longleftrightarrow \xi \text{ è una radice di } a(x)
     $$

