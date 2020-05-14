package main

import "fmt"

//寻找最长不含有重复字符的子串
// abcabcbb ---> abc
// bbbbbb --->

//滑动窗口是数组/字符串问题中常用的抽象概念
//start（跳到当前最长字符串）---x  lastOccurred[x](最后出现的不在start内的字符)
func lengthOfLongestSubstring(s string) int {
	//把byte改成rune 支持中文哦
	lastOccurred := make(map[rune]int)
	start := 0
	maxLength := 0

	//[]rune(s) 算3个长度，我们要求中文和英文一眼只算一个
	for j, v := range []rune(s) {
		//查询元素
		if i, ok := lastOccurred[v]; ok && i >= start {
			start = i + 1
		}
		if j-start+1 > maxLength {
			maxLength = j - start + 1
		}
		lastOccurred[v] = j
	}
	return maxLength
}

func main() {
	//嘿嘿，有bug
	//改好了
	fmt.Println(lengthOfLongestSubstring("啊啊啊这里是答案"))
	fmt.Println(lengthOfLongestSubstring("abcabcddert"))
}
