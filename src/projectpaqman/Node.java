

package projectpaqman;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author remcoruijsenaars
 */
public class Node {
    
    private Object data;
    private List<Node> childs;
    
    public Node(Object data){
        this.data = data;
        childs =  new ArrayList();
    }
    
    public int getSize(){
        int sum = 0;
        for(Node node: childs){
            sum = sum + node.getSize();
        }
        return sum + 1;
    }

    public void addChildNode(Node node){
        childs.add(node);
    }
    
    public List<Node> getChildren() {
        return childs;
    }

    public void setChildren(List<Node> children) {
        this.childs = children;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
    public String toStringHelp(int diepte){
        String returner = "";
        for(int i=0; i< diepte; i++){
            returner+="\t";
        }
        returner +=  "Node " + data.toString() + "\n";
        
        if(childs.size() > 0){
            for(Node node: childs){
                returner += node.toStringHelp(diepte+1);
            }
        }
        return returner;
    }
    
    
    @Override
    public String toString(){
        return toStringHelp(0);
    }
}
