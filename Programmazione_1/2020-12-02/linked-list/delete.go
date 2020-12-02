package linked_list

// This function deletes the i-positioned Node from a List
// The updated List is returned
func DeleteItem(x List, position int) List {
	if position == 0 {
		return x.Next
	}

	var i int
	var prev, curr List
	curr = x
	for curr.Next != nil {
		i++
		prev = curr
		curr = curr.Next
		if i == position {
			prev.Next = curr.Next
		}
	}
	return x
}
