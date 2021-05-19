package parser;

public class CamelParser implements VariableNameDetailParser{
    @Override
    public String parse(String variableName) {
        if(!canParse(variableName)){
            return variableName;
        }
        char[] arrName= variableName.toCharArray();
        StringBuilder builder= new StringBuilder();
        for(int i = 0 ; i < arrName.length ;i++){
            if(arrName[i] == '_'){
                char upperCase = (char) (arrName[++i]&0x5f);
                builder.append(upperCase);
            }
            else{
                char lowerCase = (char) (arrName[i] | 0x20);
                builder.append(lowerCase);
            }
        }
        return builder.toString();
    }

    private boolean canParse(String value){
        return value.contains("_");
    }
}
