import java.util.Arrays;
public class ArraysLab3 {
	public static void main(String[] args) {
		int [] a1 = {5, 10, 15, 20, 25, 30, 35, 40} ;
		int [] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int [] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int [] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arrSum = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			arrSum[i] = arr1[i] + arr2[i];
		}
		return arrSum;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] biggerArr = new int[arr.length + 1];
		for(int i = 0; i < arr.length; i++) {
			biggerArr[i] = arr[i];
		}
		biggerArr[arr.length] = num;
		return biggerArr;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] arrRemoved = new int[arr.length-1];
		for(int i = 0; i < arr.length-1; i++) {
			if(i < idx) {
				arrRemoved[i] = arr[i];
			}
			if(i >= idx) {
				arrRemoved[i] = arr[i+1];
			}
		}
		return arrRemoved;
	}

	public static int sumEven(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i+=2) {
			sum += arr[i];
		}
		return(sum);
	}
	
	public static void rotateRight(int[] arr) {
		int firstArr = arr[arr.length-1];
		for(int i = arr.length-1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = firstArr;
		
	}

}
