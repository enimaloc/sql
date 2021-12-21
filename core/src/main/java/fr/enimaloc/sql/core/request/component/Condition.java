package fr.enimaloc.sql.core.request.component;

public class Condition {

    public static End eq(String column, String a) {
        return new Sequence("").eq(column, a);
    }

    public static End neq(String column, String a) {
        return new Sequence("").neq(column, a);
    }

    public static End more(String column, String a) {
        return new Sequence("").more(column, a);
    }

    public static End less(String column, String a) {
        return new Sequence("").less(column, a);
    }

    public static End moreOrEq(String column, String a) {
        return new Sequence("").moreOrEq(column, a);
    }

    public static End lessOrEq(String column, String a) {
        return new Sequence("").lessOrEq(column, a);
    }

    public static End in(String column, String a) {
        return new Sequence("").in(column, a);
    }

    public static End between(String column, String a) {
        return new Sequence("").between(column, a);
    }

    public static End like(String column, String a) {
        return new Sequence("").like(column, a);
    }

    public static End isNull(String column) {
        return new Sequence("").isNull(column);
    }

    public static End notNull(String column) {
        return new Sequence("").notNull(column);
    }

    public record End(String query) {
        public Sequence and() {
            return new Sequence(query + " AND");
        }

        public Sequence or() {
            return new Sequence(query + " OR");
        }

        @Override
        public String toString() {
            return query.replaceFirst(" ", "");
        }
    }

    public record Sequence(String query) {
        public End eq(String column, String a) {
            return new End(query+" "+(column+" = "+a));
        }

        public End neq(String column, String a) {
            return new End(query+" "+(column+" != "+a));
        }

        public End more(String column, String a) {
            return new End(query+" "+(column+" > "+a));
        }

        public End less(String column, String a) {
            return new End(query+" "+(column+" < "+a));
        }

        public End moreOrEq(String column, String a) {
            return new End(query+" "+(column+" >= "+a));
        }

        public End lessOrEq(String column, String a) {
            return new End(query+" "+(column+" <= "+a));
        }

        public End in(String column, String a) {
            return new End(query+" "+(column+" IN "+a));
        }

        public End between(String column, String a) {
            return new End(query+" "+(column+" BETWEEN "+a));
        }

        public End like(String column, String a) {
            return new End(query+" "+(column+" LIKE "+a));
        }

        public End isNull(String column) {
            return new End(query+" "+(column+" IS NULL"));
        }

        public End notNull(String column) {
            return new End(query+" "+(column+" IS NOT NULL"));
        }

        @Override
        public String toString() {
            throw new IllegalStateException("Statement uncompleted");
        }
    }
}
