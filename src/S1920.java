import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1920 {
    public static void main(String[] args) throws IOException {
        S1920 s = new S1920();
        s.solution();
    }

    public void solution() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] strArray = bf.readLine().split(" ");
        int[] intArray = Arrays.stream(strArray).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(intArray);

        int m = Integer.parseInt(bf.readLine());
        String[] keyArray = bf.readLine().split(" ");
        for(int i=0;i<m;i++){
            int key = Integer.parseInt(keyArray[i]);
            if(binarySearch(intArray, 0, intArray.length, key)){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }

    private boolean binarySearch(int[] arr, int lo, int hi, int key){
        if(lo >= hi){
            return false;
        }

        int mid = (lo + hi) / 2;
        if(arr[mid] == key){
            return true;
        }
        else if(arr[mid] < key){
            return binarySearch(arr, mid+1, hi, key);
        }
        else{
            return binarySearch(arr, lo, mid, key);
        }
    }
}