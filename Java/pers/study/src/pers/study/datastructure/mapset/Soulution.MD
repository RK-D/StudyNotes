#Leetcode 题解
* 原题:
    (349). 两个数组的交集 \
    给定两个数组，编写一个函数来计算它们的交集。
    
    示例 1:
    
    输入: nums1 = [1,2,2,1], nums2 = [2,2]
    输出: [2]
    
    示例 2:
    
    输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    输出: [9,4]
    
    说明:
    
        输出结果中的每个元素一定是唯一的。
        我们可以不考虑输出结果的顺序。
    

``` 
C++:
(1)

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> s1(nums1.begin(),nums1.end()),ans;
        for(auto iter:nums2)
        {
            if(s1.count(iter))
                ans.insert(iter);    
        }   
        return vector<int>(ans.begin(),ans.end());
    }
};

(2)

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        int a = nums1.size(),b = nums2.size();
        vector<int> res;
        if(!a||!b)  return res;
        sort(nums1.begin(),nums1.end());
        sort(nums2.begin(),nums2.end());
        int i = 0,j = 0;
        while(i<a&&j<b)
        {
            while(i<a-1&&nums1[i]==nums1[i+1])
                i++;
            while(j<b-1&&nums2[j]==nums2[j+1])
                j++;
            if(nums1[i]==nums2[j])  
            {
                res.push_back(nums1[i]);
                i++;
                j++;
            }  
            else if(nums1[i]<nums2[j])    i++;
            else j++;
        }
        return res;
    }
};
```
```
Java:
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums1){
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        } 
        return res;
    }
}
```
* 原题:
  (350) 两个数组的交集 II
  给定两个数组，编写一个函数来计算它们的交集。\ 
  
  示例 1:
  
  输入: nums1 = [1,2,2,1], nums2 = [2,2]
  输出: [2,2]
  
  示例 2:
  
  输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
  输出: [4,9]
  
  说明：
  
      输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
      我们可以不考虑输出结果的顺序。
  
  进阶:
  
      如果给定的数组已经排好序呢？你将如何优化你的算法？
      如果 nums1 的大小比 nums2 小很多，哪种方法更优？
      如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？

```


```