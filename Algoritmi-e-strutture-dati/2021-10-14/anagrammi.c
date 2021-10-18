#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define N_LETTERE '['-'A'

int main(void) {
    char word1[100], word2[100];
    char Lword1[N_LETTERE] = {}, Lword2[N_LETTERE] = {};
    int i;

    scanf("%s", word1);
    for (i=0; i<strlen(word1); i++) {
        Lword1[toupper(word1[i])-'A']++;
    }

    scanf("%s", word2);
    for (i=0; i<strlen(word2); i++)
        Lword2[toupper(word2[i])-'A']++;

    for (i=0; i<N_LETTERE; i++) {
        if (Lword1[i] != Lword2[i]) {
            printf("Le due parole non sono anagrammi\n");
            exit(0);
        }
    }
    printf("Le due parole sono anagrammi");
    return 0;
}
