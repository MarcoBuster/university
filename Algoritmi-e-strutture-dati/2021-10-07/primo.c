#include <stdio.h>
#include <stdbool.h>

int main(void) {
    int n;
    printf("Inserisci un numero: ");
    scanf("%d", &n);

    bool prime = true;
    for(int i = 2; i <= n / 2; i++) {
        if (n % i == 0) {
            prime = false;
            break;
        }
    } 
    if (prime) {
        printf("Il numero inserito è primo.");
    } else {
        printf("Il numero inserito non è primo.");
    }
    return 0;
}
