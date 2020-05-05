//
// Created by rookie on 2020/3/25.
//

#ifndef OOP_DERIVED_H
#define OOP_DERIVED_H

#include <iostream>

class base {
public:
    base(){}
    void fun1(char *s = "unknown"){
        std::cout << "函数 fun1() " << s << std::endl;
        fun3();
    }

protected:
    void fun2(char *s = "unknown"){
        std::cout << "函数 fun2() " << s << std::endl;
    }
private:
    void fun3(){
        std:: cout << "函数 fun3() "  << std:: endl;
    }
};
/**OOL 允许建立层次关系，允许继承 derived（派生，继承）*/
class derived1lv1 : public virtual base{
public:
    void fun1(char *s = "unknown"){
        std::cout << "函数 fun1() " << s << std::endl;
        fun2("derived1lv1");
        fun3("derived1lv1");   //ERROR:因为private 私有不允许继承
    }
    void fun3(char *s = "unknown"){
        std:: cout << "函数 fun3() "<< s << std::endl;
    }
};

#endif //OOP_DERIVED_H
