package graphs;

import java.util.ArrayList;

/**
 * 
 * @author nikhil pankil
 * 
 */
final class Edge {

        private GraphNode node;
        private Double cost;

        public Edge(GraphNode nodeTo, Double cost) {
                this.node = nodeTo;
                this.cost = cost;
        }
        /**
        * 
        * @return
        */
        public GraphNode getNode() {
                return node;
        }
        /**
        * 
        * @return
        */
        public Double getCost() {
                return cost;
        }
}

/**
 * @author nikhil pankil
 */
