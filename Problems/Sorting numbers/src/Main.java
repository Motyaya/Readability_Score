import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        boolean isSorted = false;
        int buf=0;
        while(!isSorted){
            isSorted=true;
            for (int i = 0;i<numbers.length-1;i++){
                if (numbers[i]>numbers[i+1]){
                    isSorted=false;
                    buf=numbers[i];
                    numbers[i]=numbers[i+1];
                    numbers[i+1]=buf;
                }
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}