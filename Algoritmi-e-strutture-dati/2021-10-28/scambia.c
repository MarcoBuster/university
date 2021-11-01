#include <stdio.h>

void scambia(int *p, int *q) {
	int tmp;
	tmp = *p;
	*p = *q;
	*q = tmp;
}

int main() {
	int a, b;
	printf("a? ");
	scanf("%d", &a);
	printf("b? ");
	scanf("%d", &b);
	scambia(&a, &b);
	printf("a=%d, b=%d", a, b);
	return 0;
}
