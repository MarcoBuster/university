package linked_list_2

// Returns the length (number of nodes) of x
func (x List) Length() (c int) {
	for x != nil {
		x = x.Next
		c++
	}
	return
}
