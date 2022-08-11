package hexlet.code.schemas;

public abstract class  BaseSchema {
    private boolean required;


    public BaseSchema() {
        required = false;
    }

    /**
     * @param obj Object
     * @return boolean
     */
    public boolean isValid(Object obj) {
        return obj != null;
    }

    public final boolean isRequired() {
        return required;
    }

    public final void setRequired(boolean rq) {
        this.required = rq;
    }
}
