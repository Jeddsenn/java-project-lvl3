package hexlet.code.schemas;


import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class StringSchema extends BaseSchema {
    private final List<String> contains;
    private boolean minimalLengthCondition;
    private int minLength;

    public StringSchema() {
        super();
        this.contains = new LinkedList<>();
        this.minLength = Integer.MIN_VALUE;
        this.minimalLengthCondition = false;
    }

    @Override
    public boolean isValid(Object str) {    // входной параметр соответствует активным условиям
        String string = "";

        if (!super.isValid(str)) {
            if (isRequired()) {
                return false;
            }
        } else if (Objects.equals(str, "")) {
            if (isRequired()) {
                return false;
            }
        }

        if (str instanceof String) {
            string = (String) str;
        }


        if (!this.contains.isEmpty()) {
            for (String s : this.contains) {
                if (!string.contains(s)) {
                    return false;
                }
            }
        }

        if (minimalLengthCondition) {
            return string.length() >= minLength;
        }
        return true;
    }

    public StringSchema contains(String str) {  //  contains – строка содержит определённую подстроку
        this.contains.add(str);
        return this;
    }


    public StringSchema required() {    // required – любая непустая строка
        setRequired(true);
        return this;
    }

    public StringSchema minLength(int ml) {  // minLength – строка равна или длиннее указанного числа
        this.minLength = ml;
        this.minimalLengthCondition = true;
        return this;
    }
}































/*
    boolean isValid = true;
    boolean isNull = str == null;

        if (isRequired()) {
        isValid(str);
    }
        if (isRequired() && !isNull) {
        if (str.equals("")) {
            isValid = false;
        }
    }
    String string = "";
        if (str instanceof String){
        string = (String) str;
    }

        if (!this.contains.isEmpty()) {
        for (String s : this.contains) {
            if (!string.contains(s)) {
                isValid = false;
                break;
            }
        }
    }

        if (minLength != -1) {
        if (this.minLength > string.length()) {
            return false;
        }
    }
        return isValid;
}*/
