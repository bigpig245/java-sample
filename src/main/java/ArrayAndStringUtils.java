import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayAndStringUtils {

    /**
     * 1.1
     * Implement an algorithm to determine if a string has all unique characters.
     * What if you can not use additional data structures?
     * assume char set is ASCII
     */
    public boolean isUnique(String s) {
        boolean[] charList = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i);
            if (charList[j]) {
                return false;
            } else {
                charList[j] = true;
            }
        }
        return true;
    }

    /**
     * 1.2
     * Write code to reverse a C-Style String.
     * (C-String means that “abcd” is represented as five characters, including the null character.)
     */


    /**
     * 1.3
     * Design an algorithm and write code to remove the duplicate characters in a string
     * without using any additional buffer.
     * NOTE: One or two additional variables are fine.
     * An extra copy of the array is not.
     * FOLLOW UP
     * Write the test cases for this method.
     *
     * @param a
     * @return
     */
    public char[] removeDuplicate(char[] a) {
        if (a.length < 2) {
            return a;
        }
        int tail = a.length;
        for (int i = 0; i < tail; i++) {
            int j = i + 1;
            while (j < tail) {
                // if character in j index is equal to character in i index
                // shift all the remain elements to the left 1 index
                // decrease array size
                // keep current j index (because the current array was changed)
                if (a[j] == a[i]) {
                    for (int k = j; k < tail - 1; k++) {
                        a[k] = a[k + 1];
                    }
                    tail--;
                    a[tail] = ' ';
                } else { // otherwise, increase j index
                    j++;
                }
            }
        }
        return a;
    }

    /**
     * 1.4
     * Write a method to decide if two strings are anagrams or not
     */

    /**
     * 1.5
     * Write a method to replace all spaces in a string with ‘%20’
     */

    /**
     * 1.6
     * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     * write a method to rotate the image by 90 degrees. Can you do this in place?
     */

    /**
     * 1.7
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
     */
    public int[][] refineMatrix(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] columns = new int[matrix[0].length];
        // store column, row index where the element is zero
        for (int i = 0; i < matrix.length; i++) { // iterate the number of rows
            for (int j = 0; j < matrix[i].length; j++) { // iterate the element of i_th row
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        // iterate the matrix again
        // set zero for each element which has column index or row index marked as zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] == 1 || columns[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    /**
     * this is a failed implement when trying set zero for the column and row while traversing
     * with that implementation, if there is any zero in the matrix, the entire elements after that zero will become zeros
     */
    public int[][] failRefineMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { // iterate the number of rows
            for (int j = 0; j < matrix[i].length; j++) { // iterate the element of i_th row
                if (matrix[i][j] == 0) {
                    setZeros(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    public int[][] setZeros(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[row][i] = 0;
        }

        for (int i = 0; i < matrix[col].length; i++) {
            matrix[i][col] = 0;
        }

        return matrix;
    }


    /**
     * Assume you have a method isSubstring which checks if one word is a substring of another.
     * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
     * (i.e., “waterbottle” is a rotation of “erbottlewat”).
     */
}
