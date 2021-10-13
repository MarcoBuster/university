#include <stdio.h>
#include <stdlib.h>

int main(void) {
    char c;
    int pos=0, open=0, close=0;
    int tooManyClosePos=-1;

    while ((c = getchar()) != '.') {
        if (c == '(') {
            open++;
        }
        else if (c == ')')
            close++;

        pos++;
        if (close > open && tooManyClosePos == -1)
            tooManyClosePos = pos;
    }
    if (open == close) {
        printf("Espressione ben parentesizzata");
        exit(0);
    }
    printf("Espressione non ben parentesizzata\n");
    if (tooManyClosePos != -1)
        printf("Carattere %d: troppe parentesi chiuse!", tooManyClosePos);
    else
        printf("Carattere %d: mancano parentesi chiuse alla fine!", pos);
    return 0;
}