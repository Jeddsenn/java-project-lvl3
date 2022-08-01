package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean required;
    private boolean positive;
    private int min;
    private int max;

    public NumberSchema() {
        this.required = false;
        this.positive = false;
        this.max = Integer.MAX_VALUE;
        this.min = Integer.MIN_VALUE;
    }

    public boolean isValid(Object num){
        super.isValid(num);

        if (required){
            if (!(num instanceof Number)){
                return false;
            }
        }
        Integer castedNum = 0;
        if (num instanceof Number) {
            castedNum = (Integer) num;
        }

        if (this.positive) {
            if (castedNum <= 0){
                return false;
            }
        }

        if (castedNum < this.min || castedNum > this.max){
            return false;
        }
        return true;
    }

    public NumberSchema required() {    // required – любое число включая ноль
        this.required = true;
        return this;
    }

    public NumberSchema positive() {    // positive – положительное число
        this.positive = true;
        return this;
    }

    public NumberSchema range(int min, int max) {    // range – диапазон, в который должны попадать числа включая границы
        this.min = min;
        this.max = max;
        return this;
    }
}
