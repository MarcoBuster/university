#include <stdio.h>

#define L_SEQ 100

void insert(int vect[], int idx, int el) {
    for (int i=L_SEQ-2; i >= idx; i--) {
        vect[i+1] = vect[i];
    }
    vect[idx] = el;
}

int main(void) {
    int n, seq[L_SEQ] = {};
    int i;

    scanf("%d", &n);
    while (n != 0) {
        for (i=0; i < L_SEQ; i++) {
            if (n < seq[i] || seq[i] == 0) {
                insert(seq, i, n);
                break;
            }
        }
        scanf("%d", &n);
    }

    for (i=0; i < L_SEQ && seq[i] != 0; i++)
        printf("[%d] %d\n", i, seq[i]);
    return 0;
}
