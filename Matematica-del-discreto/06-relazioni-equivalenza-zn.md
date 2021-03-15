## Relazioni di equivalenza e $\mathbb{Z}_n$
Indico $\sim$ come una relazione di equivalenza (TL;DR: riflessiva, simmetrica, transitiva).

Classe d'equivalenza
 ~ Considero $A$ insieme e $\sim$ una relazione di equivalenza su $A$. La classe di equivalenza $a \in A$ è: $$
 [a]_\sim = \{ b \in A \: | \: b \sim a \} \underbrace{=}_{\sim \text{ è simmetrica}} \{ b \in A \: | \: a \sim b \}
 $$ cioè $[a]_\sim$ è l'insieme di tutti gli elementi in relazione con $a$.
 
__Teorema__
Sia $\sim$ una relazione di equivalenza su $A$, allora:
1. $\forall a \in A, \, a \in [a]_\sim$
> __Dimostrazione__. 
> $[a]_\sim = \{ b \in A \: | \: b \sim a \}$ ma $a \sim a$ (perché $\sim$ è riflessiva) $\Rightarrow a \sim a \Rightarrow a \in [a]_\sim$

2. $a \sim b \Leftrightarrow [a]_\sim = [b]_\sim$
> __Dimostrazione__ $\Longrightarrow$.
> - Voglio mostrare che $[a]_\sim = [b]_\sim$ cioè $[a]_\sim \subseteq [b]_\sim$ e $[b]_\sim \subseteq [a]_\sim$. 
> - Mostro $[a]_\sim \subseteq [b]_\sim$. Per ipotesi: $$
> \begin{cases}
> \forall x \in [a]_\sim & x \sim a \\
> & a \sim b
> \end{cases} \Longrightarrow x \sim b \Rightarrow x \in [b]_\sim
> $$ cioè $[a]_\sim \subseteq [b]_\sim$. 
> - $\forall y \in [b]_\sim, \, y \sim b$. $a \sim b$ per ipotesi, quindi $b \sim a$ (proprietà simmetrica). $y \sim b, \, b \sim a \Rightarrow y \sim a \Rightarrow y \in [a]_\sim \Rightarrow [b]_\sim \subseteq [a]_\sim \Rightarrow [b]_\sim = [a]_\sim$.
cases} \right \}

> __Dimostrazione__ $\Longleftarrow$.
> $\underbrace{a \in [a]_\sim}_\text{per prop. 1} = [b]_\sim \Rightarrow a \in [b]_\sim$ cioè $a \sim b$.

3. $a \nsim b \Leftrightarrow [a]_\sim \cup [b]_\sim = \varnothing$
> __Dimostrazione__ $\Longrightarrow$.
> _Per assurdo_, sia $x \in [a]_\sim \cap [b]_\sim \Rightarrow x \in [a]_\sim$, cioè $x \sim a$ e $x \in [b]_\sim$ cioè $x \sim b \Rightarrow x \sim a, \, x \sim b \Rightarrow a \sim x, \, x \sim b \Rightarrow a \sim b$, che è assurdo.

> __Dimostrazione__ $\Longleftarrow$.
> _per assurdo_, sia $a \sim b \Rightarrow [a]_\sim = [b]_\sim \Rightarrow a  \in [a]_\sim = [b]_\sim \Rightarrow a \in [a]_\sim \cap [b]_\sim$, che è assurdo.

**Corollario**
Le classi di equivalenza della relazione $\sim$ su $A$ sono una partizione di A. 
> __Dimostrazione__.
> - $[a]_\sim \neq [b]_\sim \overbrace{\Longrightarrow}^{\text{prop. 2}} a \nsim b \overbrace{\Longrightarrow}^{\text{prop. 3}} [a]_\sim \cap [b]_\sim = \varnothing$
> - $\forall a \in A, \, a \in [a]_\sim$

Insieme quoziente
 ~ L'insieme delle classi di equivalenza di $A$ rispetto a $\sim$ si chiama _insieme di equivalenza_ ed è: 
 $$A_{/\sim} = \{ [a]_\sim \: | \: a \in A \}$$
 
### Costruzione di $\mathbb{Z}_n$
Scelgo $n \in \mathbb{N} \neq 0$.

Congruenza modulo $\sim_n$
 ~ $A = \mathbb{Z}, \, n \in \mathbb{N} \neq 0$. $$
 \sim_n: \: \forall a, b \in \mathbb{Z}, \, a \sim_n b \Longleftrightarrow \exists h \in \mathbb{Z} \text{ tale che } a - b = hn
 $$
 
**Teorema**
$\sim_n$ è relazione di equivalenza.
> __Dimostrazione__.
> - $\sim_n$ è riflessiva: $\forall z \in \mathbb{Z}, \, z \sim z \text{ infatti } z - z = 0 \cdot n$
> - $\sim_n$ è simmetrica: $z \sim_n w \Rightarrow z - w = h \cdot (n) \Rightarrow w - z = (-h) \cdot n$
> - $\sim_n$ è transitiva: 
>   - $z \sim_n w \text{ e } w \sim_n u \Rightarrow z - w = hn \text{ e } w - u = kn$
>   - $\Rightarrow z - kn - u = hn$ 
>   - $\Rightarrow z - u = hn + kn = (h + k)n \Rightarrow z \sim_n u$.

Classi di resto modulo $n$
 ~ L'insieme $\mathbb{Z}_n$ è l'insieme quoziente $\mathbb{Z}_{/\sim_n}$ e viene detto _classi di resto modulo $n$_.
 
__Teorema__
Le operazioni $+$, $\cdot$ in $\mathbb{Z}$ "inducono" operazioni su $\mathbb{Z}_n = \mathbb{Z}_{/\sim_n}$ cioè sono compatibili con $\sim_n$.
1. $a \sim_n b, \, a' \sim_n b' \Rightarrow a + a' \sim_n b + b'$
> __Dimostrazione__.
> - $\begin{cases}
> a \sim_n b \Rightarrow \exists k \text{ tale che } a - b = kn \\
> a' \sim_n b' \Rightarrow \exists k' \text{ tale che } a' - b' = k'n
> \end{cases}$
> - $(a - b) + (a' - b') = kn + k'n$
> - $a + a' - (b + b') - (k + k')n$
> - $\Rightarrow a + a' \sim_n b + b'$

2. $a \sim_n b, \, a' \sim_n b' \Rightarrow a \cdot a' \sim_n b \cdot b'$

$+_n$
 ~ $+_n \! : \: \mathbb{Z}_n \times \mathbb{Z}_n \rightarrow \mathbb{Z}_n$
 $[a]_{\sim_n}, \, [b]_{\sim_n} \rightarrow [a]_{\sim_n} +_n [b]_{\sim_n} := [a + b]_{\sim_n}$
 
$\cdot_n$
 ~ $\cdot_n \! : \: \mathbb{Z}_n \times \mathbb{Z}_n \rightarrow \mathbb{Z}_n$
 $[a]_{\sim_n}, \, [b]_{\sim_n} \rightarrow [a]_{\sim_n}[b]_{\sim_n} := [a \cdot b]_{\sim_n}$
 
__Teorema__
Se $(\mathbb{Z}, +_n)$ è un gruppo abeliano, $(\mathbb{Z}_n, \cdot_n)$ un monoide, $(\mathbb{Z}_n, +_n, \cdot_n)$ un anello, in generale $(\mathbb{Z}_n, +_n, \cdot_n)$ non è campo. Però:
$$
(\mathbb{Z}_n, +_n, \cdot_n) \text{ è campo} \Longleftrightarrow n \text{ è un numero primo}
$$

