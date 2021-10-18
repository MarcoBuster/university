#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
    char input[100+1];
    scanf("%s", input);

    const int len = strlen(input);
    for (int i=0; i < len/2; i++) {
        if (input[i] != input[len-1-i]) {
            printf("Parola non palindroma");
            exit(0);
        }
    }
    printf("Parola palindroma");
    return 0;
}
