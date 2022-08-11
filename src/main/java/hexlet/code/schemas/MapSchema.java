package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    private int size;
    private boolean sizeCheck;
    private Map<String, BaseSchema> shape;
    private boolean shapeCheck;

    public MapSchema() {
        super();
        this.size = 0;
        this.sizeCheck = false;
        this.shapeCheck = false;
    }

    @Override
    public boolean isValid(Object map) {
        if (!super.isValid(map)) {
            if (isRequired()) {
                return false;
            }
        }

        Map<String, BaseSchema> m = null;
        if (map instanceof Map<?, ?>) {
            m = (Map<String, BaseSchema>) map;
        }

        if (sizeCheck) {
            if (m == null) {
                return false;
            } else if (m.size() != this.size) {
                return false;
            }
        }

        if (shapeCheck) {
            for (String key : m.keySet()) {
                BaseSchema sh = shape.get(key);
                if (!sh.isValid(m.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }


    public MapSchema required() {   //required – требуется тип данных Map
        setRequired(true);
        return this;
    }

    //sizeof – количество пар ключ-значений в объекте Map должно быть равно заданному
    public MapSchema sizeof(int sz) {
        this.size = sz;
        this.sizeCheck = true;
        return this;
    }

    // shape - позволяет описывать валидацию для значений объекта Map по ключам
    public MapSchema shape(Map<String, BaseSchema> map) {
        this.shape = map;
        this.shapeCheck = true;
        return this;
    }
}
