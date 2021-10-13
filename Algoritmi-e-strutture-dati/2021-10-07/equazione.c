#include <stdio.h>
#include <math.h>

int main(void) {
    float a, b, c;
    printf("Risoluzione di ax^2 + bx + c per x\n");
    printf("Inserisci a: ");
    scanf("%f", &a);
    printf("Inserisci b: ");
    scanf("%f", &b);
    printf("Inserisci c: ");
    scanf("%f", &c);

    float delta;
    delta = b * b - 4 * a * c;

    if (delta >= 0) {
        float x1, x2;
        x1 = (-b + sqrt(delta)) / 2*a;
        x2 = (-b - sqrt(delta)) / 2*a;
        printf("L'equazione ha due soluzioni reali\n");
        printf("x1=%.2f\nx2=%.2f", x1, x2);
    } else {
        float re, im;
        re = (-b) / 2*a;
        im = sqrt(-delta) / (2*a);
        printf("L'equazione ha due soluzioni immaginarie\n");
        printf("x1=%.2f + %.2fi\n", re, im);
        printf("x2=%.2f - %.2fi", re, im);
    }
    return 0;
}
