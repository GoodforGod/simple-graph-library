package graph.library.model;

import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface Vertex<T> {

    @NotNull
    T getId();
}
