#include <stdlib.h>

int main() {
    int *p;
    p = (int *) malloc(sizeof(int) * 4);
    p[0] = 7;
    free(p);
    return 0;
}