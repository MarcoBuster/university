package main

import (
	"fmt"
	"os"
	"strconv"
)

type Date struct {
	day   int
	month int
	year  int
}

func safeStringToInt(str string) int {
	res, err := strconv.Atoi(str)
	if err != nil {
		fmt.Println("Invalid input")
		os.Exit(1)
	}
	return res
}

// Returns a parsed Date struct from a %d/%m/%Y string.
// Examples of valid formats: 2/1/1945, 02/01/1945, 02/1/1945, 2/01/1945, 000002/000001/1945
func parseDate(dateStr string) Date {
	// The "/" character is used to delimitate the end of a substring
	var date Date           // Resulting date
	dateStr = dateStr + "/" // Append "/" at the end so the algorithm knows where the string ends
	step, oldIndex := 0, 0
	for i, c := range dateStr {
		if c == '/' {
			switch step {
			case 0:
				date.day = safeStringToInt(dateStr[oldIndex:i])
			case 1:
				date.month = safeStringToInt(dateStr[oldIndex:i])
			case 2:
				date.year = safeStringToInt(dateStr[oldIndex:i])
			}
			oldIndex = i + 1 // plus 1 because it skips the "/"
			step++
		}
	}
	return date
}

func isLeapYear(year int) bool {
	return (year%100 == 0 && year%400 == 0) || (year%100 != 0 && year%4 == 0)
}

func daysInAMonth(month int, year int) int {
	if month > 12 { // Month hack
		month = month % 12
	}
	switch month {
	case 1, 3, 5, 7, 8, 10, 12:
		return 31
	case 4, 6, 9, 11:
		return 30
	case 2:
		if isLeapYear(year) {
			return 29
		} else {
			return 28
		}
	}
	return 0
}

// https://www.youtube.com/watch?v=-5wpm-gesOY
// Returns the number of days between two dates (date1 < date2)
// It supports leap years and various corner cases
func daysBetweenTwoDates(date1, date2 Date) (days int) {
	if date1.month > date2.month {
		date2.month += 12
		date2.year--
	}
	days = date2.day - date1.day
	for i := date1.month; i < date2.month; i++ {
		days += daysInAMonth(i, date2.year+1)
	}

	for i := date1.year + 1; i <= date2.year; i++ {
		if isLeapYear(i) && (i != date2.year || date2.month > 2 || (date2.month == 2 && date2.day == 29)) {
			days += 366
		} else {
			days += 365
		}
	}
	return
}

func main() {
	if len(os.Args) < 3 {
		fmt.Println("Too few arguments. Usage: ./differenza-giorni-date DATE_1 DATE_2")
		os.Exit(1)
	}
	firstDate := parseDate(os.Args[1])
	secondDate := parseDate(os.Args[2])
	fmt.Println("Date1:", firstDate)
	fmt.Println("Date2:", secondDate)
	fmt.Printf("Result: %d days", daysBetweenTwoDates(firstDate, secondDate))
}
