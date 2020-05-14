package main

import (
	"fmt"
)

/**	数组 range大法好用 java（1.8） python（3.7） 只有foreach 只能value 不能同时获取i，v
	c++（我只学到11）没有
go数组是值类型
[10] int [4]int 这两个数组认为是不同类型
*/

//拷贝数组，调用，值传递，  其他大部分数组都是 引用传递
func printArray(arr [10]int) {
	for i, v := range arr {
		fmt.Println(i, v)
	}
}

func main() {
	//1.定义数组4种方法 数量写在类型前面
	var array1 [10]int
	array2 := [3]int{1, 2, 3}
	array3 := [...]int{2, 3, 4, 5, 6, 7} //不加...是切片
	var array4 [5][4]int                 //5行4列
	fmt.Println(array1, array2, array3)
	fmt.Println(array4)
	//很low 的for
	for i := 0; i < len(array3); i++ {
		fmt.Println(array3[i])
	}
	fmt.Println()
	//推荐用法遍历,i下标，v值，不想查看时用 _ 替代i或者v
	for i, v := range array3 {
		fmt.Println(i, v)
	}
	printArray(array1)
	//printArray(array2)
	//cannot use array2 (type [3]int) as type [10]int in argument to printArray
	//go认为这是两个不同的类型
	//printArray(&array1) 原函数加* 改变成引用传递，但是麻烦
	printArray(array1)

	//推荐使用切片
}
