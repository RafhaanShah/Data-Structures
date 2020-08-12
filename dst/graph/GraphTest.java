package dst.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GraphTest {

    private Graph<Integer> graph;

    @BeforeEach
    public void setup() {
        graph = new Graph<>();
    }

    @Test
    public void addVertex_onEmptyGraph() {
        Integer a = Integer.valueOf(1);

        graph.addVertex(a);

        assertEquals(1, graph.size());
    }

    @Test
    public void addEdge_onEmptyGraph() {
        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(2);

        graph.addEdge(a, b);

        assertTrue(graph.isAdjacent(a, b));
        assertEquals(2, graph.size());
        assertEquals(a, graph.getNeighbours(b).get(0));
        assertEquals(b, graph.getNeighbours(a).get(0));
    }

    @Test
    public void removeVertex() {
        Integer a = Integer.valueOf(1);

        graph.addVertex(a);
        graph.removeVertex(a);

        assertEquals(0, graph.size());
    }

    @Test
    public void removeEdge() {
        Integer a = Integer.valueOf(1);
        Integer b = Integer.valueOf(2);

        graph.addEdge(a, b);
        graph.removeEdge(a, b);

        assertFalse(graph.isAdjacent(a, b));
        assertEquals(0, graph.getNeighbours(b).size());
        assertEquals(0, graph.getNeighbours(a).size());
    }

}
