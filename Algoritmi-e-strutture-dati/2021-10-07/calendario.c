#include <stdio.h>

int days_in_a_month(int month) {
    switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
            return 30;
        case 2:
            return 28;
    }
    return -1;
}

int main(void) {
    int month, first;
    printf("Inserisci il numero del mese (1 = gennaio, ..., 12 = domenica): ");
    scanf("%d", &month);

    printf("Inserisci il giorno di inizio mese (1 = lunedì, ..., 7 = domenica): ");
    scanf("%d", &first);

    printf("L\tM\tM\tG\tV\tS\tD\n");

    int day = 1;
    int days = days_in_a_month(month);
    for (int i = 1; day <= days; i++) {
        (i < first) ? : printf("%d", day++);
        (i % 7 == 0) ? printf("\t\n") : printf("\t");
    }
    return 0;
}
