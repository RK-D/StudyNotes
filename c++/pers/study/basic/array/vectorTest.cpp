//
// Created by rookie on 2020/5/16.
//

#include "vectorTest.h"
#include <iostream>
#include <vector>
#include <map>
using namespace std;
template <typename  T>
int vectorTest(){
    vector<int> vec = {1,2,3,4};
    map<T,T> mp;
    //目前的vec大小
    cout << "vec size :" << vec.size() << endl;
    //vec真正的容量
    cout << "vec capacity :" << vec.capacity() << endl;
    //添加一个100 （尾部）
    vec.push_back(10);
    //向中间插入
    vec.insert(--vec.end(),20);
    //这儿用迭代器，其实vector可以用[] 访问数组元素
    for (int i : vec) {
        cout << i <<endl;
    }
    
    return 0;
}