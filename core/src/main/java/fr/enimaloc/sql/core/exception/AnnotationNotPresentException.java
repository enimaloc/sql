package fr.enimaloc.sql.core.exception;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Parameter;

public class AnnotationNotPresentException extends Exception {

    public AnnotationNotPresentException() {
        super();
    }

    public AnnotationNotPresentException(Class<? extends Annotation> annotation, Class<?> clazz) {
        this(annotation.getName() + " expected in " + clazz.getName() + " class");
    }

    public AnnotationNotPresentException(Class<? extends Annotation> annotation, Field field) {
        this(annotation.getName() + " expected on " + field.getName() + " in " + field.getClass().getName() +
             " class");
    }

    public AnnotationNotPresentException(Class<? extends Annotation> annotation, Parameter parameter) {
        this(annotation.getName() + " expected on " + parameter.getName() + " on " +
             parameter.getDeclaringExecutable().getName() + " in " + parameter.getClass().getName());
    }

    public AnnotationNotPresentException(String message) {
        super(message);
    }

    public AnnotationNotPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnnotationNotPresentException(Throwable cause) {
        super(cause);
    }
}
