package fr.enimaloc.sql.core.objects;

import java.util.Map;

public class TableObj {

    private Map<String , Object> values;

    public TableObj(Map<String, Object> values) {
        this.values = values;
    }

    public Object get(String columnName) {
        return values.get(columnName);
    }
}
