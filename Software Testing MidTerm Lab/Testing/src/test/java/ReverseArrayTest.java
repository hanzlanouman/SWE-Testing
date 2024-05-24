import org.example.ReverseArray;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayTest {

    @Test
    public void testEmptyArray() {
        int[] actual = {};
        ReverseArray.reverseArray(actual);

        assertArrayEquals(new int[]{}, actual);
    }

    @Test
    public void testSingleElementArray() {
        int[] actual = {7};
        ReverseArray.reverseArray(actual);

        assertArrayEquals(new int[]{7}, actual);
    }

    @Test
    public void testTwoElementArray() {
        int[] actual = {1, 2};
        ReverseArray.reverseArray(actual);
        int[] expected = {2, 1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMultiElementArray() {
        int[] actual = {4, 3, 2, 1};
        ReverseArray.reverseArray(actual);
        int[] expected = {1, 2, 3, 4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testLongMultiElementArray() {
        int[] actual = {1, 2, 3, 4, 5};
        ReverseArray.reverseArray(actual);
        int[] expected = {5, 4, 3, 2, 1};
        assertArrayEquals(expected, actual);
    }
}
