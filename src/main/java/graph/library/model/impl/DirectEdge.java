package graph.library.model.impl;

import graph.library.model.Edge;
import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public class DirectEdge<V extends Vertex> implements Edge<V> {

    private final V from;
    private final V to;

    public DirectEdge(@NotNull V from, @NotNull V to) {
        this.from = from;
        this.to = to;
    }

    public @NotNull V from() {
        return from;
    }

    public @NotNull V to() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DirectEdge<?> that = (DirectEdge<?>) o;
        return from.equals(that.from) &&
                to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
