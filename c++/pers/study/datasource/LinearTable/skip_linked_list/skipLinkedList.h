//
// Created by rookie on 2020/3/23.
//

#ifndef LINKEDLIST_SKIPLINKEDLIST_H
#define LINKEDLIST_SKIPLINKEDLIST_H
const int maxLevel = 4;
template <typename T>
class SkipListNode{
public:
    SkipListNode(){
    }
    T key;
    SkipListNode **next;
};
template <typename T>
class SkipList{
public:
    SkipList();
    bool isEmpty() const;
    void choosePowers();
    int chooseLevel();
    T* skipListSearch(const T&);
    void skipListInsert(const T&);

private:
    typedef SkipListNode<T> *nodePtr;
    nodePtr root[maxLevel];
    int powers[maxLevel];
};
#endif //LINKEDLIST_SKIPLINKEDLIST_H
