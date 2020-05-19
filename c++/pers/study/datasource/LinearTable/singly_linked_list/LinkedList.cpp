//
// Created by rookie on 2020/5/18.
//

#include <iostream>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    explicit ListNode(int x) : val(x), next(nullptr){}
};

ListNode *createLinkedList(int arr[], int n){
    if (n == 0){
        return nullptr;
    }
    ListNode *head = new ListNode(arr[0]);
    ListNode * curNode = head;
    for (int i = 0; i < n; ++i) {
        curNode->next = new ListNode(arr[i]);
        curNode = curNode->next;
    }
    return head;
};

void print(ListNode *head){
    if (head == nullptr){
        cout << "null" << endl;
        return;
    }
    
    ListNode *curNode = head;
    while (curNode != nullptr){
        cout << curNode->val;
        if(curNode->next != nullptr)
            cout << " -> ";
        curNode = curNode->next;
    }
    cout << endl;
    
    return;
}

void deleteLinkedList(ListNode* head){
    
    ListNode* curNode = head;
    while(curNode != nullptr){
        ListNode* delNode = curNode;
        curNode = curNode->next;
        delete delNode;
    }
    
    return;
}