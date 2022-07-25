package hexlet.code;

import java.util.LinkedList;
import java.util.List;

public class StringSchema {
    List<String> contains;
    boolean required;
    int minLength;

    StringSchema(){
        this.contains = new LinkedList<>();
        this.required = false;
    }


    public boolean isValid(String str) {     // входной параметр соответствует всему остальному ю ноу
        if (this.required && ((str.equals("")) || str == null)) {
            return false;
        }
        for (String contain : this.contains) {
            if (!str.contains(contain)){
                return false;
            }
        }
        return true;
    }
    public String contains(String str){  //  contains – строка содержит определённую подстроку
        this.contains.add(str);
        return str;
    }


    public void required() {    // required – любая непустая строка
        this.required = true;
    }

    public boolean minLength(String str){  // minLength – строка равна или длиннее указанного числа
        return false;
    }


}
