#include "stdio.h"

void f1(int x[], int n) {
}
// equivalente a
void f2(int *x, int m) {
}

// funzione che dato un array di interi e
// dato un intero k che conta quanti sono
// i multipli di k nell'array
int contaMultipli(int a[], int n, int k) {
    int i, c;
    c = 0;
    for (i=0; i<n; i++) {
        if (a[i] % k == 0) {
            c++;
        }
    }
    return c;
}

int contaMultipliCattivo(int *a, int n, int k) {
    int c = 0;
    int *p;
    for (p = a; p-a<n; p++) {
        if (*p % k == 0)
            c++;
    }
    return c;
}

int main() {
    int a[] = {23, 10, 15};
    printf("%d %d", contaMultipli(a, 3, 5), contaMultipliCattivo(a, 3, 5));
    return 0;
}
