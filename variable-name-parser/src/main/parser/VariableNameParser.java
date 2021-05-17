package main.parser;

import main.ParseAbleData;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class VariableNameParser {

    public static <T extends ParseAbleData> Map<String,String> getVariableName(Class<T> clazz, VariableNameType type){
        VariableNameDetailParser parser = type.parser;
        return Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(Field::getName,i -> parser.parse(i.getName())));
    }

    public static <T extends ParseAbleData> Map<String,String> getVariableName(Class<T> clazz,String type){
        VariableNameType parserType = VariableNameType.getVariableNameTypeByString(type);
        VariableNameDetailParser parser = parserType.parser;
        return Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toMap(Field::getName,i -> parser.parse(i.getName())));
    }
}
