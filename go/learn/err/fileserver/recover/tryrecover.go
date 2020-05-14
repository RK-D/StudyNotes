package main

import "fmt"

func tryRecover() {
	//具有re panic功能

	defer func() {
		r := recover()
		if err, ok := r.(error); ok {
			fmt.Println("error :", err)
		} else {
			panic(r)
		}
	}()
	//a := 0
	//b := 5 / a
	//fmt.Println(b)
	//
	panic(555)

}

func main() {
	tryRecover()
}
