## Divisibilità in $\mathbb{Z}$
$b$ divide $a$
 ~ Siano $a, \, b \in \mathbb{Z}$ con $b \neq 0$. 
 Se $\exists q \in \mathbb{Z}$ tale che $a = b \cdot q$ si dice che _$b$ divide $a$_ e si scrive $b|a$, altrimenti si dice che _$b$ non divide $a$_ e si scrive $b \nmid a$. Le seguenti notazioni sono equivalenti:
 - _$b$ divide a_
 - _$a$ è divisibile per $b$_
 - _$a$ è multiplo di $b$_
 - _$b$ è un fattore di $a$_
 - _$b$ è un divisore di $a$_

__Teorema__
Siano $a, \, b \in \mathbb{Z}$ con $b \neq 0$. Allora esistono unici $q, r \in \mathbb{Z}$ tali che:
1. $a = b \cdot q + r$
2. $0 \leq r < |b|$

Gli interi $q$ e $r$ vengono detti rispettivamente _quoziente_ e _resto_ della divisione di $a$ per $b$.

> __Dimostrazione__ dell'unicità.
> __Per assurdo__, supponiamo che esistono due quozienti e due resti: $$
> \begin{cases}a = b \cdot q + r & (\Gamma) \\ a = b \cdot q' + r' & (\Delta) \end{cases}$$ con $q, \, q', \, r, \, r' \in \mathbb{Z}$ e $0 \leq r < |b|$ e $0 \leq r' < |b|$.
> Vogliamo dimostrare che $q = q'$ e $r = r'$. Sottraggo $(\Delta)$ da $(\Gamma)$:
> - $0 = b \cdot (q - q') + (r \cdot r')$
> - $\Rightarrow r' - r = b \cdot (q - q')$
> - $\Rightarrow |r' -r| = |b| \cdot |q - q'| \quad (*)$
> 
> D'altra parte, dato che $r, \, r' \geq 0$ allora $$
> |r' - r| \leq \max\{r', r\} < |b| \quad (*') \\ \Longrightarrow |q - q'| < 1$$ $q$ e $q'$ sono interi $\Rightarrow q = q'$. Da $(*)$ segue che $r = r'$.

> __Dimostrazione__ dell'esistenza, solo nel caso $a \geq 0, \, b > 0$.
> Procediamo per induzione su $a$, fissato $b$.
> __Passo base__: $a = 0$.
> Notiamo che $0 = b \cdot 0 + 0$, ho $q = 0$, $t = 0 \Rightarrow$ valgono le proprietà 1. e 2. del teorema.
> __Passo induttivo__: supponiamo che il teorema valga $\forall a' < a$. Vogliamo dimostrarlo per $a$. Abbiamo due casi:
> 1. $a < b$, noto che $a = b \cdot 0 + a$, $q = 0$ e $r = a$ ($0 \leq r < |b|$), di nuovo, i punti 1. e 2. del teorema valgono.
> 2. $a \geq b$, allora $0 < b \leq a \Rightarrow 0 \leq a - b < a$. 
>    - Posso applicare ipotesi induttiva (poiché $a' < a$) e divido $a'$ per $b$
>    - $\Rightarrow a-b = a' = b \cdot q' + r'$ con $q', \, r' \in \mathbb{Z}$ e $0 \leq r' < b$
>    - $\Rightarrow a = b\underbrace{(q' + 1)}_{=q} + \underbrace{r'}_{=r}$
>    - $\Rightarrow q = q' + 1$ e $r = r'$ sono il quoziente e il resto della divisione di $a$ per $b$ (punto 1. del teorema).
>    - Vale anche il punto 2. del teorema, infatti $0 \leq r = r' < b$.

__Osservazione__ 
$b|a \Leftrightarrow$ il resto della divisione di $a$ per $b$ è zero.

__Proposizione__
Sia $a \in \mathbb{Z}$ e sia $r$ il resto della divisione di $a$ per $n$, allora vale che: $$
[a]_n = [r]_n
$$
> __Dimostrazione__. 
> Sia $k \in \mathbb{Z}$ e $r$ il resto di $a:m$.
> - $a = k \cdot n + r$ con $0 \leq r < n$.
> - $a - r = k \cdot n \Rightarrow a \sim_n r \Rightarrow [a]_n = [r]_n$.
> 
> Posso ri-interpretare le classi di equivalenza: sia $0 \leq r < n$ ($r \in \mathbb{N}$), allora: $$
> [r]_n = \{ b \in \mathbb{Z} \: | \: \text{il resto della divisione di } b \text{ per } n \text{ è } r \}
> $$ Posso pensare: $\mathbb{Z}_n = \{ [0]_n, \, [1]_n, \, ..., \, [n-1]_n \}$ come l'insieme (anello) delle classi di resto modulo $n$. Ogni classe rappresenta un possibile resto della divisione di un intero per $n$.

Massimo Comun Divisore (M.C.D.) in $\mathbb{Z}$
 ~ Siano $a, \, b \in \mathbb{Z} \setminus \{ 0 \}$ due interi non nulli. Si dice _massimo comun divisore_ di $a$ e $b$ un numero intero $d$ tale che:
      1. $d|a$ e $d|b$
      2. Se $t \in \mathbb{Z} \setminus \{ 0 \}$ è tale che $t|a$ e $t|b$, allora $t|d$.
  
    Cioè $d$ è il più grande intero che divide $a$ e $b$. Un tale $d$ si denota con $\operatorname{MCD}(a, \, b)$.
    Osservazioni:
      1. Se $d = \operatorname{MCD}(a, \, b)$ allora anche $-d$ è un $\operatorname{MCD}$ di $a$ e $b$. Inoltre, $-d$ è l'unico altro $\operatorname{MCD}$ di $a$ e $b$.
      2. $\operatorname{MCD}(a, \, b) = \operatorname{MCD}(\pm a, \pm b)$.
      
__Teorema__. Algoritmo euclideo delle divisioni successive.
Sia $d$ un tale $\operatorname{MCD}$. Per ogni coppia di interi non nulli $a$ e $b$ esiste un $\operatorname{MCD}$ di $a$ e $b$. Inoltre, esistono $x$ e $y$ interi tali che (identità di bezout): $$
d = a \cdot x + b \cdot y
$$

Coprimi
 ~ Due interi $a$ e $b$ non nulli si dicono _coprimi_ (o primi fra loro) se $\operatorname{MCD}(a, \, b) = 1$.

