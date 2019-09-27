//  Common Ancestor in a Binary Tree 
import java.util.ArrayList; 
import java.util.List; 
  
// make BT node 
class Node { 
    int data; 
    Node leftNode, rightNode; 
  
    Node(int nodeValue) { 
        data = nodeValue; 
        leftNode = rightNode = null; 
    } 
} 
public class LowestCommonAncestor {
	Node LCAroot; 
    private List<Integer> p1 = new ArrayList<>(); 
    private List<Integer> p2 = new ArrayList<>(); 
  
    // Find path from root node to given root of tree. 
    int findLowestCommonAncestor(int node1, int node2) { 
    	p1.clear(); 
    	p2.clear(); 
        return findLCA(LCAroot, node1, node2); 
    } 
  
    private int findLCA(Node LCAroot, int node1, int node2) { 
  
        if (!findPath(LCAroot, node1, p1) || !findPath(LCAroot, node2, p2)) { 
            System.out.println((p1.size() > 0) ? "node1 is present" : "node1 is missing"); 
            System.out.println((p2.size() > 0) ? "node2 is present" : "node2 is missing"); 
            return -1; 
        } 
  
        int index; 
        for (index = 0; index < p1.size() && index < p2.size(); index++) {  
            if (!p1.get(index).equals(p2.get(index))) 
                break; 
        } 
  
        return p1.get(index-1); 
    } 
      
    // Find path from root node to given root of tree
    // Stores path in vector path[]
    // Return true if path exists, otherwise return false 
    private boolean findPath(Node root, int node, List<Integer> pathList) 
    { 
        // if no path return false
        if (root == null) { 
            return false; 
        } 
          
        // Stores node
        // Node deleted if not in path from root to n. 
        pathList.add(root.data); 
  
        if (root.data == node) { 
            return true; 
        } 
  
        if (root.leftNode != null && findPath(root.leftNode, node, pathList)) { 
            return true; 
        } 
  
        if (root.rightNode != null && findPath(root.rightNode, node, pathList)) { 
            return true; 
        } 
  
        // If not present in subtree rooted with root, remove root from 
        // path[] and return false 
        pathList.remove(pathList.size()-1); 
  
        return false; 
    } 
}
