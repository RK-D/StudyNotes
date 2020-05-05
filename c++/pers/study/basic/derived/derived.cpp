//
// Created by rookie on 2020/3/25.
//

#include "derived.h"
int derived(){
    base be;    //基类/超类
    derived1lv1 d1; //子类，派生类，可以使用base的所有方法，可以重写protected和private方法
    be.fun1("derived(1)");
    
//    be.fun2();    //error:protected
//    be.dun3();    //error:private
    d1.fun1();
//    d1.fun2();    //error:
    d1.fun3();
}