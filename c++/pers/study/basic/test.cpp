#include <iostream>

using namespace std;
int test() {
//    test1 object1("object1",100,200),object2("object2"),object3;
//    object1.fun1();
//    object2.fun2(123);
//    object3.fun2(123,"k");

//    int i = 0;
//    t.a = 0x514030;
//    cout << &t << endl;
//    for ( i = 0; i < 4; ++i) {
//        cout << hex << &t.b[i] <<'\t' << hex << t.b[i] <<endl;
//    }
   struct a{
       char b;
       double c;
       int a1;
       
   };
    cout << "a:" << sizeof(struct a) << endl;
    
    
    char a[20]=" You_are_a_girl";
    char *p=a;
    char **ptr=&p;
    //printf("p=%d\n",p);
    //printf("ptr=%d\n",ptr);
    //printf("*ptr=%d\n",*ptr);
    printf("**ptr=%c\n",**ptr);
    ptr++;
    //printf("ptr=%d\n",ptr);
    //printf("*ptr=%d\n",*ptr);
    printf("**ptr=%c\n",**ptr);
    return 0;
}
