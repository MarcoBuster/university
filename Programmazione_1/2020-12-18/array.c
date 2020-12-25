#include <stdio.h>

void fill(int *x, int n) {  // int *x == int x[]
    int i;
    for (i=0; i<n; i++) {
        x[i] = 1;
    }
}

void arrayPrint(int *x, int n) {
    int i;
    for (i=0; i<n; i++) {
        printf("%d ", x[i]);
    }
    printf("\n");
}

int main() {
    // var p [100]Data
    // Data q[100];

    // var q [100]*Data
    // Data *s[100];

    // var x [10]int
    int x[10];
    // Il nome di un array x è sinomino di
    // &(x[0])

    int *p;
    p = x;  // p = &(x[0])

    int a[10], b[100];
    fill(a, 10);
    fill(b, 100);
    arrayPrint(a, 10);
    arrayPrint(b, 222);
    return 0;
}
