//
// Created by rookie on 2020/3/25.
//

#include "currentLinkedList.h"
template <typename T>

/**const 明解 :
 * const类型定义：指明变量或对象的值是不能被更新,引入目的是为了取代预编译指令
 * (1）修饰一般常量,常数组，常对象　　修饰符const可以用在类型说明符前，也可以用在类型说明符后。 例如：int const x=2;　　或　　const int x=2;　　
 * int const a[5]={1, 2, 3, 4, 5}; 或 const int a[5]={1, 2, 3, 4, 5};class A;　 const A a; 或 A const a;　
 * （2）修饰指针const int *A; 或 int const *A; //const修饰指向的对象，A可变，A指向的对象不可变int *const A; 　
 * //const修饰指针A， A不可变，A指向的对象可变const int *const A;
 * //指针A和A指向的对象都不可变
 * （3）修饰引用　　 const double & v; 该引用所引用的对象不能被更新　
 * （4）修饰函数的返回值：const修饰符也可以修饰函数的返回值，是返回值不可被改变，格式如下：const int Fun1();const MyClass Fun2();
 * （5）修饰类的成员函数：const修饰符也可以修饰类的成员函数，格式如下：class ClassName{public:　 　int Fun() const;}；这样，在调用函数Fun时就不能修改类里面的数据
 * （6）在另一连接文件中引用const常量extern const int i;
 * //正确的引用extern const int j=10;
 * //错误！常量不可以被再次赋值
 *
 *   !!!!!!
 * 1. const int k = 5; 表示k是个值为5的常量，而且在程序的运行过程中是不能更改的
 * 2.void fun(const int k) 这个函数的定义表示为这个函数在运行时，k值不能修改
 * 3.如果上面fun函数是一个类里面的成员函数，那么 void fun() const 就表示这个函数在运行过程中不能修改类中的数据项(属性).
 *
 *int func() const 和 const int func() 区别
 * 前者修饰该函数为 cosnt(即函数里不能修改数据),后者修饰函数返回值为const.
 * int func() const 只能是类成员函数，加上const表示他没有修改类对象数据，函数内部不能修改类成员变量，不能调用同样没有const修饰的类成员函数
 * const int func() 表示返回类型为const int
 * @tparam T */
void CLList<T> :: addToDLLHead(const T& el) {
    if (head != 0) {
        head = new CLLNode<T>(el,head,0);
        head->next->prev = head;
    }
    else head = tail = new CLLNode<T>(el);
}

/**双向循环链表*/
template <typename T>
void CLList<T> :: addToDLLTail(const T& el) {
    if (isEmpty()){
        tail = new CLLNode<T>(el);
        tail -> next = tail;
    } else{
        tail -> next = new CLLNode<T>(el,tail -> next);
        tail = tail -> next;
    }
    
}
template <typename T>
T CLList<T> :: deleteFromDLLTail() {
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
T CLList<T>::deleteFromDLLHead() {
    T el = head->info;
    if (head == tail) { //如果列表中只有一个CLLNode；
        delete head;
        head = tail = 0;
    }
    else {              //如果列表中有多个CLLNode；
        head = head->next;
        delete head->prev;
        head->prev = 0;
    }
    return el;
}

template <typename T>
T* CLList<T> :: find(const T& el) const {
    CLLNode<T> *tmp = head;
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
T& CLList<T> :: firstEl() {
    return head->info;
}

template<typename T>
void CLList<T> :: clear() {
    for (CLLNode<T> *tmp; head != 0; ) {
        tmp = head;
        head = head->next;
        delete tmp;
    }
}