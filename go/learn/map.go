package main

import "fmt"

//map使用哈希表，必须可以比较相等
//除了slice，map，function的内奸类型都可以作为key
//自定义类型: strut类型不包含上述字段也可以作为key
//
func main() {
	//复合map 三种定义 m2 m3 不一样 ，nil可以运算
	m1 := map[string]string{
		"name ": "go",
		"id":    "007",
		"age":   "18",
		"code":  "easy",
	}
	m2 := make(map[string]int) //m2 == empty map
	//这种定义少用
	var m3 map[string]int //m3 == nil
	//m1输出顺序有时候会变 ----> 无序 ---> hashMap
	fmt.Println(m1)
	fmt.Println("m1遍历")
	for k, v := range m1 {
		fmt.Println(k, v)
	}
	//取一个不存在的元素，输出 string 的为空，int的为nil 即 0
	//加入ok，查到返回true or false
	//golang中逗号ok模式
	//，ok，第一个参数是一个值或者nil，第二个参数是true/false或者一个错误error。在一个需要赋值的if条件语句中，使用这种模式去检测第二个参数值会让代码显得优雅简洁。
	// ok可以换成err，效果类似
	elm, ok := m1["id"]
	fmt.Println(elm, ok)

	//这儿只能用;    ,==都不行
	if elm2, ok := m1["id"]; ok {
		fmt.Println(elm2)
		//删除方法，指定表和他的key
		delete(m1, "id")
	} else {
		fmt.Println("key is null")
	}

	//map无序，可以手动放进slice排序

	fmt.Println(m2)
	fmt.Println(m3)
}
