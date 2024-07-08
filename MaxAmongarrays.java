import java.util.*;

public class MaxAmongarrays {
    public static void cal(int arr[], int k) {
        int max = Integer.MIN_VALUE;
        List<Integer> ll = new ArrayList<>();
        int i = 0;
        int j = 0;
        int arr1[] = new int[arr.length - k + 1];

        while (j < arr.length) {
            if (arr[j] > max) {
                max = arr[j];
                ll.add(max);
            }

            if (j - i + 1 == k) {
                arr1[i] = max;
                if (i > 0) {
                    max = Integer.MIN_VALUE;
                    for (int w = i; w < j + 1; w++) {
                        if (arr[w] > max) {
                            max = arr[w];
                        }
                    }
                }
                i++;
                j++;
            } else {
                j++;
            }
        }

        for (int w = 0; w < arr1.length; w++) {
            System.out.print(arr1[w] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 45, 5};
        int k = 3;
        cal(arr, k);
    }
}