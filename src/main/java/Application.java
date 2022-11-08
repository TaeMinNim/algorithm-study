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

    public static String getRestString(String input, int commonTypeDivisionIndex){
        return input.substring(commonTypeDivisionIndex);
    }

    public static int findVariableStartIndex(String restString){
        for (int i = 0; i < restString.length(); i++){
            char c = restString.charAt(i);
            if (c != ' '){
                return i;
            }
        }

        return -1;
    }

    public static int findVariableEndIndex(String restStaring){
        return restStaring.indexOf(',');
    }
}
