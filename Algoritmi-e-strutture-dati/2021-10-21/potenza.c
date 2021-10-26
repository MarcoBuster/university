#include <stdio.h>

int potenza(int b, int e) {
	if (e == 0)
		return 1;
	if (e == 1)
		return b;
	return potenza(b*b, e-1);
}

int main(void) {
	int b, e;
	printf("Inserisci base: ");
	scanf("%d", &b);
	printf("Inserisci espontente: ");
	scanf("%d", &e);
	printf("La potenza (%d)^(%d) è uguale a %d\n", b, e, potenza(b, e));
	return 0;
}
