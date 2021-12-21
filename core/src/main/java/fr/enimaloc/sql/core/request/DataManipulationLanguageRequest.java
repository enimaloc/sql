package fr.enimaloc.sql.core.request;

import fr.enimaloc.sql.core.annotation.Table;
import fr.enimaloc.sql.core.exception.AnnotationNotPresentException;
import fr.enimaloc.sql.core.objects.TableObj;
import fr.enimaloc.sql.core.request.component.Condition;
import fr.enimaloc.sql.core.request.component.OrderBy;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class DataManipulationLanguageRequest<T> extends Request<T>
        implements Request.TableRequest<DataManipulationLanguageRequest<T>> {

    private String tableName;

    public DataManipulationLanguageRequest(String base) {
        super(base);
    }

    public static <T> DataManipulationLanguageRequest.Select<T> select(Class<T> clazz)
            throws AnnotationNotPresentException {
        return (Select<T>) fromClazzSameAsClazz("SELECT", clazz);
    }

    public static DataManipulationLanguageRequest.Select<TableObj> select(String tableName) {
        return (Select<TableObj>) fromName("SELECT", tableName);
    }

    public static DataManipulationLanguageRequest.Update<Void> update(Class<?> clazz)
            throws AnnotationNotPresentException {
        return (Update<Void>) fromClazzNoReturn("UPDATE", clazz);
    }

    public static DataManipulationLanguageRequest.Update<Void> update(String tableName) {
        return (Update<Void>) fromNameNoReturn("UPDATE", tableName);
    }

    public static DataManipulationLanguageRequest.Insert<Void> insert(Class<?> clazz)
            throws AnnotationNotPresentException {
        return (Insert<Void>) fromClazzNoReturn("INSERT", clazz);
    }

    public static DataManipulationLanguageRequest.Insert<Void> insert(String tableName) {
        return (Insert<Void>) fromNameNoReturn("INSERT", tableName);
    }

    public static DataManipulationLanguageRequest.Delete<Void> delete(Class<?> clazz)
            throws AnnotationNotPresentException {
        return (Delete<Void>) fromClazzNoReturn("DELETE", clazz);
    }

    public static DataManipulationLanguageRequest.Delete<Void> delete(String tableName) {
        return (Delete<Void>) fromNameNoReturn("DELETE", tableName);
    }

    private static <T> DataManipulationLanguageRequest<Void> fromClazzNoReturn(String base, Class<?> clazz)
            throws AnnotationNotPresentException {
        return fromClazz(base, clazz);
    }

    private static <T> DataManipulationLanguageRequest<T> fromClazzSameAsClazz(String base, Class<T> clazz)
            throws AnnotationNotPresentException {
        return fromClazz(base, clazz);
    }

    private static <T> DataManipulationLanguageRequest<T> fromClazz(String base, Class<?> clazz)
            throws AnnotationNotPresentException {
        if (!clazz.isAnnotationPresent(Table.class)) {
            throw new AnnotationNotPresentException(Table.class, clazz);
        }
        try {
            return DataManipulationLanguageRequest.<T>getInstance(base).tableName(clazz.getAnnotation(Table.class).name());
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DataManipulationLanguageRequest<Void> fromNameNoReturn(String base, String tableName) {
        try {
            return DataManipulationLanguageRequest.<Void>getInstance(base).tableName(tableName);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static DataManipulationLanguageRequest<TableObj> fromName(String base, String tableName) {
        try {
            return DataManipulationLanguageRequest.<TableObj>getInstance(base).tableName(tableName);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static <T> DataManipulationLanguageRequest<T> getInstance(String base)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException,
                   IllegalAccessException {
        Optional<Class<?>> clazzOpt = Arrays.stream(DataManipulationLanguageRequest.class.getClasses())
                                            .filter(clazz -> clazz.getSimpleName().equalsIgnoreCase(base))
                                            .findFirst();

        if (clazzOpt.isEmpty()) {
            throw new ClassNotFoundException(base);
        }
        //noinspection unchecked
        Class<DataManipulationLanguageRequest<T>> clazz = (Class<DataManipulationLanguageRequest<T>>) clazzOpt.get();
        return clazz.getConstructor(String.class).newInstance(base);
    }

    @Override
    public DataManipulationLanguageRequest<T> tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    @Override
    public String tableName() {
        return tableName;
    }


    public static class Select<T> extends DataManipulationLanguageRequest<T>
            implements ColumnRequest<Select<T>>,
                       WhereRequest<Select<T>>,
                       GroupRequest<Select<T>>,
                       HavingRequest<Select<T>>,
                       OrderRequest<Select<T>>,
                       LimitRequest<Select<T>> {
        private Supplier<Condition.End> where       = null;
        private Supplier<Condition.End> having      = null;
        private Supplier<OrderBy>       orderBy     = null;
        private String[]                group       = new String[0];
        private String[]                columnsName = new String[0];
        private int                     limit       = -1;
        private int                     offset      = -1;

        public Select(String base) {
            super(base);
        }

        @Override
        public Select<T> columnsName(String... columnsName) {
            this.columnsName = columnsName;
            return this;
        }

        @Override
        public String[] columnsName() {
            return columnsName;
        }

        @Override
        public Select<T> where(Supplier<Condition.End> where) {
            this.where = where;
            return this;
        }

        @Override
        public Supplier<Condition.End> where() {
            return where;
        }

        @Override
        public Select<T> group(String... group) {
            this.group = group;
            return this;
        }

        @Override
        public String[] group() {
            return group;
        }

        @Override
        public Select<T> having(Supplier<Condition.End> having) {
            this.having = having;
            return this;
        }

        @Override
        public Supplier<Condition.End> having() {
            return having;
        }

        @Override
        public Select<T> orderBy(Supplier<OrderBy> orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        @Override
        public Supplier<OrderBy> orderBy() {
            return orderBy;
        }

        @Override
        public Select<T> limit(int limit) {
            return limit(limit, -1);
        }

        @Override
        public Select<T> limit(int limit, int offset) {
            this.limit  = limit;
            this.offset = offset;
            return this;
        }

        @Override
        public int limit() {
            return limit;
        }

        @Override
        public int offset() {
            return offset;
        }

        @Override
        public String toString() {
            String ret = this.base();
            ret += this.columnsName().length == 0 ? " *" : " "+String.join(",", this.columnsName());
            ret += " FROM "+this.tableName();
            ret += this.where() == null ? "" : " WHERE "+this.where().get().toString();
            ret += this.group().length == 0 ? "" : " GROUP BY " + String.join(",", this.group());
            ret += this.having() == null ? "" : " HAVING "+this.having().get().toString();
            ret += this.orderBy() == null ? "" : " ORDER BY "+this.orderBy().get().toString();
            ret += this.limit == -1 ? "" : " LIMIT "+limit;
            ret += this.limit == -1 || this.offset == -1 ? "" : " OFFSET "+offset;

            return ret;
        }
    }

    static class Update<T> extends DataManipulationLanguageRequest<T>
            implements ColumnRequest<Update<T>>, WhereRequest<Update<T>> {
        private Supplier<Condition.End> where;
        private String[]            columnsName;

        public Update(String base) {
            super(base);
        }

        @Override
        public Update<T> columnsName(String... columnsName) {
            this.columnsName = columnsName;
            return this;
        }

        @Override
        public String[] columnsName() {
            return columnsName;
        }

        @Override
        public Update<T> where(Supplier<Condition.End> where) {
            this.where = where;
            return this;
        }

        @Override
        public Supplier<Condition.End> where() {
            return where;
        }
    }

    static class Delete<T> extends DataManipulationLanguageRequest<T> implements WhereRequest<Delete<T>> {
        private Supplier<Condition.End> where;

        public Delete(String base) {
            super(base);
        }

        @Override
        public Delete<T> where(Supplier<Condition.End> where) {
            this.where = where;
            return this;
        }

        @Override
        public Supplier<Condition.End> where() {
            return where;
        }
    }

    static class Insert<T> extends DataManipulationLanguageRequest<T> implements ColumnRequest<Insert<T>> {
        private String[] columnsName;

        Insert(String base) {
            super(base);
        }

        @Override
        public Insert<T> columnsName(String... columnsName) {
            this.columnsName = columnsName;
            return this;
        }

        @Override
        public String[] columnsName() {
            return columnsName;
        }
    }
}
