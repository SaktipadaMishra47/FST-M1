package Day2;

public class Activity4 {
    public static void main(String[] args) {

        int arr[] = { 23, 3, 5, 2, 1, 6 };

        // Print elements before sorting
        System.out.println("Before Sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 

        for (int i = 0; i < arr.length - 1; i++) { 
            for (int j = 0; j < arr.length - i - 1; j++) { 
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print elements after sorting
        System.out.println("After Sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    }
}
