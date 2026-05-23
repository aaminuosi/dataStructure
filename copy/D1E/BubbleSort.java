package D1E;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        bubble(arr, arr.length);
    }

    private static void bubble(int[] arr, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (arr[i] > arr[i + 1]) {
                int t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
                x = i;
            }
        }
        bubble(arr, x);
    }
}
