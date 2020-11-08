package graph.library.graph;

import graph.library.model.Vertex;
import graph.library.model.impl.UndirectEdge;

/**
 * @author Anton Kurako (GoodforGod)
 * @since 8.11.2020
 */
public interface UndirectGraph<V extends Vertex>
        extends Graph<V, UndirectEdge<V>> {
}
