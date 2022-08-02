package hexlet.code.schemas;

public abstract class  BaseSchema {
    public boolean required;

    public BaseSchema() {
        required = false;
    }
    public boolean isValid(Object obj){
        return obj != null;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
}
