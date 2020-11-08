package graph.library.graph.impl;

import graph.library.graph.DirectGraph;
import graph.library.model.Vertex;
import graph.library.model.impl.DirectEdge;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public abstract class InMemoryDirectGraph<V extends Vertex>
        extends InMemoryGraph<V, DirectEdge<V>>
        implements DirectGraph<V> {

    @Override
    public boolean addVertex(@NotNull V vertex) {
        return addVertexToGraph(vertex);
    }

    @Override
    public boolean addEdge(@NotNull V from, @NotNull V to) {
        return addEdgeToGraph(from, to);
    }

    @Override
    public void traverse(Consumer<V> function) {
        traverseGraph(function);
    }

    @Override
    public @NotNull List<DirectEdge<V>> getPath(@NotNull V from, @NotNull V to) {
        return getDirectPath(from, to);
    }

    @Override
    DirectEdge<V> getEdge(@NotNull V from, @NotNull V to) {
        return new DirectEdge<>(from, to);
    }
}
