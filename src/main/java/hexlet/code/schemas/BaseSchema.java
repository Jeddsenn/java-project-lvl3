package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public abstract class BaseSchema {

    private boolean isRequired = false;
    private final List<Predicate> predicateList = new ArrayList<>();
    private final Class requiredClass;

    public BaseSchema(Class aClass) {
        this.requiredClass = aClass;
    }

    public final boolean isValid(Object object) {
        if (predicateList.size() == 0 && !isRequired) {
            return true;
        }
        if (object == null) {
            return !isRequired;
        }
        if (!requiredClass.isInstance(object)) {
            return false;
        }
        for (Predicate predicate : predicateList) {
            if (!predicate.test(object)) {
                return false;
            }
        }
        return true;
    }

    protected final void addValidationToList(Predicate validationValue) {
        predicateList.add(validationValue);
    }

    public abstract BaseSchema required();

    protected final void setRequired(boolean required) {
        isRequired = required;
    }
}
