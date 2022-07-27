package hexlet.code;

import java.util.LinkedList;
import java.util.List;

public final class StringSchema {
    private List<String> contains;
    private boolean required;
    private int minLength;

    public StringSchema() {
        this.contains = new LinkedList<>();
        this.required = false;
        this.minLength = -1;
    }


    public boolean isValid(String str) {        // входной параметр соответствует всему остальному ю ноу
        if (this.required && ((str == null) || str.equals(""))) {
            return false;
        }
        for (String c : this.contains) {
            if (!str.contains(c)) {
                return false;
            }
        }
        if (str != null) {
            if (str.length() < this.minLength) {
                return false;
            }
        }
        return true;
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
        return this;
    }
}
