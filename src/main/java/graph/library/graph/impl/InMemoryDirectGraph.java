package graph.library.graph.impl;

import graph.library.graph.DirectGraph;
import graph.library.model.Vertex;
import graph.library.model.impl.DirectEdge;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public abstract class InMemoryDirectGraph<V extends Vertex, E extends DirectEdge<V>>
        extends InMemoryGraph<V, E>
        implements DirectGraph<V, E> {

    @Override
    public boolean addVertex(@NotNull V vertex) {
        return addVertexToGraph(vertex);
    }

    @Override
    public boolean addEdge(@NotNull V from, @NotNull V to) {
        return addEdgeToGraph(from, to);
    }

    @Override
    public @NotNull List<E> getPath(@NotNull V from, @NotNull V to) {
        return getDirectPath(from, to);
    }
}
