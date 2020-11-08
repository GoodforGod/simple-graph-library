package graph.library.model.impl;

import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public class IntVertex implements Vertex<Integer> {

    private final int value;

    public IntVertex(int value) {
        this.value = value;
    }

    public @NotNull Integer getId() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        IntVertex intVertex = (IntVertex) o;
        return value == intVertex.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
