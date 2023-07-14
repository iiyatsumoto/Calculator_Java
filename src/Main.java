import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = in.nextLine().toUpperCase();

        System.out.println(calc(input));


    }
    public static String calc(String input){
        String result = "";
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Введено некоректное выражение");
        }

        String xStr = parts[0].trim();
        String operatorStr = parts[1].trim();
        String yStr = parts[2].trim();

        int x = NumberParser.parseNumber(xStr);
        char operator = operatorStr.charAt(0);
        int y = NumberParser.parseNumber(yStr);

        if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            throw new IllegalArgumentException("Введен некоректный оператор :(");
        }

        if (NumberParser.isRoman(yStr) && NumberParser.isRoman(xStr)) {
            switch (operator) {
                case '+' -> result = xStr + " + " + yStr + " = " + NumberParser.intToRoman(Operations.sum(x, y));
                case '-' -> result = xStr + " - " + yStr + " = " + NumberParser.intToRoman(Operations.subtract(x, y));
                case '*' -> result = xStr + " * " + yStr + " = " + NumberParser.intToRoman(Operations.multiply(x, y));
                case '/' -> result = xStr + " / " + yStr + " = " + NumberParser.intToRoman(Operations.division(x, y));
            }
        } else if (!NumberParser.isRoman(yStr) && !NumberParser.isRoman(xStr)) {
            switch (operator) {
                case '+' -> result = x + " + " + y + " = " + Operations.sum(x, y);
                case '-' -> result = x + " - " + y + " = " + Operations.subtract(x, y);
                case '*' -> result = x + " * " + y + " = " + Operations.multiply(x, y);
                case '/' -> result = x + " / " + y + " = " + Operations.division(x, y);
            }
        } else {
            throw new IllegalArgumentException("Введены числа разных алфавитов :(");
        }
        return result;
    }
}