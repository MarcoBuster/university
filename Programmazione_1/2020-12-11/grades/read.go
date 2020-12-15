package grades

import (
	"bufio"
	"errors"
	"os"
	"regexp"
	"strconv"
)

func ParseLine(line string) (stud Student, err error) {
	nameRE := regexp.MustCompile("([a-z]|[A-Z])([a-z]|[A-Z]|[0-9]|_)+")
	scoreRE := regexp.MustCompile("[1-3][0-9]")
	stud.Name = nameRE.FindString(line) // finds the first matching substring
	if len(stud.Name) == 0 {
		err = errors.New("Name of student is missing in line " + line)
		return
	}
	nameEndingIndex := nameRE.FindStringIndex(line)[1]          // finds the two indices delimiting the first matching string
	scores := scoreRE.FindAllString(line[nameEndingIndex:], -1) // finds all the scores
	for _, x := range scores {
		score, conv := strconv.Atoi(x)
		if score < 18 || score > 32 || score == 31 {
			err = errors.New("The score " + x + " is invalid in line " + line)
			return
		} else if conv != nil {
			err = conv
			return
		}
		stud.Score = append(stud.Score, score)
	}
	if len(stud.Score) == 0 {
		err = errors.New("No scores for student " + stud.Name + " in line " + line)
		return
	}
	return
}

func ReadFile(fileName string) (stud []Student, err error) {
	f, e := os.Open(fileName)
	if e != nil {
		err = e
		return
	}
	defer f.Close()
	b := bufio.NewScanner(f)
	for b.Scan() {
		line := b.Text()
		s, e := ParseLine(line)
		if e != nil {
			err = e
			return
		}
		stud = append(stud, s)
	}
	return
}
