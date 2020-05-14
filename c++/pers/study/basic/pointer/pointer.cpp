//
// Created by rookie on 2020/3/25.
//


#include <iostream>
using namespace std;
int pointer(){
    /**数组与指针*/
    //一个简单数组
    int a[] = {1,2,3,4};
    for (int sum = a[0], i = 0; i < 4; ++i) {
        sum += a[i];
    }
    /**我们用指针试试*/
    for (int sum = *a,*p = a+1; p < a+4; ++p) {
        sum += *p;
        
    }
    /**或者*/
    for (int sum = *a, i = 1; i < 4; ++i) {
        sum += *(a+i);
        
    }
    cout << "pointer" <<endl;
    return 0;
}