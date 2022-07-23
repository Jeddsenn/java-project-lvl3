package hexlet.code;

import javax.xml.validation.Schema;

public class Validator {
StringSchema schema;
    Validator(){
    }

    public void string() {
        this.schema = new StringSchema(this);
    }
}
