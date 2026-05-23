package D1;

public class binarySearch {
    static void main(String[] args) {
        int arr[] = {1, 4, 5, 6, 9, 55, 333, 434, 564, 578};
        int traget = 4;
        int get = binarySearch(arr, traget);
        System.out.println(get);
    }

    //1.左闭右开的区间，i指向的可能是目标，而j指向的不是目标
    //2.不在循环内找出，等范围内只剩i时，退出循环，在循环外比较ali与target
    //3.循环内的平均比较次数减少了
    //4.时间复杂度Θ(log(n))
    public static int binarySearch(int arr[], int target) {
        int left = 0, right = arr.length;
        while (1 < right - left) {
            int m = (left + right) >>> 1;
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


    public static int search(int[] arr, int target) {
        return f(arr, target, 0, arr.length - 1);
    }

    public static int f(int[] arr, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >> 1;
        if (target < arr[m]) {
            return f(arr, target, i, m - 1);
        } else if (arr[m] < target) {
            return f(arr, target, m + 1, j);
        } else {
            return m;
        }
    }
}
