package gen

/* Generates recursively a palyndrom string */
func RecursiveGenPalyn(n int) string {
	if n == 0 {
		return ""
	}
	if n == 1 {
		return genCharacter()
	}
	c := genCharacter()
	return c + RecursiveGenPalyn(n-2) + c
}
