//
// Created by rookie on 2020/5/19.
//

#ifndef STUDY_SELECTIONSORT_H
#define STUDY_SELECTIONSORT_H

#include <iostream>
#include <string>

struct  Stu{
    std::string name;
    int score;
    bool operator < (const Stu &otherStu){
        return score < otherStu.score;
    }
    friend std::ostream &operator << (std::ostream &os, const Stu & stu){
        os << "stu: " << stu.name << " " << stu.score << std::endl;
        return os;
    }
};
int test();

#endif //STUDY_SELECTIONSORT_H
