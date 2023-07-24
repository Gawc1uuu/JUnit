package array;

import array.exceptions.ArrayIsNullException;

import java.util.Arrays;
import java.util.Objects;

public class ArrayUtil {
        // napisz metody które
        // sumuja tablice liczb
        // licza iloczyn tablicy liczb
        // obsluz przypadki gdy tablica jest nullem


        public int sumArrayElements(int[] arr) {
            if (arr == null) throw new ArrayIsNullException();
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            return sum;
        }

        public int multiplyArrayElements(int[] arr) {
            if (arr == null) throw new ArrayIsNullException();
            int product = 1;
            for (int i : arr) {
                product *= i;
            }
            return product;
        }

        public int minValueFromArray(int[] arr){
            if(arr == null || arr.length == 0){
                throw new IllegalArgumentException("Array is null or empty");
            }

            return Arrays.stream(arr)
                    .filter(Objects::nonNull)
                    .min()
                    .orElseThrow(() -> new IllegalArgumentException("Can't find min element"));

        }

        public int maxValueFromArray(int[] arr){
            if(arr == null || arr.length == 0){
                throw new IllegalArgumentException("Array is null or empty");
            }

            return Arrays.stream(arr)
                    .filter(Objects::nonNull)
                    .max()
                    .orElseThrow(() -> new IllegalArgumentException("Cant find max element"));
        }

        public double medianValueFromArray(int[] arr){
            if(arr == null || arr.length == 0){
                throw new IllegalArgumentException("Array is null or empty");
            }

            Arrays.sort(arr);

            int length = arr.length;

            if (length % 2 == 0) {
                int middleIndex = length / 2;
                return (arr[middleIndex - 1] + arr[middleIndex]) / 2.0;
            } else {
                int middleIndex = length / 2;
                return arr[middleIndex];
            }
        }

        public int[] sortArray(int[] arr){
            if (arr == null) {
                throw new IllegalArgumentException("Array is null, cannot sort.");
            }

            int[] sorted = arr.clone();
            Arrays.sort(sorted);
            return sorted;
        }

        public int[] reverseArray(int[] arr) {
            int left = 0;
            int right = arr.length - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
            return arr;
        }

    }
