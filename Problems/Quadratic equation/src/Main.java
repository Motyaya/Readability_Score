import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double a = scanner.nextDouble(), b=scanner.nextDouble(), c=scanner.nextDouble();
        double D = Math.pow(b,2) - 4 * a * c;
        double x1 = (-b-Math.sqrt(D))/(2*a);
        double x2 = (-b+Math.sqrt(D))/(2*a);
        if (x2>x1) System.out.println(x1 + " " + x2);
        else System.out.println(x2 + " " + x1);

    }
}