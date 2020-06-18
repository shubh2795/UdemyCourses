import java.util.Scanner;

class Challenge1 {
    // Challenge video 29 : convert pound to Kilograms

    public double convert(double pounds) {
        double kilos = 0.45359237 * pounds;
        return kilos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the weight in pounds");
        double pounds = sc.nextDouble();
        Challenge1 solve = new Challenge1();
        System.out.println("The weight in kilograms is: " + solve.convert(pounds));
    }
}