package graph.library;

import graph.library.model.impl.DirectEdge;
import graph.library.model.impl.IntVertex;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public class UndirectIntGraph implements UndirectGraph<IntVertex, DirectEdge<IntVertex>> {

    @Override
    public void addVertex(@NotNull IntVertex vertex) {

    }

    @Override
    public void addEdge(@NotNull IntVertex v1, @NotNull IntVertex v2) {

    }

    @Override
    public @NotNull List<DirectEdge<IntVertex>> getPath(@NotNull IntVertex v1, @NotNull IntVertex v2) {
        return Collections.emptyList();
    }
}
