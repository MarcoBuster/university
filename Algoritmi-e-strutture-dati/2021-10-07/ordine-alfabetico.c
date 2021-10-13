#include <stdio.h>
#include <stdlib.h>

int main(void) {
    char a, b;
    printf("Inserisci il primo carattere: ");
    scanf("%c ", &a);
    printf("Inserisci il secondo carattere: ");
    scanf(" %c", &b);

    printf("La distanza tra i due caratteri inseriti è %d", abs(a-b));
    return 0;
}
