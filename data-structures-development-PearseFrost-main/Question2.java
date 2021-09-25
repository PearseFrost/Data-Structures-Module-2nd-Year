public class Question2 {

    public static int getIndex(int[] arr, int a) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if(arr[i]==a){
                return count;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {90, 77, 67, 55, 75, 57, 98, 17, 50, 23, 30, 100, 34, 75, 28, 43, 14, 52, 64, 13,};
        int x = 64;
        int indexOf=getIndex(arr, x);
        System.out.println("Index is:"+indexOf);

    }
}
