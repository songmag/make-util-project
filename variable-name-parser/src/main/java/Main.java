import parser.*;
import parser.ParseAbleData;

public class Main {
    public static void main(String[] args) {
        VariableNameParser.getVariableName(TestClass.class, VariableNameType.SNAKE).forEach((k, e)->{
            System.out.println(e);
        });
        VariableNameParser.getVariableName(TestClass.class, VariableNameType.CAMEL).forEach((k, e)->{
            System.out.println(e);
        });
    }
}
class TestClass implements ParseAbleData {
    int userId;
    int phoneNumber;
    int caseOffer;
}
