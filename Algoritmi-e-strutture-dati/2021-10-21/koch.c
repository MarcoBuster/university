#include <stdio.h>
#include "libpsgraph.h"

void koch_curve(double x, int i) {
	if (i == 0) {
		draw(x);
		return;
	}
	koch_curve(x/3, i-1);
	turn(-60);

	koch_curve(x/3, i-1);
	turn(120);

	koch_curve(x/3, i-1);
	turn(-60);

	koch_curve(x/3, i-1);
}

void koch_snowflake(int x, int i) {
	koch_curve(x, i);
	turn(120);
	koch_curve(x, i);
	turn(120);
	koch_curve(x, i);
	turn(120);
}

int main(void) {
	start("koch.ps");
	koch_snowflake(50, 4);
	end();
	return 0;
}
