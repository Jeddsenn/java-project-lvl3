package hexlet.code.schemas;

public class MapSchema extends BaseSchema {



    @Override
    public boolean isValid(Object map){
        if (isRequired()) {
            return !super.isValid(map);
        }
        return true;
    }

    public MapSchema required() {   //required – требуется тип данных Map
        super.setRequired(true);
        return this;
    }

    public MapSchema sizeof(int size) {//sizeof – количество пар ключ-значений в объекте Map должно быть равно заданному


        return this;
    }

}
