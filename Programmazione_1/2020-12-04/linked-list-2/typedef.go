package linked_list_2

// A list Node is made by a string (the Node's Content) and a
// pointer to the next Node in the list (nil for the last node)
type Node struct {
	Content string
	Next    *Node
}

// A List is identified with the pointer to its first node
type List = *Node
