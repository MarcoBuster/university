package check

/* Checks (iteratively) is the string s is palyndrome, and returns
   the corresponding boolean value. The string is assumed to be
   an ASCII string; the behavior on non-ASCII strings is unspecified. */
func RecursiveIsPalyn(s string) bool {
	if len(s) < 2 {
		return true
	}
	if s[0] != s[len(s)-1] {
		return false
	}
	return RecursiveIsPalyn(s[1 : len(s)-1])
}
