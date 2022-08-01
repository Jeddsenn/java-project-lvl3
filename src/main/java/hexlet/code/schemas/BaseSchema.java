package hexlet.code.schemas;

public abstract class  BaseSchema {
    protected boolean required;

    public boolean isValid(Object obj){
        if (required){
            if (obj == null){
                return false;
            }
        }
        return true;
    }

    protected boolean isRequired() {
        return required;
    }

    protected void setRequired(boolean required) {
        this.required = required;
    }
}
