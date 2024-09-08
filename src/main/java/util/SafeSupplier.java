package util;

import java.util.function.Supplier;

public interface SafeSupplier<T> extends Supplier<T> {
    @Override
    default T get() {
        try {
            return getSafe();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    T getSafe() throws Exception;
}