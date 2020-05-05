//
// Created by rookie on 2020/3/25.
//

#ifndef OOP_TEST1_H
#define OOP_TEST1_H


#include <iostream>
#include <cstring>

class test1{
public:
    test1(char *s = " ",int i = 0, double d = 1){
        strcpy(dataMember1,s);
        dataMember2 = i;
        dataMember3 = d;
    }
    void fun1(){
        std :: cout << dataMember1 << ' ' << dataMember2 << ' '
                    << dataMember3 << std::endl;
    }
    void fun2(int i, char *s = "unknown"){
        dataMember2 = i;
        std::cout << i << "received form" << s << std::endl;
    }

protected:
    char dataMember1[20];
    int  dataMember2;
    double dataMember3;
};

/**声明通用类,用模板函数解决不同类型传值问题*/
template <typename T>
class test2{
public:
    test2();
    void swap(T &e1,T &e2);
protected:

};
#endif //OOP_TEST1_H
