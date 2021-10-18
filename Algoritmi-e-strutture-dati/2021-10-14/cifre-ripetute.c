#include <stdio.h>

#define N_CIFRE 10

int main(void) {
    unsigned long long n, i;
    scanf("%lld", &n);

    int cifre[N_CIFRE] = {};
    for (i=n; i > 0; i /= N_CIFRE) {
        cifre[i % N_CIFRE]++;
    }

    int ricorrenze[N_CIFRE+1] = {}, j = 0;
    for (i=0; i < N_CIFRE; i++) {
        if (cifre[i] > 1) {
            ricorrenze[j] = i;
            j++;
        }
    }

    if (j > 0) {
        printf("Cifre ripetute: ");
        for (i=0; i<N_CIFRE+1 && ricorrenze[i] != 0; i++) {
            printf("%d", ricorrenze[i]);
            if (ricorrenze[i+1] != 0)
                printf(", ");
        }
    } else
        printf("Non ci sono cifre ripetute");
}
