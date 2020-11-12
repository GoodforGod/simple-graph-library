package graph.library.graph;

import graph.library.model.Vertex;
import graph.library.model.impl.IndirectEdge;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface IndirectGraph<V extends Vertex>
        extends Graph<V, IndirectEdge<V>> {
}
