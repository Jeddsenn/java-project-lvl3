package hexlet.code.schemas;


import java.util.Map;


public class MapSchema extends BaseSchema {
    private int size;
    private boolean sizeCheck;
    private Map<String, BaseSchema> shape;
    private boolean shapeCheck;

    public MapSchema(){
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

        Map<String, Object> m = null;
        if (map instanceof Map<?,?>){
            m = (Map<String, Object>) map;
        }

        if (sizeCheck) {
                if (m == null) {
                    return false;
                } else if (m.size() != this.size) {
                    return false;
                }
            }



        return true;
    }

    public MapSchema required() {   //required – требуется тип данных Map
        setRequired(true);
        return this;
    }

    public MapSchema sizeof(int size) {//sizeof – количество пар ключ-значений в объекте Map должно быть равно заданному
        this.size = size;
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
