package search;

public class Sort {
  public static void main(String[] args) {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    selectionSort(arr);
    printArray("Perform selection sort", arr);

    int arr1[] = {64, 34, 25, 12, 22, 11, 90};
    bubbleSort(arr1);
    printArray("Perform bubble sort", arr1);

    int arr2[] = {64, 34, 25, 12, 22, 11, 90};
    pancakeSort(arr2);
    printArray("Perform pancake sort", arr2);

    int arr3[] = {64, 34, 25, 12, 22, 11, 90};
    insertionSort(arr3);
    printArray("Perform insertion sort", arr3);

  }

  public static void swap(int arr[], int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void printArray(String message, int arr[]) {
    System.out.print(message + "\n");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void selectionSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      swap(arr, min, i);
    }
  }

  /**
   * https://www.geeksforgeeks.org/bubble-sort/
   */
  public static void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  /**
   * MergeSort(arr[], l,  r)
   * If r > l
   * 1. Find the middle point to divide the array into two halves:
   * middle m = (l+r)/2
   * 2. Call mergeSort for first half:
   * Call mergeSort(arr, l, m)
   * 3. Call mergeSort for second half:
   * Call mergeSort(arr, m+1, r)
   * 4. Merge the two halves sorted in step 2 and 3:
   * Call merge(arr, l, m, r)
   */
  public static void merge(int arr[], int l, int r) {
    int m = (l + r) / 2;
    int n1 = m - l + 1;
    int n2 = r - m;

    int aL[] = new int[n1];
    int aR[] = new int[n2];
    for (int i = 0; i < n1; i++) {
      aL[i] = arr[l + i];
    }
    for (int i = 0; i < n2; i++) {
      aR[i] = arr[m + i + 1];
    }

    int i = 0, j = 0;
  }

  public static void insertionSort(int arr[]) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      int key = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static int findMax(int arr[], int n) {
    int max = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > arr[max]) {
        max = i;
      }
    }
    return max;
  }

  public static void flip(int arr[], int pos) {
    int i = 0;
    while (i < pos) {
      swap(arr, pos, i);
      i++;
      pos--;
    }
  }

  public static void pancakeSort(int arr[]) {
    int n = arr.length;
    // loop from the end of array
    for (int i = n - 1; i > 1; i--) {
      // find index of max item
      int pos = findMax(arr, i);

      // if current item is biggest, ignore
      // else flip
      if (pos != i - 1) {
        // flip current array to force max value to the first item
        flip(arr, pos);
        // flip again to current position to put the max value to the right position
        flip(arr, i - 1);
      }
    }
  }

}
