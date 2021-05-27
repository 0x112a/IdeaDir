package main

func Sum(numbers []int) int {
	sum := 0
	for _, v := range numbers {
		sum += v
	}
	return sum
}

func SumAll(numbs ...[]int) (sum []int) {
	for _, v := range numbs {
		sum = append(sum, Sum(v))
	}
	return
}

func SumAllTails(nums ...[]int) (sumTail []int) {
	for _, v := range nums {
		if len(v) == 1 || len(v) == 0 {
			sumTail = append(sumTail, 0)
			continue
		}
		sumTail = append(sumTail, Sum(v[1:]))
	}
	return
}
