package graph.library.model.impl;

import graph.library.model.Edge;
import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public class Path<V extends Vertex, E extends Edge<V>> {

    private final List<E> edges;

    public Path(@NotNull List<E> edges) {
        this.edges = edges;
    }

    public @NotNull List<E> getEdges() {
        return edges;
    }
}
