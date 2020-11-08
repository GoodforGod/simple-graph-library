package graph.library.graph.impl;

import graph.library.graph.UndirectGraph;
import graph.library.model.Vertex;
import graph.library.model.impl.UndirectEdge;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public abstract class InMemoryUndirectGraph<V extends Vertex>
        extends InMemoryGraph<V, UndirectEdge<V>>
        implements UndirectGraph<V> {

    @Override
    public boolean addVertex(@NotNull V vertex) {
        return addVertexToGraph(vertex);
    }

    @Override
    public boolean addEdge(@NotNull V from, @NotNull V to) {
        final boolean haveVertices = graph.containsKey(from) && graph.containsKey(to);
        if (!haveVertices)
            return false;

        synchronized (this) {
            return super.addEdgeToGraph(from, to) && super.addEdgeToGraph(to, from);
        }
    }

    @Override
    public void traverse(Consumer<V> function) {
        traverseGraph(function);
    }

    @Override
    public @NotNull List<UndirectEdge<V>> getPath(@NotNull V from, @NotNull V to) {
        return getDirectPath(from, to);
    }

    @Override
    UndirectEdge<V> getEdge(@NotNull V from, @NotNull V to) {
        return new UndirectEdge<>(from, to);
    }
}
