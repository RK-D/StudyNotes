//
// Created by rookie on 2020/3/23.
//

#include "SinglyLinkedList.h"
#include <iostream>
/**单链表，此处实现只支持int 类型 ，后续会使用template 模板函数（java 泛型）来代替 int 这样可以支持更多的类型的参数传递*/

/**析构函数，释放空间，切记*/
IntSLList :: ~IntSLList() {
    for (IntSLLNode *p ; !isEmpty(); ){
        p = head -> next;
        delete head;
        head = p;
    }
}
void IntSLList :: addToHead(int el) {
    head = new IntSLLNode( el , head);
    if (tail == nullptr)
        tail = head;
}
void IntSLList :: addToTail(int el) {
    if (tail != nullptr){
        tail->next = new IntSLLNode(el);
        tail = tail->next;
    }
    else {
        head = tail = new IntSLLNode(el);
    }
}
 
/**删除头节点：
 *  1.判断链表 空？
 *  2.定义一个IntSLLNode的指针名叫tmp，为其/赋值头结点
 * */
int* IntSLList::deleteFromHead(){
    if (! isEmpty()){
        int* el =new int(head->val) ; //定义el 为指针 el所指对象存在 堆中，el这个变量名在？ 里
        IntSLLNode *tmp = head;
        if (head == tail)
            head = tail = nullptr;
        else head = head->next;
        delete tmp;
        return el;
    }
//    else return 0;        //这不是整数，而是指向整数0 的指针，即空指针！y因为旧标准没nullptr
    else return nullptr;
}

int IntSLList::deleteFromTail() {
    int el = tail->val;
    if (head == tail) {   // if only one node on the list;
        delete head;
        head = tail = nullptr;
    }
    else {                       // if more than one node in the list,
        IntSLLNode *tmp;            // find the predecessor of tail;
        for (tmp = head; tmp->next != tail; tmp = tmp->next);
        delete tail;
        tail = tmp;             // the predecessor of tail becomes tail;
        tail->next = nullptr;
    }
    return el;
}
void IntSLList::deleteNode(int el) {
    if (head != nullptr)                              // if non-empty list;
        if (head == tail && el == head->val) {  // if only one
            delete head;                        // node on the list;
            head = tail = nullptr;
        }
        else if (el == head->val) {    // if more than one node on the list
            IntSLLNode *tmp = head;
            head = head->next;
            delete tmp;                     // and old head is deleted;
        }
        else {                           // if more than one node in the list
            IntSLLNode *pred, *tmp;
            for (pred = head, tmp = head->next; // and a non-head node
                 tmp != nullptr && tmp->val != el;// is deleted;
                 pred = pred->next, tmp = tmp->next);
            if (tmp != nullptr) {
                pred->next = tmp->next;
                if (tmp == tail)
                    tail = pred;
                delete tmp;
            }
        }
}
bool IntSLList::isInlist(int el) const {
    IntSLLNode *tmp;
    for (tmp = head; tmp != nullptr && tmp->val != el; tmp = tmp->next);
    return tmp != nullptr;
}