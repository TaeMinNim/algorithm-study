public class Application {
    public static void main(String[] args) {

    }

    public static int findCommonTypeDivisionIndex(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' '){
                return i;
            }
        }

        return -1;
    }
}
