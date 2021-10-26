#include <stdio.h>
#include <stdbool.h>

bool primo(int n) {
	for (int i = 2; i <= n / 2; i++) {
		if (n % i == 0)
			return false;
	}

	return true;
}

int main(void) {
	int n;
	scanf("%d", &n);

	if (primo(n))
		printf("%d è primo\n", n);
	else
		printf("%d non è primo\n", n);
	return 0;
}
