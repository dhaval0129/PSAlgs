/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.array;

/**
 *
 * @author djoshi
 */
public class MatrixSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[][] = { {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 9, 2, -4, -4, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, -1, -2, -4, 0 }
                      };
        int max = 0;
        
        for(int r=0; r<4;r++) {
            for(int c=0; c<4; c++) {
                int sum = 0;

                for(int i=r; i<r+3;i++) {
                    for(int j=c; j<c+3; j++) {
                        
                        if( !(i == r+1 && j == c) && !(i == r+1 && j == c+2)  ) {
                            sum += arr[i][j];
                        }
                    }
                }

                if(sum > max) {
                    max = sum;
                }
                
            }
        }
        
        System.out.println(max);
    }
    
}
