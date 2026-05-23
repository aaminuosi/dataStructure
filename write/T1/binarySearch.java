package T1;

public class binarySearch {
    static void main(String[] args) {
        int arr[] = {1, 4, 5, 6, 9, 55, 333, 434, 564, 578};
        int traget = 1;
        int get = binarySearch(arr, traget);
        System.out.println(get);
    }

    //1.左闭右开的区间，left指向的可能是目标，而right指向的不是目标
    //2.不在循环内找出，等范围内只剩left时，退出循环，在循环外比较arr[left]与target
    //3.循环内的平均比较次数减少了
    //4.时间复杂度Θ(log(n))
    public static int binarySearch(int arr[], int target) {
        //左闭右开
        int left = 0, right = arr.length;
        while (1 < right - left) {
            int m = (right - left) >> 1;
            if (target < arr[m]) {
                right = m;
            } else {
                left = m;
            }
        }
        if (arr[left] == target)
            return left;
        return -1;
    }
}
