#include <stdio.h>

int main(void) {
    int n;
    printf("Inserisci un numero: ");
    scanf("%d", &n);

    for (int i = n-1; i > 1; i--) {
        if (n % i == 0) {
            printf("%d\n", i);
        }
    }
}