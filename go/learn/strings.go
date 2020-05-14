package main

import (
	"fmt"
	"unicode/utf8"
)

func main() {
	s := "我爱藤原书记"
	fmt.Println(s)
	for _, b := range []byte(s) {
		fmt.Printf("%x ", b)
	}
	fmt.Println()
	for i, v := range s {
		fmt.Printf("(%d %x)", i, v)
	}
	fmt.Println()
	fmt.Println("Rune count:",
		utf8.RuneCountInString(s))
	bytes := []byte(s)
	for len(bytes) > 0 {
		//DecodeLastRune 输出就全是 记，会输出6个哦
		v, size := utf8.DecodeRune(bytes)
		bytes = bytes[size:]
		fmt.Printf("%c", v)
	}
	fmt.Println()
	//rune 相当于 go的char
	//用rune遍历pos，rune
	//utf8.RuneCountInString 获得字符数量
	//len 获得字节长度
	// []byte获得字节
	//——————》 这样很容易获得寻找不含有重复字符的子串
	for i, v := range []rune(s) {
		fmt.Printf("(%d  %c)", i, v)
	}
	fmt.Println()

	//Fields: func Fields(s string) []string  (字符串空格分割)  去掉空格,把元素放入切片中
	/*
		fmt.Printf("Fields are: %q", strings.Fields("  foo bar  baz   "))

		Fields are: ["foo" "bar" "baz"]
	*/

	//Split: func Split(s, sep string) []string  (以指定的分隔符拆分,返回一组切片)
	/*
		fmt.Printf("%q\n", strings.Split("a,b,c", ","))   //%q 输出格式为:带引号的字符串
		fmt.Printf("%q\n", strings.Split("a man a plan a canal panama", "a "))
		fmt.Printf("%q\n", strings.Split(" xyz ", ""))
		fmt.Printf("%q\n", strings.Split("", "Bernardo O'Higgins"))

	*/

	//Join: func Join(a []string, sep string) string  (将一系列字符串连接为一个字符串，之间用sep来分隔。)
	/*
		s := []string{"foo", "bar", "baz"}
		fmt.Println(strings.Join(s, ", "))  //foo, bar, baz
	*/

	//Contains: 查询 func Contains(s, substr string) bool (判断字符串s是否包含子串)

	//Index: func Index(s, sep string) int (子串sep在字符串s中第一次出现的位置，不存在则返回-1。)

	//ToLower
	//ToUpper
	//Trim:  func Trim(s string, cutSet string) string   (去掉两端的字符,返回将s前后端所有cutset包含的utf-8码值都去掉的字符串。)
	/*
		fmt.Println(strings.Trim(" !!! Achtung! Achtung! !!! ", "! "))
		//会去掉字符串两端所有的"!"和" "

		Achtung! Achtung
	*/
	//TrimRight
	//TrimLeft

	//Repeat:   func Repeat(s string, count int) string  (返回count个s串联的字符串。)
	/*
		fmt.Println("ba" + strings.Repeat("na", 2)) //banana

	*/
}
