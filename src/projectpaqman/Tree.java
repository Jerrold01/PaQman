

package projectpaqman;

/**
 *
 * @author remcoruijsenaars
 */
public class Tree {
    
    private Node root;
    
    public Tree(Node root){
        this.root = root;
    }
    
    public int size(){

        if(root == null){
            return 0;
        }else{
            return root.getSize();
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
    
    public void addSubTree(Tree subTree){
        root.getChildren().add(subTree.getRoot());
    }
    
    public void addNodeToRoot(Node node){
        root.getChildren().add(node);
    }
    
    
    @Override
    public String toString(){
        return root.toString();
    }

}
