#include <stdio.h>
#include <stdbool.h>

struct Date {
    unsigned short int d, m;
    int y;
};

bool is_before(struct Date d1, struct Date d2) {
    if (d1.y != d2.y)
        return d1.y < d2.y;
    if (d1.m != d2.m)
        return d1.m < d2.m;
    return d1.d < d2.d;
}

int main(void) {
    struct Date date, split_date, dates[100] = {};
    int i, c;

    for (c=0;; c++) {
        scanf("%hd/%hd/%d", &(date.d), &(date.m), &(date.y));
        if (date.d == 0 && date.m == 0 && date.y == 0)
            break;

        dates[c] = date;
    };
    scanf("%hd/%hd/%d", &(split_date.d), &(split_date.m), &(split_date.y));

    for (i=0; i<c; i++) {
        date = dates[i];
        if (is_before(date, split_date))
            printf("%02hd/%02hd/%02d", date.d, date.m, date.y);
    }
    return 0;
}
