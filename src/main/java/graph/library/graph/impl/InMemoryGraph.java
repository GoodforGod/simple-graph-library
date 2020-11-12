package graph.library.graph.impl;

import graph.library.model.Edge;
import graph.library.model.Vertex;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

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

    void traverseGraph(Consumer<V> function) {
        graph.keySet().forEach(function);
    }

    @NotNull
    List<E> getDirectPath(@NotNull V from, @NotNull V to) {
        final Set<V> init = graph.get(from);
        if (init == null || init.isEmpty())
            return Collections.emptyList();

        if (init.contains(to))
            return List.of(getEdge(from, to));

        final Set<V> visited = new HashSet<>();
        visited.add(from);

        final List<V> path = findPath(from, visited, init, to);
        if (path.isEmpty())
            return Collections.emptyList();

        final List<E> edges = new ArrayList<>(path.size() - 1);
        for (int i = 1; i < path.size(); i++)
            edges.add(getEdge(path.get(i - 1), path.get(i)));

        return edges;
    }

    private @NotNull List<V> findPath(V from, Set<V> visited, Set<V> lookup, V target) {
        for (V v : lookup) {
            if (!visited.contains(v)) {
                visited.add(v);
                final Set<V> vs = graph.get(v);
                if (vs.contains(target)) {
                    final LinkedList<V> path = new LinkedList<>();
                    path.add(from);
                    path.add(v);
                    path.add(target);
                    return path;
                } else {
                    final List<V> found = findPath(v, visited, vs, target);
                    if (!found.isEmpty() && found instanceof LinkedList) {
                        ((LinkedList<V>) found).addFirst(from);
                        return found;
                    }
                }
            }
        }

        return Collections.emptyList();
    }

    abstract E getEdge(@NotNull V from, @NotNull V to);
}
