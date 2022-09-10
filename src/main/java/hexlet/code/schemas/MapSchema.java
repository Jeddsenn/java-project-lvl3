package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {

    public MapSchema(Class aClass) {
        super(aClass);
    }

    public MapSchema required() {   //required – требуется тип данных Map
        setRequired(true);
        return this;
    }

    //sizeof – количество пар ключ-значений в объекте Map должно быть равно заданному
    public MapSchema sizeof(int sz) {
        Predicate<Map> func = x -> x.size() == sz;
        addValidationToList(func);
        return this;
    }

    // shape - позволяет описывать валидацию для значений объекта Map по ключам
    public MapSchema shape(Map<String, BaseSchema> shape) {
        Predicate<Map> func = x -> {
            for (Object key : x.keySet()) {
                BaseSchema sh = shape.get(key);
                if (!sh.isValid(x.get(key))) {
                    return false;
                }
            }
            return true;
        };
        addValidationToList(func);
        return this;
    }
}
