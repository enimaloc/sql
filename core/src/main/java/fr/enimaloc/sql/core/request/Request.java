package fr.enimaloc.sql.core.request;

import fr.enimaloc.sql.core.request.component.Condition;
import fr.enimaloc.sql.core.request.component.OrderBy;
import java.util.function.Supplier;

public class Request<T> {

    private String base;

    public Request(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return base;
    }

    public String base() {
        return base;
    }

    interface TableRequest<R> {
        R tableName(String tableName);
        String tableName();
    }

    interface ColumnRequest<R> {
        R columnsName(String... columnsName);
        String[] columnsName();
    }

    interface WhereRequest<R> {
        R where(Supplier<Condition.End> where);
        Supplier<Condition.End> where();
    }

    interface GroupRequest<R> {
        R group(String... group);
        String[] group();
    }

    interface LimitRequest<R> {
        R limit(int limit);
        R limit(int limit, int offset);
        int limit();
        int offset();
    }

    interface HavingRequest<R> {
        R having(Supplier<Condition.End> having);
        Supplier<Condition.End> having();
    }

    interface OrderRequest<R> {
        R orderBy(Supplier<OrderBy> orderBy);
        Supplier<OrderBy> orderBy();
    }

}
