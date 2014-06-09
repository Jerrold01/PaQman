

package projectpaqman;

/**
 *
 * @author remcoruijsenaars
 */
public class Node {
    
    private Vakje data;
    private Node parent;
    
    public Node(Vakje data){
        this.data = data;
        parent = null;
    }
    
    public Vakje getData(){
        return data;
    }
    
    public Node getParent(){
        return parent;
    }
            
    public void setParent(Node parent){
        this.parent = parent;
    }
    
    public Node getNextNode(){
        return getNextNode(this);
    }
    
    private Node getNextNode(Node node){
        if(node.getParent().getParent() != null){
            return getNextNode(node.getParent());
        }else{
            return node;
        }       
    }
}
