#include <stdio.h>
#include <stdlib.h>

struct Time {
    int h, m, s;
};

int time_to_seconds(struct Time t) {
    return t.h * 60 * 60 + t.m * 60 + t.s;
}

struct Time seconds_to_time(int seconds) {
    struct Time t;
    t.s = seconds % 60;
    t.m = ((seconds - t.s) / 60) % 60;
    t.h = (seconds - (t.s + t.m * 60)) / (60 * 60);
    return t;
}

int main(void) {
    struct Time t1, t2;

    printf("Inserisci il primo orario, in formato HH:MM:SS (24h):\n");
    scanf("%d:%d:%d", &(t1.h), &(t1.m), &(t1.s));
    printf("Inserisci il secondo orario, in formato HH:MM:SS (24h):\n");
    scanf("%d:%d:%d", &(t2.h), &(t2.m), &(t2.s));

    int delta_s = time_to_seconds(t1) - time_to_seconds(t2);
    delta_s = abs(delta_s);
    struct Time delta_t = seconds_to_time(delta_s);
    printf("\nDifferenza: %02d:%02d:%02d", delta_t.h, delta_t.m, delta_t.s);
    return 0;
}