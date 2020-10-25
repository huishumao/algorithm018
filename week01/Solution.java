public class Solution {

    //删除排序数组中得重复项
    public int removeDuplicates(int[] nums) {
        int temp = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[temp]==nums[i]) continue;
            temp++;
            nums[temp] = nums[i];
        }
        return temp+1;
    }

 // 旋转数组
public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    public void reverse(int[] nums,int start, int end) {
        while (start<end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

//合并两个有序链表
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (l1!=null&&l2!=null) {
            if (l1.val<l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1==null?l2:l1;
        return dummyHead.next;
    }

//合并两个有序数组
  public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n -1;
        int len = m + n - 1;
        while (len1>=0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2,0,nums1,0,len2+1);
    }

//两数之和
   public int[] twoSum(int[] nums, int target) {
//1.暴力循环法，两层循环 时间复杂度O(n^2)
//2.缓存法 Map
    Map<Integer,Integer> hashMap = new HashMap<>();
    for(int i =0;i<nums.length;i++){
        hashMap.put(nums[i],i);
    }
    for(int i = 0;i<nums.length;i++){
        int temp = target - nums[i];
        if(hashMap.containsKey(temp)&&hashMap.get(temp)!=i){
            return new int[] {i,hashMap.get(target - nums[i])};
        }
    }
     return new int[0];
    }

//移动零
 public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) {
                nums[j] = nums[i];
                if (i!=j) nums[i] = 0;
                j++;
            }
        }
    }

//加一
 public int[] plusOne(int[] digits) {
        int temp = 1;
        for (int i=digits.length -1;i>=0;i--) {
            if (digits[i]==9) {
                digits[i] = 0;
                temp = 1;
            }else {
                digits[i]+=temp;
                temp = 0;
                break;  
            }
        }
        if(temp == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
         return digits;
    }

//设计循环双端队列

看另外一个文件

//接雨水
public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }



}