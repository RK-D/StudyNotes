package main

import (
	"../fib"
	"bufio"
	"fmt"
	"os"
)

func tryDefer1() {
	//defer是一个栈，第一个最后执行，越往下，越先执行，仅对defer有效
	defer fmt.Println(1)
	defer fmt.Println(3)
	fmt.Println(4)
	panic("err")
	fmt.Println(2)
}

//defer test
func tryDefer2() {
	for i := 0; i < 100; i++ {
		defer fmt.Println(i)
		if i == 10 {
			panic("end")
		}
	}
}
func writerFile(filename string) {
	file, err := os.Create(filename)
	if err != nil {
		panic(err)
	}
	//及时关掉，防止忘了结束时关，用defer
	defer file.Close()
	writer := bufio.NewWriter(file)
	//没有下面这句会出现fib.txt为空
	defer writer.Flush()

	f := fib.Fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Fprintln(writer, f())
	}
}

//err处理
//func OpenFile(name string, flag int, perm FileMode)  (*File, error)
// OpenFile是广义的open调用；大多数用户将使用Open 或Create代替。它打开带有指定标志 的命名文件（O_RDONLY等）。
//如果文件不存在，并且传递了O_CREATE标志 ，则使用模式perm（在umask之前）创建文件。如果成功，
//返回文件的方法可以用于I / O。
//如果有错误，它将是* PathError类型

//@FileMode 文件模式
//下面的file被定义为指针哦
func writerFile2(filename string) {
	file, err := os.OpenFile(
		filename, os.O_EXCL|os.O_CREATE, 0666)
	if err != nil {
		//fmt.Println("err",err.Error())
		if PathError, ok := err.(*os.PathError); !ok {
			panic(err)
		} else {
			fmt.Printf("%s, %s, %s\n",
				PathError.Op,
				PathError.Path,
				PathError.Err)
		}
		return
	}
	//及时关掉，防止忘了结束时关，用defer
	defer file.Close()
	writer := bufio.NewWriter(file)
	//没有下面这句会出现fib.txt为空
	defer writer.Flush()

	f := fib.Fibonacci()
	for i := 0; i < 10; i++ {
		fmt.Fprintln(writer, f())
	}
}
func main() {
	//tryDefer()
	tryDefer2()
	writerFile("fib.txt")
	writerFile2("fibNew.txt")
}
