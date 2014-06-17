

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
    
    /**
     * Methode die een node terug geeft met het volgende vakje.
     * @return Geeft de node terug waar het volgende vakje in zit.
     */
    public Node getNextNode(){
        return getNextNode(this);
    }
    
    /**
     * Recursieve methode die de parent terug blijft geven totdat die deze niet meer heeft en dan geeft die zichzelf terug.
     * @param node De node waarmee moet worden gestart.
     * @return De node waar het volgende vakje in zit.
     */
    private Node getNextNode(Node node){
        if(node.getParent().getParent() != null){
            return getNextNode(node.getParent());
        }else{
            return node;
        }       
    }
}
