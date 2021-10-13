#include <stdio.h>

int main(void) {
    int n;
    printf("Inserisci n: ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            ((i+j) % 2 == 0) ? printf("o\t") : printf("+\t");
        printf("\n");
    }
    return 0;
}
