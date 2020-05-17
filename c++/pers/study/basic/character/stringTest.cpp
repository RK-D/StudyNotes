//
// Created by rookie on 2020/5/16.
//
#include <iostream>
#include <string.h>
//#include <string>
using namespace std;
/**
 * 1.字符长度 strlen(s);
 * 2.字符串比较strcmp(s1,s2); s1<s2 ---> return <0  s1 = s2  ---> return 0
 * 3.字符拷贝 strcpy(s1,s2) 把s2拷贝给s1
 * 4复制指定字符长度字符串strncpy(s1,s2,n) 将s2前n个字符拷贝到s1中
 * 5.字符串拼接strcat(s1,s2)  s2接到s1后面
 * 6.查找字符串 strchr(s1,s2) s1中字符ch第一次出现的位置
 * 7.查找字符串 strstr(s1,s2) s1中s2第一次出现的位置
 *
 * ******以上是部分原生api 不安全！ 有的不要直接用在实际开发
 * safe api 可以解决想缓冲区溢出等问题
 * strlen 空间换时间-v
* strcpy_s() safe api character 所有的挨批加上 _s  即可
* * */
 
// ps :直接sizeof（） 求出的往往不是所要的字符串长度
// 用strlen 或者 sizeof(s)/sizeof(s[0]) 求len
int stringTest(){
        string  str;
        char  a[] = {"hello"};
        char  b[] = {"world"};
        char *c = {"error"};
        strcpy(b,a);
        strcpy_s(b,a);
        //指针的c可以作为右值
        strcpy(b,c);
        strcpy_s(b,c);
        strcpy(c,a);
        //error c 不能作为左值，此处c被默认为const 不加const也一样，就是不能改变
//        除非改变指针本身
//        strcpy_s(c,a);
        return 0;
}