#include <string.h>
#include <stdlib.h>

int strlen_(char *s) {
    char *p;
    for (p=s; *p; p++);
    return p-s;
}

void strcat_(char *s1, char *s2) {
    char *p1, *p2;
    for (p1=s1; *p1; p1++);
    for (p2=s2; *p2; p2++, p2++)
        *p1 = *p2;
    *p1 = 0;
}

char strchr_(char *s, char c) {
    for (; *s; s++) {
        if (*s == c) {
            return *s;
        }
        return NULL;
    }
}

char* strdup_(char *s) {
    int n, i;
    n = strlen_(s);
    char *p;
    p = (char *) malloc(n+1);
    for (i=0; i<=n; i++)
        p[i] = s[i];
    return p;
}

int main() {
    char c; // 1 byte
    c = 'A';

    // in C non esistono le stringhe; usiamo array di char (US ASCII)
    char s[100];
    int n;
    scanf("%s", &s);
    printf("%d\n", strlen_(s));
    return 0;
}