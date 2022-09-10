package hexlet.code.schemas;


import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema(Class aClass) {
        super(aClass);
    }

    public NumberSchema required() {    // required – любое !число! включая ноль
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {    // positive – положительное число
        Predicate<Integer> func = x -> x > 0;
        addValidationToList(func);
        return this;
    }

    public NumberSchema range(int min, int max) { // range – диапазон, в который должны попадать числа включая границы
        Predicate<Integer> func = x -> (x >= min && x <= max);
        addValidationToList(func);
        return this;
    }
}

