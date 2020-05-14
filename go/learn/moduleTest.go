package main

import (
	"./module"
	"fmt"
)

// go取消了继承，
//扩展类型方法:  1 定义别名 ， 2 使用组合

//1.别名见 module/test.go

//后序遍历
//2.组合 可以不放指针
type myTreeNode struct {
	//module 是外界引入的包
	node *module.Node
}

//封装写后续遍历
func (myNode *myTreeNode) postOrder() {
	//判断条件写好
	if myNode == nil || myNode.node == nil {
		return
	}
	// 下面指数这句报错: cannot call pointer method on myTreeNode literal(无法在myTreeNode文字上调用指针方法) ，省略的可以自行查看。
	// cannot take the address of myTreeNode literal （无法使用myTreeNode文字的地址） ，需要变量进行传值：（原因）这儿函数调用时指针接受者
	//literal : --> myTreeNode{myNode.node.Left} 这就是一个literal
	//myTreeNode{myNode.node.Left}.postOrder()
	//myTreeNode{myNode.node.Right}.postOrder()
	//myNode.node.Print()
	//修改如下
	left := myTreeNode{myNode.node.Left}
	right := myTreeNode{myNode.node.Right}

	left.postOrder()
	right.postOrder()
	myNode.node.Print()

}

func main() {
	//var tt module.Test() 报错
	module.Test() //直接调用public函数
	var root module.Node
	//Value 也大写哦，不然没发读
	root = module.Node{Value: 3}
	root.Left = &module.Node{}
	//root.Right = &module.Node{Value: 5} 和下面命名等效
	root.Right = &module.Node{5, nil, nil}
	root.Right.Left = new(module.Node)
	root.Left.Right = module.CreateNode(2)
	root.Right.Left.SetValue(4)
	//Traverse()也可以放在其他文件里，module一样就行，嗯好用
	//前序遍历
	root.Traverse()
	fmt.Println()
	//后序遍历
	myRoot := myTreeNode{&root}
	myRoot.postOrder()

	//别名
	q := module.Queue{1}
	//下面和源包里的slice不以言，函数接受者会改变原来的值
	q.Push(3)
	q.Push(1)
	fmt.Println(q.Pop())
	fmt.Println(q.IsEmpty())
	fmt.Println(q.Pop())
	fmt.Println(q.IsEmpty())
}
