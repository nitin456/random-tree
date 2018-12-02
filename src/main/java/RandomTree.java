import java.util.LinkedList;

public class RandomTree {

    public static void main(String[] args) {
        if (args.length <2) {
            System.out.println("java RandomTree.java <depth> <degree>");
            System.exit(0);
        }

        int depth = Integer.parseInt(args[0]);
        int degree = Integer.parseInt(args[1]);

        int value = 0;
        int randomNum = ++value;//ThreadLocalRandom.current().nextInt(0, 1000000);
        TreeNode root = new TreeNode(randomNum);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        while (level < depth) {
            int size = queue.size();
            while (size > 0) {
                TreeNode parent = queue.pollFirst();
                for (int i=0; i<degree; i++) {
                    TreeNode child = new TreeNode(++value);
                    parent.addChild(child);
                    queue.add(child);
                }
                size -= 1;
            }
            level += 1;
        }

        for (int i=0; i<10; i++) {
            long start = System.nanoTime();
            TreeUtils.doDFS(root, false);
            System.out.println((System.nanoTime()-start)/1000.0);
        }
    }


}
