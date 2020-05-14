package main

//哈，没啥神奇和特别的，就是说下咋实现接口
//即能同时实现多个接口
//又具有 python , C++ 的 Duck Typing 灵活性
//又具有 java 的类型检查。

//接口实现是隐式的，只要实现接口里的方法

import (
	"./mock"
	"./real"
	"fmt"
	"time"
)

const url = "http://www.baidu.com"

type Retriever interface {
	Get(url string) string
}

type Poster interface {
	Post(url string, form map[string]string) string
}

func post(poster Poster) {
	poster.Post(url,
		map[string]string{
			"name":   "ccmouse",
			"course": "golang",
		})
}

//非常灵活的封装go， 利用interface
//io.ReadWriter()
//仿照实现
type RetrieverPoster interface {
	Retriever
	Poster
}

func session(s RetrieverPoster) string {
	s.Post(url, map[string]string{
		"contents": "other",
	})
	return s.Get(url)
}

func download(r Retriever) string {
	return r.Get(url)
}

func inspect(r Retriever) {
	fmt.Printf("%T %v\n", r, r)
	fmt.Printf("Type Switch: ")
	switch v := r.(type) {
	//case mock.Retriever:
	case *mock.Retriever:
		fmt.Printf("Contents:", v.Contents)
	case *real.Retriever:
		fmt.Printf("UserAgent:", v.UserAgent)
	}
}
func main() {
	var r Retriever
	// interface 有两个结构有两个东西，值（拷贝，大量数据很慢）或者指针（接口一半含有指针，inspect 看这个接口的指针类型）

	//接口本身包含一个指针，不要使用地址 ，接口变量有实现者类型和指针，指针指向实现者
	// 接口变量同样采用值传递
	re := mock.Retriever{"this is a fake"}
	//r = re
	r = &re
	inspect(r)

	//这里传值，试着看下有没有指针,（不加-）显然得出的是值，而非指针
	//加* : (panic: interface conversion: main.Retriever is mock.Retriever, not *mock.Retriever)
	//		(panic：接口转换：main.Retriever是模拟的。Retriever，不是* mock.Retriever)
	mockRetriever := r.(*mock.Retriever)
	fmt.Printf(mockRetriever.Contents)
	fmt.Println()
	r = &real.Retriever{
		UserAgent: "Mozilla/4.0",
		TimeOut:   time.Minute,
	}

	// 查看接口指针类型 法1
	inspect(r)
	// 查看接口指针类型 法2
	// 不加* panic: interface conversion: main.Retriever is *real.Retriever, not real.Retriever
	//（panic：接口转换：main.Retriever是* real.Retriever，不是real.Retriever）
	//realRetriever := r.(real.Retriever)
	realRetriever := r.(*real.Retriever)
	fmt.Println(realRetriever.TimeOut)

	//fmt.Println(download(r))
	//fmt.Println(download(mock.Retriever{"this is a fake"}))
	//type assertion 类型断言

	//if mockRetriever, ok := r.(mock.Retriever); ok{
	if mockRetriever, ok := r.(*mock.Retriever); ok {
		fmt.Println(mockRetriever.Contents)
	} else {
		fmt.Println("not a mock retriever")
	}

	fmt.Println(session(&re))

	//常用接口
	// java-toString()

}
