#include <stdio.h>
#include <ctype.h>

#define N_LETTERE '['-'A'

int main(void) {
    char c, lettere[N_LETTERE] = {};
    int i, j;

    for (i=0; (c = getchar()) != '.'; i++)
        lettere[toupper(c)-'A']++;

    for (i=0; i<N_LETTERE; i++) {
        printf("%c ", i+'A');
        for (j=0; j<lettere[i]; j++)
            printf("*");
        printf("\n");
    }
    return 0;
}
