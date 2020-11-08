package graph.library;

import graph.library.graph.impl.IntDirectGraph;
import graph.library.model.impl.IntVertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author GoodforGod
 * @since 13.11.2019
 */
class IntDirectGraphTests extends Assertions {

    @Test
    void addVertexSuccess() {
        final IntDirectGraph graph = new IntDirectGraph();
        final IntVertex vertex = new IntVertex(1);
        assertTrue(graph.addVertex(vertex));
    }

    @Test
    void addVertexDuplicateFail() {
        final IntDirectGraph graph = new IntDirectGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(1);
        assertTrue(graph.addVertex(v1));
        assertFalse(graph.addVertex(v2));
    }

    @Test
    void addEdgeSuccess() {
        final IntDirectGraph graph = new IntDirectGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(2);
        assertTrue(graph.addVertex(v1));
        assertTrue(graph.addVertex(v2));
        assertTrue(graph.addEdge(v1, v2));
    }

    @Test
    void addEdgeNonExistEdgeFail() {
        final IntDirectGraph graph = new IntDirectGraph();
        final IntVertex v1 = new IntVertex(1);
        final IntVertex v2 = new IntVertex(2);
        assertTrue(graph.addVertex(v1));
        assertFalse(graph.addEdge(v1, v2));
    }

    @Disabled
    @Test
    void getPathSuccess() {
        final IntDirectGraph graph = new IntDirectGraph();
        final IntVertex vertex = new IntVertex(1);
        assertTrue(graph.addVertex(vertex));
        fail();
    }

    @Disabled
    @Test
    void getPathNotFound() {
        final IntDirectGraph graph = new IntDirectGraph();
        final IntVertex vertex = new IntVertex(1);
        assertTrue(graph.addVertex(vertex));
        fail();
    }
}
