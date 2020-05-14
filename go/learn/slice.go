package main

import "fmt"

//slice 切片，不用啥数组指针，痛苦，切片基本都是，半开半闭区间 [) reSlice一个操作

func updateSlice(s []int) {
	s[0] = 100
}

func printSlice(s []int) {
	fmt.Printf("len=%d, cap=%d\n", len(s), cap(s))
}
func main() {
	arr := [...]int{1, 2, 3, 4, 5, 6, 7, 8, 9}
	fmt.Println("arr[2:5]=", arr[2:5])
	fmt.Println("arr[:5]=", arr[:5])
	fmt.Println("arr[2:]=", arr[2:])
	fmt.Println("arr[:]=", arr[:]) //arr 等价 arr[:]

	s1 := arr[2:4]
	fmt.Println("arr[:]=", s1)
	updateSlice(s1)
	fmt.Println("after Slice")
	fmt.Println(s1)
	fmt.Println(arr)
	//reSlice
	s2 := s1[3:5]
	fmt.Println("s2", s2)
	s2 = s2[:4]
	fmt.Println("reSlice")
	fmt.Println("s2", s2)
	s2 = s2[2:]
	fmt.Println("s2", s2)

	//Slice扩展
	s3 := arr[2:6]
	//slice扩展 s4  （只能向后扩展，不可向前，不可以超越底层数组长度）
	/*						slice（ ptr len capacity（cap））
						111111 		1111111111111  1111111111111111
	 							ptr
	  							   |       len  |
	 							   |  capacity					  |
	 ps: cap len 都是系统可以用的
	*/
	s4 := s3[3:5]
	s5 := arr[3:5]
	fmt.Println("s3", s3)
	fmt.Println("扩展_s4", s4)
	fmt.Println("s5", s5)

	//slice添加数据
	s6 := append(s4, 10)
	fmt.Println("in s4_s6 = ", s6)
	s7 := append(s5, 100)
	fmt.Println("after s7 in s4_s6 = ", s6)
	fmt.Println("in s5_s7 = ", s7)
	fmt.Println("arr =", arr)

	var s []int
	for i := 0; i < 100; i++ {
		printSlice(s)
		//cap 自扩容，append实现
		//func append(slice []Type, elems ...Type) []Type
		//func copy(dst, src []Type) int
		s = append(s, 2*i+1)
	}
	fmt.Println(s)
	//func make(t Type, size ...IntegerType) Type
	//三种其他创建slice方法
	s9 := make([]int, 16)
	s10 := make([]int, 10, 30)
	s11 := []int{1, 3, 5, 7}
	//func new(Type) *Type
	printSlice(s9)
	printSlice(s10)
	printSlice(s11)

	fmt.Println("copy slice")
	//func delete(m map[Type]Type1, key Type)
	printSlice(s11)
	printSlice(s9)
	copy(s9, s11)
	printSlice(s9)
	fmt.Println(s11)
	fmt.Println(s9)

	fmt.Println("delete slice")
	//删点第四个元素，cap却不变
	s9 = append(s9[:3], s9[4:]...)
	fmt.Println(s9)
	printSlice(s9)

	fmt.Println("delete front")
	front := s9[0]
	s9 = s9[1:]
	fmt.Println(front)
	fmt.Println(s9)
	printSlice(s9)

	fmt.Println("delete tail")
	tail := s9[len(s9)-1]
	s9 = s9[:len(s9)-1]
	fmt.Println(tail)
	fmt.Println(s9)
	printSlice(s9)
}
