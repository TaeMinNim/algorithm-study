public class Application {
    public static void main(String[] args) {

    }

    public static int findCommonTypeDivisionIndex(String input) {
        int divisionIndex = input.indexOf(' ');
        return divisionIndex;
    }

    public static String getCommonType(String input, int commonTypeDivisionIndex){
        return input.substring(0, commonTypeDivisionIndex);
    }
}
