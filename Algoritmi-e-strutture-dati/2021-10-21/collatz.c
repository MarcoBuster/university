#include <stdio.h>

int collatz(int n) {
	return (n % 2 == 0) ? n / 2 : n * 3 + 1;
}

int main(void) {
	int n;
	printf("Inserisci n: ");
	scanf("%d", &n);

	for (; n != 1; n = collatz(n))
		printf("%d ", n);
	printf("%d\n", n);
	return 0;
}
