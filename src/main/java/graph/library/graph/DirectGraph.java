package graph.library.graph;

import graph.library.model.Vertex;
import graph.library.model.impl.DirectEdge;

/**
 * @author GoodforGod
 * @since 13.11.2019
 */
public interface DirectGraph<V extends Vertex>
        extends Graph<V, DirectEdge<V>> {

}
