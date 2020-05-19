//
// Created by rookie on 2020/5/19.
//

#ifndef STUDY_HELP_H
#define STUDY_HELP_H

#include <iostream>
#include <ctime>
#include <cassert>

//C 库宏 void assert(int expression) 允许诊断信息被写入到标准错误文件中。换句话说，它可用于在 C 程序中添加诊断。
namespace helper{
    int * randomArray(int n,int L, int R){
        assert(L <= R);
        int * arr = new int [n];
        srand(time(NULL));
        for (int i = 0; i < n; ++i) {
            arr[i] = rand() % (R - L + 1) + L;
        }
        return arr;
    }
}
#endif //STUDY_HELP_H
