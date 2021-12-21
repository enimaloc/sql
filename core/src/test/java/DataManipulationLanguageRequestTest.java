import fr.enimaloc.sql.core.annotation.Column;
import fr.enimaloc.sql.core.annotation.Table;
import fr.enimaloc.sql.core.exception.AnnotationNotPresentException;
import fr.enimaloc.sql.core.request.DataManipulationLanguageRequest;
import fr.enimaloc.sql.core.request.component.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataManipulationLanguageRequestTest {

    @Nested
    class SelectTest {

        @Nested
        @DisplayName("simple")
        class SimpleTest {
            @Test
            void strings() {
                assertEquals(
                        "SELECT * FROM sample",
                        DataManipulationLanguageRequest.select("sample")
                                                       .toString()
                );
            }

            @Test
            void table() {
                assertEquals(
                        "SELECT * FROM sample",
                        assertDoesNotThrow(() -> DataManipulationLanguageRequest.select(SampleTable.class).toString())
                );
            }

            @Test
            void noTable() {
                assertThrows(
                        AnnotationNotPresentException.class,
                        () -> DataManipulationLanguageRequest.select(SampleNoTable.class)
                );
            }
        }

        @Nested
        @DisplayName("complex")
        class ComplexTest {
            @Test
            void column() {
                assertEquals(
                        "SELECT nickname FROM sample",
                        DataManipulationLanguageRequest.select("sample")
                                                       .columnsName("nickname")
                                                       .toString()
                );
            }

            @Test
            void where() {
                assertEquals(
                        "SELECT * FROM sample WHERE nickname = enimaloc",
                        DataManipulationLanguageRequest.select("sample")
                                                       .where(() -> Condition.eq("nickname", "enimaloc"))
                                                       .toString()
                );
            }

            @Test
            void group() {
                assertEquals(
                        "SELECT * FROM sample GROUP BY nickname",
                        DataManipulationLanguageRequest.select("sample")
                                                       .group("nickname")
                                                       .toString()
                );
            }
        }

        @Table(name = "sample")
        class SampleTable {
            @Column(columnName = "nickname")
            public String nickname;
            @Column(columnName = "age")
            public int age;
        }
        class SampleNoTable {}
    }
}