package module

//每个目录只有一个包（报名可以和目录名不同），main包包含可执行入口，一个目录下只能有一个main包
//
//名字使用CamelCase   首字母大写public 小写 private ---> 针对包的public和private

import "fmt"

func Test() {
	fmt.Println("bbb")
}

//ps: 变量都用大写，否则外面用不了
type Node struct {
	Value       int
	Left, Right *Node
}

func (node Node) Print() {
	fmt.Print(node.Value, "")
}
func CreateNode(value int) *Node {
	//go可以返回局部变量给外面用，c++不行哦
	return &Node{Value: value}
}
func (node *Node) Traverse() {
	if node == nil {
		return
	}
	//c++需要判断nil 但是go不用
	node.Left.Traverse()
	//这里如果是print(node) 就不是期望的结果，想想为什么
	node.Print()
	node.Right.Traverse()
}
func (node *Node) SetValue(value int) {
	node.Value = value
}

//1.别名
//queue 内部用slice实现
//type Queue []int 只支持int类型，试试类似泛型的写法
//这样就支持任何类型了
//加限定方法
type Queue []interface {
}

//func (q *Queue) Push(v interface{}) {
func (q *Queue) Push(v int) {
	//传入指针是为了改变值
	*q = append(*q, v)
}
func (q *Queue) Pop() int {
	head := (*q)[0]
	*q = (*q)[1:]
	return head.(int) //强制转换成int
}
func (q *Queue) IsEmpty() bool {
	return len(*q) == 0
}
