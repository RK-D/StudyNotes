package main

import (
	"../err/fib"
	"bufio"
	"fmt"
	"io"
	"strings"
)

//  函数式编程 vs 函数指针
//函数: 参数，变量，返回值都可以是函数
//高阶函数:
//函数-> 闭包: 闭包就是能够读取其他函数内部变量的函数。

//一般函数值编程： 1.不可变性，不能有状态，只有常量和函数	2.函数只能有一个参数

//
//go 不一样:

func adder() func(int) int {
	sum := 0
	//下面是一个函数体
	return func(v int) int {
		sum += v
		return sum
	}
}

//斐波那契数列
func Fibonacci() func() int {
	a, b := 0, 1
	//递归
	return func() int {
		a, b = b, a+b
		return a
	}
}

//包装io.reader
//文件读入 然后打印
func printFile(reader io.Reader) {
	scanner := bufio.NewScanner(reader)
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}
}

type intGen func() int

//函数实现接口
//(g intGen) 写前面后面调用 f.read ，写后面是 read(f), 语法问题
func (g intGen) Read(p []byte) (n int, err error) {
	next := g()
	if next > 10000 {
		return 0, io.EOF
	}
	//TODO p太小会出错，如何连接被误读的数据，解决办法，存read
	s := fmt.Sprintf("%d\n", next)
	return strings.NewReader(s).Read(p)
}

func printFileContents(reader io.Reader) {
	scanner := bufio.NewScanner(reader)
	for i := 0; i < 15 && scanner.Scan(); i++ {
		fmt.Println(scanner.Text())
	}
}

func main() {
	a := adder()
	for i := 0; i < 10; i++ {
		fmt.Printf("0 + ... + %d = %d \n", i, a(i))
	}
	f := Fibonacci()
	fmt.Print(f())
	var b intGen = fib.Fibonacci()
	printFileContents(b)
}
