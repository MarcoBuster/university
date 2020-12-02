package linked_list

// This function creates a new Node with content s and appends it in the
// first position of List x. The new List is returned.
func AddFront(x List, s string) List {
	var n List
	n = new(Node)
	n.Content = s // = (*n).Content
	n.Next = x    // = (*n).Next
	return n
}

// This function creates a new Node with content s and appends it in the
// last position of List x. The new List is returned.
func AddTail(x List, s string) List {
	var n List
	n = new(Node)
	n.Content = s // = (*n).Content
	n.Next = nil  // It was already nil, anyway
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

// This function creates a new Node with a content s and appends it in the
// right position of linked-list x, so that if x was (lexicographically) sorted before, it
// remains lexicographically sorted. The new List is returned
func AddInOrder(x List, s string) List {
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

// This function creates a new Node with a content s at the i-position of the List
// The updated List is returned
func AddAt(x List, s string, position int) List {
	var n List
	n = new(Node)
	n.Content = s

	if position == 0 {
		return AddFront(x, s)
	}

	var i int
	var done bool
	var prev, curr List
	curr = x
	for curr.Next != nil {
		prev = curr
		curr = curr.Next
		if i == position-1 {
			prev.Next = n
			n.Next = curr
			done = true
		}
		i++
	}
	if !done {
		return AddTail(x, s)
	}
	return x
}
