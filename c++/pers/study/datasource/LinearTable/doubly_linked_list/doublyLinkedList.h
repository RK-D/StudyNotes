//
// Created by rookie on 2020/3/23.
//

#ifndef LINKEDLIST_DOUBLYLINKEDLIST_H
#define LINKEDLIST_DOUBLYLINKEDLIST_H
#include <ostream>
template <typename T>
class DLLNode {
public:
    DLLNode (){
        next = prev = 0;
    }
    
    explicit DLLNode (const T& el, DLLNode *n = 0,DLLNode *p = 0){
        info = el; next = n; prev = p;
    }
    T info;
    DLLNode<T> *next, *prev;

};

template <typename T>
class doublyLinkedList{
public:
    doublyLinkedList(){
        head = tail = 0;
        
    }
    /**构造函数后就要析构函数，释放内存，防止内存泄露*/
    ~doublyLinkedList() {
        clear();
    }
    void addToDLLTail(const T&);
    void addToDLLHead(const T&);
    T deleteFromDLLTail();
    T deleteFromDLLHead();
    bool isEmpty() const {
        return head == 0;
    }
    void clear();
    void setToNull() {
        head = tail = 0;
    }
    T& firstEl();
    T* find(const T&) const;
    
protected:
    DLLNode<T> *head, *tail;
    friend std::ostream& operator<<(std::ostream& out, const doublyLinkedList<T>& dll) {
        for (DLLNode<T> *tmp = dll.head; tmp != 0; tmp = tmp->next)
            out << tmp->info << ' ';
        return out;
    }
    
};

#endif //LINKEDLIST_DOUBLYLINKEDLIST_H
