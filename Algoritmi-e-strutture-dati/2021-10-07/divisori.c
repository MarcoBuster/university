#include <stdio.h>

int main(void) {
    int n;
    printf("Inserisci n: ");
    scanf("%d", &n);
    
    int count = 0;
    for (int i=n; i>0; i--) {
        if (n % i == 0) {
            printf("%d\n", i);
            count++;
        }
    }
    printf("Numero di divisori: %d", count);
    return 0;
}
