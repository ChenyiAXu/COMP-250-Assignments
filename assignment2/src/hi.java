public class hi {
  boolean isBST( node root){
        if(root == null){
            return true;
        }
        if(root.left != null && findmax(root.left) > root){
            return false;

        }
        if(root.right != null && findmin(root.right) < root){
            return false;
        }
        isBST(root.left);
        isBST(root.right);
        return true;
    }

}
