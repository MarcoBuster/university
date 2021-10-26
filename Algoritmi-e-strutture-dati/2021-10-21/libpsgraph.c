// Copyright (c) Università degli Studi di Milano.
// All rights reserved.

#include <stdio.h>
#include <stdlib.h>
#include <math.h>

FILE *f;
double g_x, g_y;
double dir;

void start( char *filename ) {
	f = fopen( filename, "wt" );
	fprintf( f, "%%!PS-Adobe-2.0\n" );
	g_x = 2*72;
	g_y = 7*72;
	fprintf( f, "%d %d moveto\n", (int)(g_x), (int)(g_y) );
	dir = 0.0;
}

void end() {
	fprintf( f, "stroke\nshowpage\n" );
	fclose( f );
}

void draw( double length ) {
	length /= 0.352777778;
	g_x += length * cos( dir );
	g_y += length * sin( dir );
	fprintf( f, "%d %d lineto\n", (int)(g_x), (int)(g_y) );
}

void move( double length ) {
	length /= 0.352777778;
	g_x += length * cos( dir );
	g_x += length * cos( dir );
	g_y += length * sin( dir );
	fprintf( f, "%d %d moveto\n", (int)(g_x), (int)(g_y) );
}

void turn( double ang ) {
	dir -= M_PI * ang / 180.0;
}
