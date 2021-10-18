#include <stdio.h>
#include <string.h>

int main(void) {
    char c, input[100];
    int i, key;

    for (i=0; (c = getchar()) != '.'; i++)
        input[i] = c;

    printf("Inserisci chiave numerica: ");
    scanf("%d", &key);

    for (i=0; i<strlen(input); i++)
        printf("%c", (input[i] - '0' + key) % ('z' - '0') + '0');
    return 0;
}
