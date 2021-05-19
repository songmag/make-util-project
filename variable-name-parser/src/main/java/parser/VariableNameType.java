package parser;

public enum VariableNameType {
    SNAKE(new SnakeParser()),CAMEL(new CamelParser());
    public VariableNameDetailParser parser;

    VariableNameType(VariableNameDetailParser parser){
        this.parser = parser;
    }
    public static VariableNameType getVariableNameTypeByString(String name){
        return VariableNameType.valueOf(name.toUpperCase());
    }
}
