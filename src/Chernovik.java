import java.util.Arrays;

public class Chernovik {

    public static void main(String[] args) {

        int [] array = new int [] {1,2,10,19,29, 30, 60,77, 93,100};

        int position = binaryserch(77, 0, array.length, array);
        System.out.println(Arrays.toString(array) + " " + position);


        System.out.println(b2(new int [] {-3, -1, 0, 10, 20, 30, 31, 33, 80}, -3));


        System.out.println(rev(4));
        System.out.println(fibo(10));
        System.out.println(fiboActiv(100));
    }

    private static int binaryserch(int ourNumber, int  bigingIndex, int endIndex, int [] array) {

        int mid = bigingIndex + (endIndex-bigingIndex)/2;

        if(ourNumber==array[mid]){
            return mid;
        }else if (ourNumber > array[mid]){
            return binaryserch(ourNumber , mid +1, endIndex , array );
        }else {
            return binaryserch(ourNumber , bigingIndex, mid-1, array );
        }


    }

    public static  int b2(int [] a, int num){

        int low = 0;
        int high = a.length-1;
        while (low <= high){

            int mid = low + (high - low)/2;

            if(num == a[mid]){
                return mid;
            }else if (num > a[mid]){
                low = mid + 1;
            }else {
                high= mid - 1;
            }

        }

        return  -1;
    }

    //rev(4)
    //4 * rev(3)
    //3 * rev(2)
    //2 * rev(1)
    public  static  int rev (int n){
        if (n == 1){
            return  1;
        }
        return  n * rev(n -1);
    }


    public  static  int fibo (int n){
        if(n <=1 ){
            return  n;
        }

        return  fibo(n-1) + fibo(n-2);
    }

    public  static  long fiboActiv (int n){
        long [] a = new  long [n + 1];
        a[0]=0;
        a[1]=1;

        for (int i = 2; i <= n; i++){
            a[i] = a[i-1] + a[i-2];

        }
        return a[n];
    }
}


