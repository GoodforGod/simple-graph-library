package graph.library.model;

import org.jetbrains.annotations.NotNull;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface Edge<V extends Vertex> {

    @NotNull
    V from();

    @NotNull
    V to();
}
