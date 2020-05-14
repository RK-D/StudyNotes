package main

import (
	"./module"
	"bufio"
	"fmt"
	"io/ioutil"
	"math"
	"os"
	"reflect"
	"runtime"
	"strconv"
)

//方便定义
var (
	aa = 1
	bb = 2
)

/**计算*/
func triangle() {
	var a, b int = 3, 4
	var c int
	c = int(math.Sqrt(float64((a*a + b*b)))) //涉及到底层要求，go必须显示传值，，并且sqrt传入float
	fmt.Println(c)
}

/**常量定义*/
//const filename  = "test.txt"
func consts() {
	//const filename  = "test.txt"
	//const a, b  = 3,4
	const (
		filename = "abc.txt"
		a, b     = 3, 4
	)

	var c int
	c = int(math.Sqrt(float64(a*a + b*b)))
	fmt.Println(filename, c)
}

//enum
func enums() {
	const (
		//iota 一组自增值
		cpp = iota
		java
		python
		golang
	)
	const (
		//避免constant 1125899906842624 overflows int
		b int64 = 1 << (10 * iota)
		kb
		mb
		gb
		tb
		pb
	)
	fmt.Println(cpp, java, python, golang)
	fmt.Println(b, kb, pb, mb, gb, tb, pb)
}

//if
func oldOpenFile() {
	const filename = "test.txt"
	//contents,err := ioutil.ReadFile(filename) //返回两个值，go的优点，返回值可以多个
	//if err != nil{
	//	fmt.Println(err)
	//}else {
	//	fmt.Printf("%s\n",contents)
	//}
	/**
	零值 nil
	指针类型（包括unsafe中的）
	map类型
	slice类型
	function类型
	channel类型
	interface类型

	true和false的默认类型是bool
	iota的预先定义类型是int
	*/

	if contents, err := ioutil.ReadFile(filename); err != nil {
		fmt.Println(err)
	} else {
		fmt.Printf("%s\n", contents)
	}
}

//分支
//switch 1, auto break or use fallthrough need break
// a,b传入值，op操作符，int为返回类型
func eval(a, b int, op string) int {
	var result int
	switch op {
	case "+":
		result = a + b
	case "-":
		result = a - b
	default:
		panic("null " + op)
	}
	return result
}

//switch 2
func grade(score int) string {
	g := ""
	switch {
	//代替default
	case score < 0 || score > 100:
		panic(fmt.Sprintf("error :%d", score))
	case score < 60:
		g = "C"
	case score < 80:
		g = "B"
	case score <= 100:
		g = "A"
	}
	return g
}

//循环
//for 必须没括号， 可以省略出事条件，结束条件，递增表达式
//二进制转换,取模往前加，直接实现 10 ---> 2
func convertToBin(n int) string {
	result := ""
	if n == 0 {
		//strconv.Itoa()函数的参数是一个整型数字，它可以将数字转换成对应的字符串类型的数字。
		//string函数的参数若是一个整型数字，它将该整型数字转换成ASCII码值等于该整形数字的字符。
		//result = string(n) 这么转是不行的,下面的才行

		result = strconv.Itoa(n)
		return result
	}
	for ; n > 0; n /= 2 {
		lsb := n % 2
		result = strconv.Itoa(lsb) + result
		//往后加的思路则是,这样结果是不对的
		//result = result + strconv.Itoa(lsb)
	}
	return result
}

//递增循环, 一行一行读文件
func printFile(filename string) {
	//打开文件
	file, err := os.Open(filename)
	//判断文件
	if err != nil {
		//panic 报错的意思
		panic(err)
	}
	//一行行读文件
	scanner := bufio.NewScanner(file)
	//go就压根就没有while ，哇哈哈，爽，终于不用被api折磨了，这就是while
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}
}

//好写的死循环,go的并发很容易，很重要
func forever() {
	for {
		fmt.Println("ing")
	}
}

//多返回值函数，q,r起提示作用
func div(a, b int) (q, r int) {
	return a / b, a % b
	//与下面等价，上 面的好用
	//q = a / b
	//r = a % b
	//return
}

//函数式编程重写，switch， op是一个函数，op有连个参数，apply的参数的op，返回值也是一个int参数
func apply(op func(int, int) int, a, b int) int {
	//反射
	p := reflect.ValueOf(op).Pointer()
	//获取它的指针
	opName := runtime.FuncForPC(p).Name()
	fmt.Printf("fun %s: "+"(%d, %d)", opName, a, b)
	return op(a, b)
}

//自定义int型pow
func pow(a, b int) int {
	return int(math.Pow(float64(a), float64(b)))
}

//函数可变参数列表，go函数没一堆花哨东西,用起来就像使用数组一样
func sum(nums ...int) int {
	s := 0
	for i := range nums {
		s += nums[i]
	}
	return s
}

//指针，指针不能运算（c的却可以运算），( c/c++ 值传递，引用传递) (java/python 引用传递，系统自定义的为引用传递如int)
/**
ps:void 没有返回值哦，所以a++值没返回，就能直观看到两者区别了
c/c++ 值传递void fun1 (int a){
		a++
		}
	  引用传递void fun2 (int& a){
		a++
		}
	int main{
	int a = 3;
	fun1(a)
	print(a)  --> a: 3  (拷贝一份，去++ ，原来的值不变)
	fun2(a)
	print(a)  --> a: 4	(不拷贝，引用同一个数，++改变原来的a所以a++)
}
  GO语言 -->只有值传递（下面模拟引用传递保证性能）
	var a int    	func f(p * int)
		&a		|			p    -->操作同一个a
	Cache(类似其他语言的Object)，go定义时就要考虑用值还是指针
*/
//交换函数两种方法
//利用指针改变地址
func swap(a, b *int) {
	*a, *b = *b, *a
}

//把值返回出去，这样做安全
func swap2(a, b int) (int, int) {
	return b, a
}

func main() {

	fmt.Println("aaa")
	module.Test() //大写字母表示函数public，否则无法调用

	triangle()
	consts()
	enums()
	oldOpenFile()

	//不加fmt.println 不会打印哦，写代码犯糊涂
	fmt.Println(
		grade(0),
		grade(50),
		grade(70),

		convertToBin(13),
		convertToBin(0),
	)

	printFile("test.txt")
	//forever()
	fmt.Println(apply(pow, 3, 4))
	//效果同上
	fmt.Println(apply(
		func(a int, b int) int {
			return int(math.Pow(float64(a), float64(b)))
		}, 3, 4))

	fmt.Println(sum(1, 2, 4, 5))

}
