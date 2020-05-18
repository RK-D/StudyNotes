//
// Created by rookie on 2020/5/18.
//

#include "SeqListTest.h"
#include <iostream>
//顺序存储，就是数组
/**一般使用数组实现，事实上就是在内存中找个初始地址，
 * 然后通过占位的形式，把一定连续的内存空间给占了，
 * 然后把相同数据类型的数据元素依次放在这块空地中，
 * 数组大小有两种方式指定，一是静态分配，二是动态扩展
 *
 * 优点：随机访问特性，查找O(1)时间，存储密度高；
 * 逻辑上相邻的元素，物理上也相邻；
 * 无须为表中元素之间的逻辑关系而增加额外的存储空间；
 *
 * 缺点：插入和删除需移动大量元素；
 * 当线性表长度变化较大时，难以确定存储空间的容量；
 * 造成存储空间的“碎片”
 * */
//存储空间的起始位置。数组data的存储位置就是线性表存储空间的存储位置
//线性表的最大存储容量。数组长度MAXSIZE
//线性表的当前长度。getSize


using namespace std;
using namespace array;

    template<class DataType>
    SeqListTest<DataType>::SeqListTest(DataType *a, int n) {
        if(n>MaxSize) throw  "wrong parameter";
        for(int i=0;i<n;i++)
            data[i]=a[i];
        length=n;
    }
    
    
    template<class DataType>
    DataType SeqListTest<DataType>::contain(int i)
    {
        if(i<1 && i>length) throw "wrong Location";
        else return data[i-1];
    }
    
    template<class DataType>
    int SeqListTest<DataType>::containKey(DataType x)
    {
        for(int i=0;i<length;i++)
            if(data[i]==x) return i+1;
        return 0;
    }
    
    template<class DataType>
    void SeqListTest<DataType>::add(int i, DataType x)
    {
        if(length>=MaxSize) throw "Overflow";
        if(i<1 || i>length+1) throw "Location";
        for(int j=length;j>=i;j--)
            data[j]=data[j-1];
        data[i-1]=x;
        length++;
    }
    
    template<class DataType>
    DataType SeqListTest<DataType>::Delete(int i)
    {
        int x;
        if(length==0) throw "Underflow";
        if(i<1 || i>length) throw "Location";
        x = data[i-1];
        for(int j=i;j<length;j++)
            data[j-1] = data[j];
        length--;
        return x;
    }
    
    template<class DataType>
    void SeqListTest<DataType>::Print()
    {
        for(int i=0;i<length;i++)
            cout<<data[i]<<endl;
    }


int Test(){
    
    
    
    return 0;
}

