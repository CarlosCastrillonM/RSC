package util;

import java.util.function.Function;

public interface SafeFunction<T, R> extends Function<T, R> {
    @Override
    default R apply(T t) {
        try {
            return applySafe(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    R applySafe(T t) throws Exception;
}