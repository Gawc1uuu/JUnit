package array;

import array.exceptions.ArrayIsNullException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilTest {


    private ArrayUtil arrayUtil;
    private int[] arr;


    @Before
    public void init() {
        arrayUtil = new ArrayUtil();
        arr = new int[]{5, 3, 4, 1, 2};
    }

    @Test
    public void shouldSumAllElementsAndReturn15() {
        int sum = arrayUtil.sumArrayElements(arr);
        assertEquals(15, sum);
    }

    @Test
    public void shouldMultiplyAllElements() {
        int product = arrayUtil.multiplyArrayElements(arr);
        assertEquals(120, product);
    }

    @Test(expected = ArrayIsNullException.class)
    public void shouldThrowArrayIsNullException() {
        int[] arrayForTest = null;
        arrayUtil.multiplyArrayElements(arrayForTest);
    }

    @Test
    public void shouldReturnMinElementFromArray(){
        int minValue = arrayUtil.minValueFromArray(arr);
        assertEquals(1, minValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldReturnIllegalArgumentExceptionThatSaysArrayIsNullOrEmpty(){
        int minValue = arrayUtil.minValueFromArray(null);
    }

    @Test
    public void shouldReturnMaxElementFromArray(){
        int maxValue = arrayUtil.maxValueFromArray(arr);
        assertEquals(5, maxValue);
    }

    @Test
    public void shouldReturnMedianFromArray(){
        double median = arrayUtil.medianValueFromArray(arr);
        assertEquals(3.00, median, 0);
    }

    @Test
    public void shouldReturnSortedArray(){
        int[] arrayToTest = {1, 2, 3, 4, 5};
        int[] sortedArray = arrayUtil.sortArray(arr);
        assertArrayEquals(arrayToTest, sortedArray);
    }

    @Test
    public void shouldReturnReversedArray(){
        int[] arrayToTest = {2, 1, 4, 3, 5};
        int[] reversedArray = arrayUtil.reverseArray(arr);
        assertArrayEquals(arrayToTest, reversedArray);
    }
}