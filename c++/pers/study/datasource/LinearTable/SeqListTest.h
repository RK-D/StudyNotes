//
// Created by rookie on 2020/5/18.
//

#ifndef STUDY_SEQLISTTEST_H
#define STUDY_SEQLISTTEST_H


const int MaxSize = 100;

namespace array{
    //模板函数，类似java泛型，就是为了不写死数组元素类型
    template <class DataType>
    class SeqListTest
    {
    public:
        SeqListTest(){ length=0;}            //无参数构造方法
        SeqListTest(DataType a[], int n);    //有参数构造方法
        ~SeqListTest();                         //析构函数
        int getSize(){return length;}           //线性表长度
        DataType contain(int i);             //按位查找
        int containKey(DataType x);          //按值查找
        void add(int i, DataType x);         //插入
        DataType Delete(int i);              //删除
        void Print();                        //遍历
    private:
        DataType data[MaxSize];              //顺序表使用数组实现
        int length;                          //存储顺序表的长度
    };
}




#endif //STUDY_SEQLISTTEST_H
