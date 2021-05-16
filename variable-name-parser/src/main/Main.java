package main;

import main.parser.VariableNameParser;
import main.parser.VariableNameType;

public class Main {
    public static void main(String[] args) {
        VariableNameParser.getVariableName(TestClass.class, VariableNameType.SNAKE).forEach((k, e)->{
            System.out.println(e);
        });
    }
}
class TestClass{
    String number;
    String userName;
    String phoneNumber;
}
