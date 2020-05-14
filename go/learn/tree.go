package main

import "fmt"

//改变内容用指针接受，不要指针和copy乱用，结构体过大用指针，性能
type treeNode struct {
	value       int
	left, right *treeNode
}

func createNode(value int) *treeNode {
	//go可以返回局部变量给外面用，c++不行哦
	return &treeNode{value: value}
}

// 		------ 为结构体定义方法-------
//func (node  treeNode)  printTree() {
//}
//----> root.printTree() 两种语法
//这是显示定义和命名方法接受者，
func printTree(node treeNode) {
	fmt.Print(node.value)
}

//函数后面是返回值，未定义返回值
// 只有指针才可以改变结构内容，此处定义是没有返回值，也是为了避免不必要的麻烦
//nil指针也可以调用方法
//(node *treeNode) 作为接受者像 root . setValue(传入的参数)   返回值，不写就是类似其他语言的void   -->这下终于明白了

//值接受者是go特有，其他语言很多都是指针接受者（针对常用语言范围）
func (node *treeNode) setValue(value int) {
	node.value = value
}
func (node *treeNode) traverse() {
	if node == nil {
		return
	}
	node.left.traverse()
	//另一种写法见，module/test.go
	//不想写 *node  可以改printTree(node *treeNode)
	printTree(*node)
	node.right.traverse()
}
func main() {
	var root treeNode
	root = treeNode{value: 3}
	root.left = &treeNode{}
	root.right = &treeNode{5, nil, nil}
	//root.right->left ,不像c++那么折磨人  都用. 访问 ，开不开心？
	root.right.left = createNode(2)
	nodes := []treeNode{
		{value: 3},
		{},
		{6, nil, nil},
	}
	fmt.Println(nodes)
	printTree(root)
	root.right.left.setValue(10)
	//遍历
	root.traverse()
}
