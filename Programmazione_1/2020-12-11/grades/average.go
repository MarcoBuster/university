package grades

func Average(s Student) float64 {
	c := 0
	for _, x := range s.Score {
		if x == 32 {
			c += 30
		} else {
			c += x
		}
	}
	return float64(c) / float64(len(s.Score))
}

func Average110(s Student) float64 {
	m := Average(s)
	return 110 * m / 30
}
