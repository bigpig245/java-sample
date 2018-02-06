import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ArrayAndStringUtilsTests {

    @Test
    public void test_is_unique() {
        assertThat(ArrayAndStringUtils.isUnique("12343")).isFalse();
        assertThat(ArrayAndStringUtils.isUnique("1234")).isTrue();
        assertThat(ArrayAndStringUtils.isUnique("1aa42342weds")).isFalse();
        assertThat(ArrayAndStringUtils.isUnique("1")).isTrue();
        assertThat(ArrayAndStringUtils.isUnique("")).isTrue();
        assertThat(ArrayAndStringUtils.isUnique("The quick brown fox jumps over the lazy dog")).isFalse();
    }

    @Test
    public void test_remove_duplicate() {
        assertThat(ArrayAndStringUtils.removeDuplicate("aaabbbcccd".toCharArray())).containsOnlyOnce('a', 'b', 'c', 'd');
        assertThat(ArrayAndStringUtils.removeDuplicate("125824214784545".toCharArray())).containsOnlyOnce('1', '2', '5', '4', '7', '8');
        assertThat(ArrayAndStringUtils.removeDuplicate("123456".toCharArray())).containsOnlyOnce('1', '2', '3', '4', '5', '6');
        assertThat(ArrayAndStringUtils.removeDuplicate("".toCharArray()).length).isEqualTo(0);
        assertThat(String.valueOf(ArrayAndStringUtils.removeDuplicate("aaabbbcccd".toCharArray())).trim()).isEqualTo("abcd");
        assertThat(String.valueOf(ArrayAndStringUtils.removeDuplicate("125824214784545".toCharArray())).trim()).isEqualTo("125847");
        assertThat(String.valueOf(ArrayAndStringUtils.removeDuplicate("123456".toCharArray())).trim()).isEqualTo("123456");
        assertThat(String.valueOf(ArrayAndStringUtils.removeDuplicate("abababa".toCharArray())).trim()).isEqualTo("ab");
    }

    @Test
    public void test_matrix() {
        int[][] foo = new int[][]{
                new int[]{1, 2, 3},
                new int[]{1, 2, 3, 4},
        };

        System.out.println(foo.length); //2
        System.out.println(foo[0].length); //3
        System.out.println(foo[1].length); //4
    }

    @Test
    public void test_set_zero_matrix() {
        int[][] foo = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 2, 1, 7, 8},
                new int[]{1, 0, 0, 9, 10},
                new int[]{1, 3, 6, 7, 2},
                new int[]{5, 6, 3, 1, 1},
        };

        int[][] expected = new int[][]{
                new int[]{1, 0, 0, 4, 5},
                new int[]{3, 0, 0, 7, 8},
                new int[]{0, 0, 0, 0, 0},
                new int[]{1, 0, 0, 7, 2},
                new int[]{5, 0, 0, 1, 1},
        };

        print(foo);
        print(ArrayAndStringUtils.refineMatrix(foo));
        assertThat(foo).contains(expected);
    }

    @Test
    public void test_set_zero_matrix_failed() {
        int[][] foo = new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{3, 2, 1, 7, 8},
                new int[]{1, 0, 0, 9, 10},
                new int[]{1, 3, 6, 7, 2},
                new int[]{5, 6, 3, 1, 1},
        };

        int[][] expected = new int[][]{
                new int[]{1, 0, 0, 0, 0},
                new int[]{3, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0},
        };

        print(foo);
        print(ArrayAndStringUtils.failRefineMatrix(foo));
        assertThat(foo).contains(expected);
    }

    private static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Done!");
    }
}
