package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {
    private boolean positive;
    private int min;
    private int max;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public NumberSchema() {
        super();
        this.positive = false;
        this.max = Integer.MAX_VALUE;
        this.min = Integer.MIN_VALUE;
    }

    @Override
    public boolean isValid(Object num) {
        if (isRequired()) {
            if (!(num instanceof Number)) {
                return false;
            }
        }
        if (!super.isValid(num)) {
            if (isRequired()) {
                return false;
            }
        }

        Integer castedNum = null;
        if (num instanceof Number) {
            castedNum = (Integer) num;
        }

        if (positive) {
            if (castedNum == null) {
                return true;
            } else if (castedNum <= 0) {
                return false;
            }
        }
        if (getMin() != Integer.MIN_VALUE || getMax() != Integer.MAX_VALUE) {
            if (castedNum < getMin() || castedNum > getMax()) {
                return false;
            }
        }
        return true;
    }

    public NumberSchema required() {    // required – любое число включая ноль
        setRequired(true);
        return this;
    }

    public NumberSchema positive() {    // positive – положительное число
        this.positive = true;
        return this;
    }

    public NumberSchema range(int mi, int ma) { // range – диапазон, в который должны попадать числа включая границы
        this.min = mi;
        this.max = ma;
        return this;
    }
}
