package fr.enimaloc.sql.core.request.component;

public record OrderBy(Order order, String column) {

    public static OrderBy ascendant(String columnName) {
        return custom(Order.ASCENDANT, columnName);
    }

    public static OrderBy descendant(String columnName) {
        return custom(Order.DESCENDANT, columnName);
    }

    public static OrderBy custom(Order order, String columnName) {
        return new OrderBy(order, columnName);
    }

    @Override
    public String toString() {
        return order.value + " " + column;
    }

    public enum Order {
        ASCENDANT("ASC"),
        DESCENDANT("DES");

        public final String value;

        Order(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
