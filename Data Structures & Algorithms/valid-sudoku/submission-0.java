class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean sudoku=true;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num=board[i][j];
                if(num=='.') continue;

                String row=num + " in row of " + i;
                String column =num + "in column of " +j;
                String box=num + " in box of " + (i/3) + "-" + (j/3);

                if(set.contains(row) || set.contains(column) || set.contains(box)){
                    sudoku=false;
                }
                set.add(row);
                set.add(column);
                set.add(box);
            }
        }
        return sudoku;
    }
}
