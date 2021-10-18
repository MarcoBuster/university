#include <stdio.h>

int main(void) {
	int n, i;
	scanf("%d", &n);

	int seq[n];
	for (i=0; i < n; i++)
		scanf("%d", &seq[i]);

	int l=0, r=n-1, m;
	while (l <= r) {  // inspired by binary search
		m = ((l + r) / 2);
		if (seq[m] != m && ((m > 0 && seq[m-1] == m-1) || m == 0)) {
			printf("%d\n", m);
			break;
		} else if (m < seq[m])
			r = m - 1;
		else
			l = m + 1;
	}
	return 0;
}
