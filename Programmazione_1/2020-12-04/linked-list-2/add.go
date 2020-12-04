package linked_list_2

// This function creates a new node with content s and appends it in the first
// position of list x. The new list is returned
func (x List) AddFront(s string) List {
	var n List
	n = new(Node)
	n.Content = s
	n.Next = x
	return n
}

// This function creates a new node with content s and appends it in the last
// position of list x. The new list is returned
func (x List) AddTail(s string) List {
	var n List
	n = new(Node)
	n.Content = s
	n.Next = nil // It was already nil, anyway
	if x == nil {
		return n
	}
	first := x
	for x.Next != nil {
		x = x.Next
	}
	x.Next = n
	return first
}

// This function creates a new node with content s and appends it in the right
// position of list x, so that if x was (lexicographically) sorted before, it
// remains lexicographically sorted. The new list is returned
func (x List) AddInOrder(s string) List {
	var n List
	n = new(Node)
	n.Content = s
	var prev, curr List
	prev = nil
	curr = x
	for curr != nil && curr.Content < s {
		prev = curr
		curr = curr.Next
	}
	// Now we insert between prev and curr
	if prev == nil { // We are inserting at the beginning
		n.Next = curr
		return n
	}
	prev.Next = n
	n.Next = curr
	return x
}
