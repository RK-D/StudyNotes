//
// Created by rookie on 2020/5/19.
//
#include <iostream>
#include <algorithm>
#include "SelectionSort.h"
#include "help.h"
using namespace helper;
using namespace std;

//原很局限
//void selectionSort(int arr[], int n){
//    for (int i = 0; i < n; ++i) {
//        //x寻找[i,n)区间最小值
//        int min = i;
//        for (int j = i + 1; j < n; ++j) {
//            if (arr[j] < arr [min]){
//                min = j;
//            }
//        }
//        swap(arr[i] ,arr[min]);
//
//    }
//}

//改成模板类型，支持多种类型
template <typename T>
void selectionSort(T arr[], int n){
    for (int i = 0; i < n; ++i) {
        //x寻找[i,n)区间最小值
        int min = i;
        for (int j = i + 1; j < n; ++j) {
            if (arr[j] < arr [min]){
                min = j;
            }
        }
        swap(arr[i] ,arr[min]);
        
    }
}
int test(){
   int n = 10000;
   int *arr = helper::randomArray(n,0,n);
    selectionSort(arr,4);
    for (int i = 0; i < 4; ++i) {
        cout <<arr[i] <<endl;
    }
    return 0;
}