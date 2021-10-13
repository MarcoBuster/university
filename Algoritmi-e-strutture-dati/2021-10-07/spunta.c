#include <stdio.h>

int main(void) {
    int n;
    printf("Inserisci n: ");
    scanf("%d", &n);

    for (int i=0; i<n; i++) {
        for (int j=n+1; j>=0; j--) {
            if (i == j || 
                (j == n && i == n-2) ||
                (j == n+1 && i == n-3))
                printf("+");
            else
                printf(".");
            printf(" ");
        }
        printf("\n");
    }
    return 0;
}