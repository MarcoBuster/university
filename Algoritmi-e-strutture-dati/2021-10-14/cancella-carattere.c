#include <stdio.h>
#include <string.h>

int main(void) {
    char c, input[100];
    int i;

    for (i=0; (c = getchar()) != '\n'; i++)
        input[i] = c;

    for (i=0; i<strlen(input)-1; i++)
        if (input[i+1] != ' ')
            printf("%c", input[i]);
}
