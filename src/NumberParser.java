class NumberParser {
    static int romanToInt(String s) {
        int ans = 0, num = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            num = switch (s.charAt(i)) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> throw new IllegalArgumentException("Некорректное значение: " + s);
            };
            if (num < 1 || num > 1000) {
                throw new IllegalArgumentException("Некорректное значение: " + s);
            }
            if (num < prev) {
                ans -= num;
            } else {
                ans += num;
            }
            prev = num;
        }
        return ans;
    }
    static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            throw new IllegalArgumentException("Невозможно преобразовать число " + num + " в римскую систему счисления");
        }
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    static boolean isRoman(String str){
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (String romanNumeral : romanNumerals) {
            if (romanNumeral.equals(str)) {
                return true;
            }
        }
        return false;
    }
    static int parseNumber(String str) {
        int result = 0;
        try {
            result = Integer.parseInt(str);
            if (result < 1 || result > 10) {
                throw new IllegalArgumentException("Некорректное значение: " + result);
            }
        } catch (NumberFormatException e) {
            result = NumberParser.romanToInt(str);
        }
        return result;
    }
}