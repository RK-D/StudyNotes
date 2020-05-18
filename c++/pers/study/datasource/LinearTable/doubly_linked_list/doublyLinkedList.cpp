//
// Created by rookie on 2020/3/23.
//

#include "doublyLinkedList.h"
#include <iostream>

/**
 * 单向链表在 deleteFromDLLTail()有一个问题，结点只包含指向下一个结点的指针，
 * 因此如要执行deleteFromDLLTail(),必定要扫描整个链表（太麻烦了，费时间，费空间）
 * 所以我们规定 : 双向链表 -> 每个结点都有两个指针，prev（前驱），next（后继）。
 * 那我们的代码也要对相应的进性改变
 * */
template <typename T>
void doublyLinkedList<T> :: addToDLLHead(const T& el) {
    if (head != 0) {
        head = new DLLNode<T>(el,head,0);
        head->next->prev = head;
    }
    else head = tail = new DLLNode<T>(el);
}

template <typename T>
void doublyLinkedList<T> :: addToDLLTail(const T& el) {
    if (tail != 0){
        tail = new DLLNode<T>(el,0,tail);
        tail->prev->next = tail;
    } else head = tail = new DLLNode<T>(el);
}
template <typename T>
T doublyLinkedList<T> :: deleteFromDLLTail() {
    T el = tail->info;
    if (head == tail){
        delete  head;
        head = tail = 0;
    } else{
        tail = tail->next;
        delete tail->next;
        tail->next = 0;
    }
    return el;
}
template<typename T>
T doublyLinkedList<T>::deleteFromDLLHead() {
    T el = head->info;
    if (head == tail) { //如果列表中只有一个DLLNode；
        delete head;
        head = tail = 0;
    }
    else {              //如果列表中有多个DLLNode；
        head = head->next;
        delete head->prev;
        head->prev = 0;
    }
    return el;
}

template <typename T>
T* doublyLinkedList<T> :: find(const T& el) const {
    DLLNode<T> *tmp = head;
    for ( ; tmp != 0 && !(tmp->info == el);  //overloaded
    /**重载:
     重载-允许我们使用相同的函数名但是后面的参数一定是不同的，
     如果两个函数名相同而且后面传递的参数相同那么二者不能重载，会提示已经重定义了
    */
            tmp = tmp->next);
    if (tmp == 0)
        return 0;
    else return &tmp->info;
}

template<typename T>
T& doublyLinkedList<T> :: firstEl() {
    return head->info;
}

template<typename T>
void doublyLinkedList<T> :: clear() {
    for (DLLNode<T> *tmp; head != 0; ) {
        tmp = head;
        head = head->next;
        delete tmp;
    }
}