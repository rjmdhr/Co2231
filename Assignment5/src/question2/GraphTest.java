/*****************************************************************************/
//  GraphTest.java
//  Rajdeep Mudhar T00674224
//  COMP 2231 Assignment 5 Question 2
//  This class tests the methods that were completed in Graph.java as per the
//  the programming assignment requirements
/*****************************************************************************/

package question2;

public class GraphTest 
{
    public static void main(String[] args) 
    {
        // create new empty graph
        Graph<String> graph = new Graph<String>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        // test various methods on graph
        System.out.println("\nGRAPH TEST (Adding 4 String letters) (A-D)");
        
        // add edge to A,B and C,D
        System.out.println("*Adding A,B edge and C,D edge*\n");
        graph.addEdge("A", "B");
        graph.addEdge(2, 3);
        System.out.print(graph.toString());
        
        // remove C,D edge
        System.out.println("*Removing C and D edge*\n");
        graph.removeEdge("C","D");
        System.out.print(graph.toString());

        // remove vertex A and B
        System.out.println("*Removing vertex A and B\n");
        graph.removeVertex("A");
        graph.removeVertex(0); //should be B after A is removed
        System.out.print(graph.toString());

        // test accessor methods
        System.out.println("Size: " + graph.size());
        System.out.println("isEmpty: " + graph.isEmpty());
        System.out.println("isConnected: " + graph.isConnected());

        //Add E and attempt to make graph connected
        System.out.println("\n*Adding vertex E and connect graph*\n");
        graph.addEdge("C", "D");
        graph.addVertex("E");
        graph.addEdge("D", "E");

        System.out.print(graph.toString());
        System.out.println("Size: " + graph.size());
        System.out.println("isConnected: " + graph.isConnected());
        System.out.println("numVertices: " + graph.numVertices);
    }    
}
