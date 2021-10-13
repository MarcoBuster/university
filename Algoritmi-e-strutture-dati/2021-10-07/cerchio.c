#include <stdio.h>
#include <math.h>

int main(void) {
    float raggio;
    printf("Inserisci raggio: ");
    scanf("%f", &raggio);

    float area;
    area = M_PI * raggio * 2;
    printf("Area: %f", area);
    return 0;
}
