package graph.library.model.impl;

import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public class DirectEdge<V extends Vertex> extends UndirectEdge<V> {

    public DirectEdge(@NotNull V from, @NotNull V to) {
        super(from, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DirectEdge<?> that = (DirectEdge<?>) o;
        return getFrom().equals(that.getFrom()) && getTo().equals(that.getTo());
    }
}
