/** Starts a new graph with given filename */
void start( char *filename );

/** Ends the graph */
void end();

/** Draws a line of given length (in millimeters) */
void draw( double length );

/** Makes a move of given length (in millimeters), without drawing */
void move( double length );

/** Turns right of a given angle (in degrees) */
void turn( double ang );
