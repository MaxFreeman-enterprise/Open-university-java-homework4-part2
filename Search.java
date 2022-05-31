/**
 * Write a description of howmework_part2 here:
 * 
 *the search method
* checks whether a given number is found inside a given rotationally sorted array
* @param mat - the rotationally sorted array
* @param num - a given number
* @return true - iff the given number is inside the rotationally sorted array & and if the array is rotationally sorted array
* time complexity = O(log n) - similar to binary search.
* space complexity = O(1) - constant number of variables.
 *
 * @author Max Freeman
 * @version 15.01.22
 */
public class Search
{
    
    public static boolean search (int[][] mat, int num) {
        int n = mat.length;
        if (num<mat[0][0] || num>mat[n-1][0])  
            return false; //check whether the given number is inside the range of the array
        int row=0;
        int col=0;

        while(n>1) {
            int maxSquare1 = mat[n/2-1+row][col];
            int maxSquare2 = mat[n/2-1+row][n/2+col];
            int maxSquare3 = mat[n-1+row][n/2+col];
            int maxSquare4 = mat[n-1+col][col];
            
            if (num>maxSquare2)
                if(num>maxSquare3) { //belongs to square 4
                    row += n/2;
                }
                else {  //belongs to square 3
                    row += n/2;
                    col += n/2;
                }
            else {
                if(num>maxSquare1) { //belongs to square 2
                    col += n/2;
                }
                //belongs to square 1, row and col should not change
            }
            n=n/2;
        }
        if(num == mat[row][col])
            return true;
        return false;
    }
}
