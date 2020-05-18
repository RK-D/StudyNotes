//
// Created by rookie on 2020/3/25.
//

#ifndef LINKEDLIST_CURRENTLINKEDLIST_H
#define LINKEDLIST_CURRENTLINKEDLIST_H

#include <ostream>
/**头文件打死别写
 * using namespace std ;
 * 杜绝污染命名空间
 * */
 
template <typename T>
class CLLNode {
public:
    CLLNode(){
        next = 0;
    }
    explicit CLLNode (const T& el, CLLNode *n = 0,CLLNode *p = 0){
        info = el; next = n; prev = p;
    }
    T info;
    CLLNode<T> *next, *prev;
    
};



template <typename T>
class CLList{
public:
    CLList(){
        head = tail = 0;
    }
    ~CLList(){
        clear();
    };
    int isEmpty(){
        return head == 0;
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

private:
    CLLNode<T> *head, *tail;
    friend std::ostream& operator<<(std::ostream& out, const CLList<T>& dll) {
        for (CLLNode<T> *tmp = dll.head; tmp != 0; tmp = tmp->next)
            out << tmp->info << ' ';
        return out;
    }
};


#endif //LINKEDLIST_CURRENTLINKEDLIST_H
