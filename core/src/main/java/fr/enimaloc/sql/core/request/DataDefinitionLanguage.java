package fr.enimaloc.sql.core.request;

class DataDefinitionLanguage extends Request<Void> implements Request.TableRequest<DataDefinitionLanguage> {

    public static DataDefinitionLanguage create() {
        return new DataDefinitionLanguage("CREATE");
    }

    public static DataDefinitionLanguage alter() {
        return new DataDefinitionLanguage("ALTER");
    }

    public static DataDefinitionLanguage drop() {
        return new DataDefinitionLanguage("DROP");
    }

    public static DataDefinitionLanguage truncate() {
        return new DataDefinitionLanguage("TRUNCATE");
    }

    public static DataDefinitionLanguage rename() {
        return new DataDefinitionLanguage("RENAME");
    }

    private String tableName;

    public DataDefinitionLanguage(String base) {
        super(base);
    }

    @Override
    public DataDefinitionLanguage tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    public String tableName() {
        return tableName;
    }
}
