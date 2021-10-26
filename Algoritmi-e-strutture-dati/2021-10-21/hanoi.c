#include <stdio.h>

#define N_PILES 3
#define MAX 32

void print_disks(char disks[N_PILES][MAX]) {
	int i, j;
	for (i = 0; i < N_PILES; i++) {
		for (j = 0; disks[i][j] != 0; j++)
			printf("%c", disks[i][j]);
		printf(i != N_PILES-1 ? ", " : "\n");
	}
}

void transfer(char disks[N_PILES][MAX], int from, int to) {
	int i, from_idx = 0, to_idx = 0;

	for (i = 0; disks[from][i] != 0; i++)
		from_idx = i;

	for (i = 0; disks[to][i] != 0; i++)
		to_idx = i+1;

	disks[to][to_idx] = disks[from][from_idx];
	disks[from][from_idx] = 0;
	print_disks(disks);
}

void hanoi(int n, int from, int temp, int to, char disks[N_PILES][MAX]) {
	if (n == 1) {
		transfer(disks, from, to);
		return;
	}
	hanoi(n-1, from, to, temp, disks);
	transfer(disks, from, to);
	hanoi(n-1, temp, from, to, disks);
}

int main(void) {
	int n;
	printf("n? ");
	scanf("%d", &n);

	char disks[N_PILES][MAX];
	for (int i = 0; i < N_PILES; i++) {
		for (int j = 0; j < n; j++) {
			if (i == 0)
				disks[i][j] = 'A' + j;
			else
				disks[i][j] = 0;
		}
	}
	print_disks(disks);
	hanoi(n, 0, 1, 2, disks);
	return 0;
}
