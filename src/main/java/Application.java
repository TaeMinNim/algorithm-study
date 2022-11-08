import java.util.*;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        List<String> oneLineVariable = getOneLineVariable("int& a*[]&, b, c*;");
        for (String variable : oneLineVariable) {
            System.out.println(variable);
        }
    }

    public static List<String> getOneLineVariable(String input) {
        int commonTypeDivisionIndex = findCommonTypeDivisionIndex(input);
        String commonType = input.substring(0, commonTypeDivisionIndex);
        String restString = input.substring(commonTypeDivisionIndex);

        List<String> oneLineVariableList = new ArrayList<>();

        while (!restString.equals(";")) {
            int startIndex = findVariableStartIndex(restString);
            int endIndex = findVariableEndIndex(restString);
            String variable = getVariable(restString, startIndex, endIndex);
            restString = restString.substring(endIndex);

            int variableTypeStartIndex = findVariableTypeStartIndex(variable);
            String variableName;
            String variableType;

            if (variableTypeStartIndex == 0) {
                variableName = variable;
                variableType = " ";
            } else {
                variableName = variable.substring(0, variableTypeStartIndex);
                variableType = variable.substring(variableTypeStartIndex);
            }

            variableType = reverseVariableType(variableType);
            oneLineVariableList.add(combineVariable(commonType, variableType, variableName));
        }
        return oneLineVariableList;
    }

    public static int findCommonTypeDivisionIndex(String input) {
        int divisionIndex = input.indexOf(' ');
        return divisionIndex;
    }

    public static int findVariableStartIndex(String restString) {
        for (int i = 0; i < restString.length(); i++) {
            char c = restString.charAt(i);
            if (c != ' ' && c != ',') {
                return i;
            }
        }

        return -1;
    }

    public static int findVariableEndIndex(String restStaring) {
        for (int i = 1; i < restStaring.length(); i++) {
            char c = restStaring.charAt(i);
            if (c == ',' || c == ';') {
                return i;
            }
        }

        return -1;
    }

    public static String getVariable(String restString, int startIndex, int endIndex) {
        return restString.substring(startIndex, endIndex);
    }

    public static int findVariableTypeStartIndex(String variable) {
        for (int i = 0; i < variable.length(); i++) {
            char c = variable.charAt(i);
            if (c == '&' || c == '[' || c == '*') {
                return i;
            }
        }

        return 0;
    }

    public static String reverseVariableType(String variableType) {
        List<Character> temp = new ArrayList<>();
        int variableTypeLength = variableType.length();

        for (int i = variableTypeLength - 1; i >= 0; i--) {
            char c = variableType.charAt(i);
            if (c == '[') {
                c = ']';
            } else if (c == ']') {
                c = '[';
            }
            temp.add(c);
        }

        String reversedVariableType = "";
        for (char c : temp) {
            reversedVariableType += c;
        }

        return reversedVariableType;
    }

    public static String combineVariable(String commonType, String variableType, String variableName) {
        String combinedVariable;
        if (variableType.equals(" ")) {
            combinedVariable = String.format("%s %s;", commonType, variableName);
        } else {
            combinedVariable = String.format("%s%s %s;", commonType, variableType, variableName);
        }
        return combinedVariable;
    }
}
