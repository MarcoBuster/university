package check

/* Checks (iteratively) is the string s is palyndrome, and returns
   the corresponding boolean value. The string is assumed to be
   an ASCII string; the behavior on non-ASCII strings is unspecified. */
func IterIsPalyn(s string) bool {
	n := len(s)
	for i := 0; i < n/2; i++ {
		if s != string(s[n-i-1]) {
			return false
		}
	}
	return true
}
