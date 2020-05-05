//
// Created by rookie on 2020/3/25.
//

#include "module.h"
#include <iostream>
test1 object1("object1",100,200),object2("object2"),object3;

template <typename T>
void test2<T> :: swap(T &e1,T &e2){
    T tmp = e1;
    e1 = e2;
    e2 = tmp;
}