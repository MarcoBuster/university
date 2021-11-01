#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool palindroma(char *parola) {
	char *i = parola;
	char *j = parola + strlen(parola) * sizeof(char) - sizeof(char);  // *j = parola[-1]

	while (i < j) {
		if (*i != *j)
			return false;
		i += sizeof(char);
		j -= sizeof(char);
	}
	return true;
}

int main(int argc, char *argv[]) {
	char *parola;
	if (argc < 2)
		return 1;

	for (int i = 1; i < argc; i++) {
		parola = argv[i];
		if (palindroma(parola))
			printf("%s è palindroma", parola);
		else 
			printf("%s non è palindroma", parola);
		printf("\n");
	}
	return 0;
}
