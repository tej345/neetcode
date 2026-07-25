public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        convertToString(root, sb);
        return sb.toString();
    }

    private void convertToString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        convertToString(root.left, sb);
        convertToString(root.right, sb);
    }
    public TreeNode deserialize(String data) {
        Queue <String> node = new LinkedList<>(Arrays.asList(data.split(",")));
        return convertToTree(node);
    }

    private TreeNode convertToTree(Queue <String> node){
        String val = node.poll();

        if(val.equals("null")){
            return null;
        }

        TreeNode base = new TreeNode(Integer.parseInt(val));
        base.left = convertToTree(node);
        base.right = convertToTree(node);

        return base;
    }
}
