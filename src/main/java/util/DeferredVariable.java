package util;

import java.util.function.Supplier;

public class DeferredVariable<T> implements Supplier<T> {
    public T value;
    public Supplier<T> supplier;

    public DeferredVariable(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public T get() {
        if (value == null) {
            value = supplier.get();
        }
        return value;
    }
}