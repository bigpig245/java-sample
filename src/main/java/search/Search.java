package search;

public class Search {

  public static void main(String[] args) {
    int arr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
    int x = 55;

    System.out.println("Perform linear search:");
    System.out.println(String.format("Find x = %d at %d", x, linearSearch(arr, x)));

    System.out.println("Perform binary search:");
    System.out.println(String.format("Find x = %d at %d", x, binarySearch(arr, x)));

    System.out.println("Perform jump search:");
    System.out.println(String.format("Find x = %d at %d", x, jumpSearch(arr, x)));

    System.out.println("Perform interpolation search:");
    System.out.println(String.format("Find x = %d at %d", x, interpolationSearch(arr, x)));

    System.out.println("Perform exponential search:");
    System.out.println(String.format("Find x = %d at %d", x, exponentialSearch(arr, x)));

    System.out.println("Perform fibonacci search:");
    System.out.println(String.format("Find x = %d at %d", x, fibonacciSearch(arr, x)));

  }

  /**
   * A simple approach is to do linear search, i.e
   * <p>
   * Start from the leftmost element of arr[] and one by one compare x with each element of arr[]
   * If x matches with an element, return the index.
   * If x doesn’t match with any of elements, return -1.
   */
  public static int linearSearch(int arr[], int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        return i;
      }
    }
    return -1;
  }

  /**
   * We basically ignore half of the elements just after one comparison.
   * <p>
   * Compare x with the middle element.
   * If x matches with middle element, we return the mid index.
   * Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element. So we
   * recur for right half.
   * Else (x is smaller) recur for the left half.
   */
  public static int binarySearch(int arr[], int x) {
    return binarySearch(arr, x, 0, arr.length - 1);
  }

  public static int binarySearch(int arr[], int x, int l, int r) {
    if (l <= r) {
      int mid = (l + r) / 2;
      if (arr[mid] == x) {
        return mid;
      }

      // if middle value > x, starting search from left to mid
      if (arr[mid] > x) {
        return binarySearch(arr, x, l, mid - 1);
      } else {
        return binarySearch(arr, x, mid + 1, r);
      }
    }
    return -1;
  }

  /**
   * Like Binary Search, Jump Search is a searching algorithm for sorted arrays. The basic idea is to check fewer
   * elements (than linear search) by jumping ahead by fixed steps or skipping some elements in place of searching all
   * elements.
   * <p>
   * For example, suppose we have an array arr[] of size n and block (to be jumped) size m. Then we search at the
   * indexes arr[0], arr[m], arr[2m]…..arr[km] and so on. Once we find the interval (arr[km] < x < arr[(k+1)m]), we
   * perform a linear search operation from the index km to find the element x.
   */
  public static int jumpSearch(int arr[], int x) {
    int n = arr.length;
    int step = (int) Math.floor(Math.sqrt(n));
    // Finding block size to be jumped
    int prev = 0;
    while (arr[Math.min(step, n) - 1] < x) {
      prev = step;
      step += step;
      if (prev >= n) {
        return -1;
      }
    }

    // linear search in current block
    // find util the value in current array with x index is reached
    int endOfBlock = Math.min(step, n);
    while (arr[prev] < x) {
      prev++;
      if (prev == endOfBlock) {
        return -1;
      }
    }

    if (arr[prev] == x) {
      return prev;
    }
    return -1;
  }

  /**
   * Algorithm
   * Rest of the Interpolation algorithm is the same except the above partition logic.
   * <p>
   * Step1: In a loop, calculate the value of “pos” using the probe position formula.
   * Step2: If it is a match, return the index of the item, and exit.
   * Step3: If the item is less than arr[pos], calculate the probe position of the left sub-array. Otherwise calculate
   * the same in the right sub-array.
   * Step4: Repeat until a match is found or the sub-array reduces to zero.
   * <p>
   * // The idea of formula is to return higher value of pos
   * // when element to be searched is closer to arr[hi]. And
   * // smaller value when closer to arr[lo]
   * pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
   * <p>
   * arr[] ==> Array where elements need to be searched
   * x     ==> Element to be searched
   * lo    ==> Starting index in arr[]
   * hi    ==> Ending index in arr[]
   */
  public static int interpolationSearch(int arr[], int x) {
    int lo = 0;
    int hi = arr.length - 1;
    while (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
      if (lo == hi) {
        if (arr[lo] == x) {
          return lo;
        }
        return -1;
      }

      // Probing the position with keeping
      // uniform distribution in mind.
      int probe = (hi - lo) / (arr[hi] - arr[lo]);
      int pos = lo + (probe * (x - arr[lo]));
      if (arr[pos] == x) {
        return pos;
      }

      if (arr[pos] < x) {
        lo = pos + 1;
      } else {
        hi = pos - 1;
      }
    }
    return -1;
  }

  /**
   * Exponential search involves two steps:
   * <p>
   * Find range where element is present
   * Do Binary Search in above found range.
   * How to find the range where element may be present?
   * The idea is to start with subarray size 1, compare its last element with x, then try size 2, then 4 and so on
   * until last element of a subarray is not greater.
   * Once we find an index i (after repeated doubling of i), we know that the element must be present between i/2 and
   * i (Why i/2? because we could not find a greater value in previous iteration)
   */
  public static int exponentialSearch(int arr[], int x) {
    if (arr[0] == x) {
      return 0;
    }

    int i = 1;
    int n = arr.length;
    while (i < n && arr[i] <= x) {
      i = i * 2;
    }

    return binarySearch(arr, x, i / 2, Math.min(i, n));
  }

  /**
   * Similarities with Binary Search:
   * <p>
   * Works for sorted arrays
   * A Divide and Conquer Algorithm.
   * Has Log n time complexity.
   * Differences with Binary Search:
   * <p>
   * Fibonacci Search divides given array in unequal parts
   * Binary Search uses division operator to divide range. Fibonacci Search doesn’t use /, but uses + and -. The
   * division operator may be costly on some CPUs.
   * Fibonacci Search examines relatively closer elements in subsequent steps. So when input array is big that cannot
   * fit in CPU cache or even in RAM, Fibonacci Search can be useful.
   * <p>
   * Algorithm:
   * Let the searched element be x.
   * <p>
   * The idea is to first find the smallest Fibonacci number that is greater than or equal to the length of given
   * array. Let the found Fibonacci number be fib (m’th Fibonacci number). We use (m-2)’th Fibonacci number as the
   * index (If it is a valid index). Let (m-2)’th Fibonacci Number be i, we compare arr[i] with x, if x is same, we
   * return i. Else if x is greater, we recur for subarray after i, else we recur for subarray before i.
   * <p>
   * Below is the complete algorithm
   * Let arr[0..n-1] be the input array and element to be searched be x.
   * <p>
   * Find the smallest Fibonacci Number greater than or equal to n. Let this number be fibM [m’th Fibonacci Number].
   * Let the two Fibonacci numbers preceding it be fibMm1 [(m-1)’th Fibonacci Number] and fibMm2 [(m-2)’th Fibonacci
   * Number].
   * While the array has elements to be inspected:
   * Compare x with the last element of the range covered by fibMm2
   * If x matches, return index
   * Else If x is less than the element, move the three Fibonacci variables two Fibonacci down, indicating
   * elimination of approximately rear two-third of the remaining array.
   * Else x is greater than the element, move the three Fibonacci variables one Fibonacci down. Reset offset to index
   * . Together these indicate elimination of approximately front one-third of the remaining array.
   * Since there might be a single element remaining for comparison, check if fibMm1 is 1. If Yes, compare x with
   * that remaining element. If match, return index.
   */
  public static int fibonacciSearch(int arr[], int x) {

    int n = arr.length;
    int fibMMm2 = 0; // (m-2)'th Fibonacci No.
    int fibMMm1 = 1; // (m-1)'th Fibonacci No.
    int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci

    while (fibM < n) {
      fibMMm2 = fibMMm1;
      fibMMm1 = fibM;
      fibM = fibMMm2 + fibMMm1;
    }

    // Marks the eliminated range from front
    int offset = -1;

    //while there are elements to be inspected.
    //Note that we compare arr[fibMm2] with x.
    //When fibM becomes 1, fibMm2 becomes 0
    while (fibM > 1) {
      // Check if fibMm2 is a valid location
      int i = Math.min(offset + fibMMm2, n - 1);
      //If x is greater than the value at
      //index fibMm2, cut the subarray array
      //from offset to i
      if (arr[i] < x) {
        fibM = fibMMm1;
        fibMMm1 = fibMMm2;
        fibMMm2 = fibM - fibMMm1;
        offset = i;
      } else if (arr[i] > x) {
        // If x is greater than the value at index
        // fibMm2, cut the subarray after i+1
        fibM = fibMMm2;
        fibMMm1 = fibMMm1 - fibMMm2;
        fibMMm2 = fibM - fibMMm1;
      } else {
        //element found. return index
        return i;
      }
    }

    //comparing the last element with x
    if (fibMMm1 == 1 && arr[offset + 1] == x) {
      return offset + 1;
    }

    //element not found. return -1
    return -1;
  }
}
