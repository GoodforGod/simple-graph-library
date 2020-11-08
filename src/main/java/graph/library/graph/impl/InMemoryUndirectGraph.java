package graph.library.graph.impl;

import graph.library.graph.UndirectGraph;
import graph.library.model.Vertex;
import graph.library.model.impl.UndirectEdge;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public abstract class InMemoryUndirectGraph<V extends Vertex, E extends UndirectEdge<V>>
        extends InMemoryGraph<V, E>
        implements UndirectGraph<V, E> {

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
    public @NotNull List<E> getPath(@NotNull V from, @NotNull V to) {
        return Collections.emptyList();
    }
}
