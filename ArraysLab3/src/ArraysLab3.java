import java.util.Arrays;
public class ArraysLab3 {
	public static void main(String[] args) {
		int[] arr5 = {1,2,3,4,5,6};
		int[] arr = sum(arr5, arr5);
		System.out.println(Arrays.toString(arr));
		int[] arr321 = append(arr5, 5);
		System.out.println(Arrays.toString(arr321));
		int [] arr43 = remove(arr5, 1);
		System.out.println(Arrays.toString(arr43));
		System.out.println(sumEven(arr5));
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

}
