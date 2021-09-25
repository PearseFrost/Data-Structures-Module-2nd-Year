public class Average {
    public static void main(String[] args) {
        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
        double count = 0;

        for (int i = 0; i < my_array.length; i++) {
            count = count + my_array[i];
        }
        double average = count / my_array.length;
        System.out.println("Average is:" + average);

    }
}