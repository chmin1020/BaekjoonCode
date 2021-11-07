package realSpace;
import java.util.Scanner;

public class Main {
	private static int arr[] = new int[100000];
	private static int newArr[] = new int[100000];
	
	public static void mergeSort(int left, int right) {
		if(left >= right) return;
		
		int i, j, k;
		int mid = (left + right) / 2;
		mergeSort(left, mid);
		mergeSort(mid + 1, right);
		
		for(i = left, j = mid + 1, k = left; i <= mid && j <= right;) {
			if(arr[i] <= arr[j]) newArr[k++] = arr[i++];
			else newArr[k++] = arr[j++];
		}
		while(i <= mid) newArr[k++] = arr[i++];
		while(j <= right) newArr[k++] = arr[j++];
		
		for(i = left; i <= right; i++)
			arr[i] = newArr[i];	
	}
	
	public static int binarySearch(int left, int right, int tar) {
		if(left > right) return 0;
		
		int mid = (left + right) / 2;
		if(arr[mid] == tar)
			return 1;
		else if(arr[mid] > tar)
			return binarySearch(left, mid - 1, tar);
		else
			return binarySearch(mid + 1, right, tar);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, tar;
		
		n = sc.nextInt();
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		mergeSort(0, n - 1);
		
		m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			tar = sc.nextInt();
			System.out.println(binarySearch(0, n - 1, tar));
		}
		
		sc.close();
	}
}
