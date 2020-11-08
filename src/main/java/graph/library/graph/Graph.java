package graph.library.graph;

import graph.library.model.Edge;
import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface Graph<V extends Vertex, E extends Edge<V>> {

    boolean addVertex(@NotNull V vertex);

    boolean addEdge(@NotNull V from, @NotNull V to);

    void traverse(Consumer<V> function);

    @NotNull
    List<E> getPath(@NotNull V from, @NotNull V to);
}
