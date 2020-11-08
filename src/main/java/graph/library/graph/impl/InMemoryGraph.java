package graph.library.graph.impl;

import graph.library.model.Edge;
import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
abstract class InMemoryGraph<V extends Vertex, E extends Edge<V>> {

    final Map<V, Set<V>> graph = new ConcurrentHashMap<>();

    boolean addVertexToGraph(@NotNull V vertex) {
        return graph.putIfAbsent(vertex, Collections.emptySet()) == null;
    }

    boolean addEdgeToGraph(@NotNull V from, @NotNull V to) {
        final Set<V> toVertices = graph.computeIfPresent(from, (k, v) -> {
            if (graph.containsKey(to)) {
                final Set<V> edges = v.isEmpty() ? new HashSet<>() : v;
                edges.add(to);
                return edges;
            } else {
                return v;
            }
        });

        return toVertices != null && toVertices.contains(to);
    }

    @NotNull
    List<E> getDirectPath(@NotNull V from, @NotNull V to) {
        return Collections.emptyList();
    }
}
