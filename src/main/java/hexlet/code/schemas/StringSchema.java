package hexlet.code.schemas;


import java.util.LinkedList;
import java.util.List;

public final class StringSchema extends BaseSchema {
//  private String contains;
    private final List<String> contains;
    private boolean required;
    private boolean minLengthCondition;
    private int minLength;

    public StringSchema() {
 //     this.contains = new String("");
        this.contains = new LinkedList<>();
        this.required = false;
        this.minLength = -1;
        this.minLengthCondition = false;
    }

    public boolean isValid(String str) {    // входной параметр соответствует всему остальному ю ноу
        boolean isValid = true;
        super.isValid(str);

        if (this.required) {
            if (str.equals("")) {
                isValid = false;
            }
        }

        if (!this.contains.isEmpty()) {
            for (String s : this.contains) {
                if (!str.contains(s)) {
                    isValid = false;
                    break;
                }
            }
        }

        if (minLength != -1) {
            if (this.minLength > str.length()) {
                return false;
            }
        }
        return isValid;
    }

    public StringSchema contains(String str) {  //  contains – строка содержит определённую подстроку
        this.contains.add(str);
        return this;
    }


    public StringSchema required() {    // required – любая непустая строка
        this.required = true;
        return this;
    }

    public StringSchema minLength(int minLength) {  // minLength – строка равна или длиннее указанного числа
        this.minLength = minLength;
        this.minLengthCondition = true;
        return this;
    }
}
