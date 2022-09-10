package hexlet.code.schemas;


import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema(Class aClass) {
        super(aClass);
    }

    @Override
    public final StringSchema required() {  // required – любая непустая строка
        Predicate<String> func = x -> x.length() != 0;
        addValidationToList(func);
        setRequired(true);
        return this;
    }

    public final StringSchema contains(String s) {  //  contains – строка содержит определённую подстроку
        Predicate<String> func = x -> x.contains(s);
        addValidationToList(func);
        return this;
    }

    public final StringSchema minLength(int length) {  // minLength – строка равна или длиннее указанного числа
        Predicate<String> func = x -> x.length() >= length;
        addValidationToList(func);
        return this;
    }
}
