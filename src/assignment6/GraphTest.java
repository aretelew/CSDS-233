package assignment6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph();
    }

    @Test
    void testAddVertex() {
        assertTrue(graph.addVertex("A"));
        assertFalse(graph.addVertex("A"));
    }

    @Test
    void testAddEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        assertTrue(graph.addEdge("A", "B", 5));
        assertFalse(graph.addEdge("A", "B", 5)); // Duplicate edge
        assertFalse(graph.addEdge("A", "C", 5)); // Non-existent vertex
        assertFalse(graph.addEdge("A", "B", 0)); // Invalid weight
    }

    @Test
    void testAddEdges() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        String[] endIds = {"B", "C"};
        int[] weights = {5, 10};
        assertTrue(graph.addEdges("A", endIds, weights));
        assertFalse(graph.addEdges("A", endIds, new int[]{5})); // Mismatched lengths
        assertFalse(graph.addEdges("A", endIds, new int[]{5, 0})); // Invalid weight
    }

    @Test
    void testRemoveNode() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        assertTrue(graph.removeNode("A"));
        assertFalse(graph.containsVertex("A"));
        assertFalse(graph.containsEdge("A", "B"));
        assertFalse(graph.removeNode("A")); // Non-existent vertex
    }

    @Test
    void testRemoveEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        assertTrue(graph.removeEdge("A", "B"));
        assertFalse(graph.containsEdge("A", "B"));
        assertFalse(graph.removeEdge("A", "B")); // Non-existent edge
    }

    @Test
    void testCreateGraph() {
        String[][] input = {
            {"A", "B", "5"},
            {"B", "C", "10"},
            {"C", "A", "15"}
        };
        Graph createdGraph = Graph.createGraph(input);
        assertNotNull(createdGraph);
        assertTrue(createdGraph.containsVertex("A"));
        assertTrue(createdGraph.containsVertex("B"));
        assertTrue(createdGraph.containsVertex("C"));
        assertTrue(createdGraph.containsEdge("A", "B"));
        assertTrue(createdGraph.containsEdge("B", "C"));
        assertTrue(createdGraph.containsEdge("C", "A"));
    }

    @Test
    void testShortestDistance() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
        graph.addEdge("A", "C", 15);
        assertEquals(15, graph.shortestDistance("A", "C"));
        assertEquals(-1, graph.shortestDistance("A", "D")); // Non-existent vertex
    }

    @Test
    void testMinimumSpanningTree() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
        graph.addEdge("A", "C", 15);
        List<String[]> mst = graph.minimumSpanningTree();
        assertNotNull(mst);
        assertEquals(2, mst.size());
    }

    @Test
    void testPrintGraph() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 10);
        graph.addEdge("B", "C", 15);

        String expectedOutput =
                "A 5 B 10 C\n" +
                        "B 5 A 15 C\n" +
                        "C 10 A 15 B";

        expectedOutput = expectedOutput.replace("\n", System.lineSeparator());

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        graph.printGraph();
        System.setOut(System.out);

        String actualOutput = outContent.toString().trim().replace("\r\n", "\n").replace("\n", System.lineSeparator());

        assertEquals(expectedOutput, actualOutput);
    }

}