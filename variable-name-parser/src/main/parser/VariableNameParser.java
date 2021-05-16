package main.parser;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VariableNameParser {

    public static Map<String,String> getVariableName(Class clazz,VariableNameType type){
        VariableNameDetailParser parser = type.parser;
        Map<String,String> result = new HashMap<>();
        Arrays.stream(clazz.getDeclaredFields()).forEach((e)->{
            String variableName = e.getName();
            result.put(variableName, parser.getParse(variableName));
        });
        return result;
    }

    public static Map<String,String> getVariableName(Class clazz,String type){
        VariableNameType parserType = VariableNameType.getVariableNameTypeByString(type);
        VariableNameDetailParser parser = parserType.parser;
        Map<String,String> result = new HashMap<>();
        Arrays.stream(clazz.getDeclaredFields()).forEach((e)->{
            String variableName = e.getName();
            result.put(variableName, parser.getParse(variableName));
        });
        return result;
    }

}
