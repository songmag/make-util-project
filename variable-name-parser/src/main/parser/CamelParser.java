package main.parser;

public class CamelParser implements VariableNameDetailParser{
    @Override
    public String getParse(String variableName) {
        char[] arrName= variableName.toCharArray();
        StringBuilder builder= new StringBuilder();
        for(int i = 0 ; i < arrName.length ;i++){
            if(arrName[i] == '_'){
                builder.append(arrName[++i]);
            }
            else{
                char lowerCase = (char) (arrName[i]|0x20);
                builder.append(lowerCase);
            }
        }
        return builder.toString();
    }
}
