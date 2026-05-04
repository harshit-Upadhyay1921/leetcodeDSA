class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=0;i<row-1;i++){
            for(int j=i+1;j<col;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        int i=0;
        int j=col-1;
        while(i<j){
            for(int idx=0;idx<row;idx++){
                int temp = matrix[idx][i];
                matrix[idx][i] = matrix[idx][j];
                matrix[idx][j] = temp;
            }
            i++;
            j--;
        }

    }
}