package graph.library;

import graph.library.model.Edge;
import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface Graph<V extends Vertex, E extends Edge<V>> {

    void addVertex(@NotNull V vertex);

    void addEdge(@NotNull V v1, @NotNull V v2);

    @NotNull
    List<E> getPath(@NotNull V v1, @NotNull V v2);
}
