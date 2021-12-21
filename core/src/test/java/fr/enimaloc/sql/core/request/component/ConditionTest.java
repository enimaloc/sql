package fr.enimaloc.sql.core.request.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionTest {

    @Test
    void eq() {
        assertEquals("column = a", Condition.eq("column", "a").toString());
    }

    @Test
    void neq() {
        assertEquals("column != a", Condition.neq("column", "a").toString());
    }

    @Test
    void more() {
        assertEquals("column > a", Condition.more("column", "a").toString());
    }

    @Test
    void less() {
        assertEquals("column < a", Condition.less("column", "a").toString());
    }

    @Test
    void moreOrEq() {
        assertEquals("column >= a", Condition.moreOrEq("column", "a").toString());
    }

    @Test
    void lessOrEq() {
        assertEquals("column <= a", Condition.lessOrEq("column", "a").toString());
    }

    @Test
    void in() {
        assertEquals("column IN a", Condition.in("column", "a").toString());
    }

    @Test
    void between() {
        assertEquals("column BETWEEN a", Condition.between("column", "a").toString());
    }

    @Test
    void like() {
        assertEquals("column LIKE a", Condition.like("column", "a").toString());
    }

    @Test
    void isNull() {
        assertEquals("column IS NULL", Condition.isNull("column").toString());
    }

    @Test
    void notNull() {
        assertEquals("column IS NOT NULL", Condition.notNull("column").toString());
    }

    @Test
    void and() {
        assertEquals("column IS NOT NULL AND column = a", Condition.notNull("column")
                                                                   .and()
                                                                   .eq("column", "a")
                                                                   .toString());
    }

    @Test
    void or() {
        assertEquals("column IS NULL OR column != a", Condition.isNull("column")
                                                               .or()
                                                               .neq("column", "a")
                                                               .toString());
    }
}