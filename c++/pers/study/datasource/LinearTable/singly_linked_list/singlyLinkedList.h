//
// Created by rookie on 2020/3/23.
//

#ifndef LINKEDLIST_INTSLLIST_H

/**单向链表结点*/
class IntSLLNode{
public:
    IntSLLNode(){
        next = nullptr;
    }
    
    int val ;
    IntSLLNode *next;
    explicit IntSLLNode(int x, IntSLLNode *ptr = nullptr){
        val = x;
        next = ptr;
    }
    
};

/**
 * 声明为 public 便于外界访问
 * @param head 头结点
 * @param tail 尾结点
 * */
class IntSLList {
private:
    IntSLLNode *head, *tail;
    
public:
    IntSLList(){
        //head 头 tail尾
        head = tail = nullptr;
        
    }
    //析构函数释放空间
    ~IntSLList();
    //判断链表是否为空
    int isEmpty(){
        return head == nullptr;
    }
    //向头结点添加元素
    void addToHead(int);
    //向尾结点添加元素
    void addToTail(int);
    //删除头结点
    int* deleteFromHead();
    //删除尾节点
    int deleteFromTail();
    //删除执行节点
    void deleteNode(int);
    //查询是否存在节点中
    bool isInlist(int) const ;


};

#endif //LINKEDLIST_INTSLLIST_H
