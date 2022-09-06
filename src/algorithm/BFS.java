package algorithm;

import java.util.ArrayDeque;
import java.util.Set;

import org.w3c.dom.Node;

public class BFS {

    public int BFS(Node start, Node target) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        Set<Node> visited;
        int step = 0;
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()){
            int currentLevelSize = queue.size();
            // Traverse current level nodes
            for(int i = 0; i < currentLevelSize; i++){
                Node cur = queue.poll();
                if (cur == target) return step;
                // add the neighbors of current node to queue and visited set
                for(Node x: cur.adj()){
                    if (!visited.contains(x)){
                        visited.add(x);
                        queue.offer(x);
                    }
                }

            }
            // note: add step after finishing current level traversal
            step++;
        }

    }
}
