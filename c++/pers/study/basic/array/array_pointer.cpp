//
// Created by rookie on 2020/5/16.
//
#include <iostream>
#include <string>
int array_pointer(){
    //error:Initializer-string for char array is too long
    //缺少一个元素 '\0' 的 空间
//    char a1[5] =  {"hello"};
    char a2[6] = {"hello"};
    char a3[] = {"hello"};
    //指针表示法
    //ISO C++11 does not allow conversion from string literal to 'char *
    //默认成常量，无法修改
    //指针所指不可修改，数组的却可以修改 ，但并非不可能更改，
//    char  * a4 = "hello"; //（源）
    char const * a4 = "hello"; //（推荐）
//    char  * a4 = (char*)"hello";  //（改2）
    return 0;
}
