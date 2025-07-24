package DivideAndConque.q427;

class Solution {
    public Node construct(int[][] grid) {

        return divideAndConquer(grid, 0, 0, grid.length);



    }

    public Node divideAndConquer(int[][] grid, int i,int j,int length){
        if(length==1){
            return new Node(grid[i][j]==1,true,null,null,null,null);
        }
        Node topLeft = divideAndConquer(grid, i, j, length/2);
        Node topRight = divideAndConquer(grid, i, j+length/2, length/2);
        Node bottomLeft = divideAndConquer(grid, i+length/2, j, length/2);
        Node bottomRight = divideAndConquer(grid, i+length/2, j+length/2, length/2);

        Node root = new Node();
        if(topLeft.isLeaf&&topLeft.val&&topRight.isLeaf&&topRight.val&&bottomLeft.isLeaf&&bottomLeft.val&&bottomRight.isLeaf&&bottomRight.val){
            root.isLeaf = true;
            root.val = true;

        }else if(topLeft.isLeaf&&!topLeft.val&&topRight.isLeaf&&!topRight.val&&bottomLeft.isLeaf&&!bottomLeft.val&&bottomRight.isLeaf&&!bottomRight.val)
        {
            root.isLeaf = true;
            root.val = false;
        }else{
            root.isLeaf = false;
            root.val = true;
            root.topLeft = topLeft;
            root.topRight = topRight;
            root.bottomLeft = bottomLeft;
            root.bottomRight = bottomRight;
        }


        return root;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{1,1,0,0},{0,0,1,1},{1,1,0,0},{0,0,1,1}};
        Node root = solution.construct(grid);
        System.out.println(root);
    }
}