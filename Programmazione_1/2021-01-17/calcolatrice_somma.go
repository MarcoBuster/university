package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	var input string
	b := bufio.NewScanner(os.Stdin)
	b.Scan()
	input = strings.ReplaceAll(b.Text(), " ", "")
	splittedInput := strings.Split(input, "+")
	first, _ := strconv.Atoi(splittedInput[0])
	second, _ := strconv.Atoi(splittedInput[1])
	fmt.Println(first + second)
}
