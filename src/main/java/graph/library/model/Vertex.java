package graph.library.model;

import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface Vertex<T extends Comparable<T>> extends Comparable<Vertex<T>> {

    @NotNull
    T getId();

    @Override
    default int compareTo(@NotNull Vertex<T> o) {
        return getId().compareTo(o.getId());
    }
}
