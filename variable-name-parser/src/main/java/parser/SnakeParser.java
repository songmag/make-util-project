package parser;

public class SnakeParser implements VariableNameDetailParser{
    @Override
    public String parse(String variableName) {
        if(!canParse(variableName)){
            return variableName;
        }
        char[] arrName= variableName.toCharArray();
        StringBuilder builder= new StringBuilder();
        for(int i = 0 ; i < arrName.length ;i++){
            if(64 < arrName[i] && arrName[i] < 97 ){
                builder.append("_").append(arrName[i]);
            }else{
                char upperCase = (char) (arrName[i]&0x5f);
                builder.append(upperCase);
            }
        }
        return builder.toString();
    }

    private boolean canParse(String value){
        return !value.contains("_");
    }
}
