package matrixadt;
/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 * 
 * @author Nikita Bahl, Ruben Acuna
 * @version (version)
 */
public class BahlMatrix implements Matrix {
    
    //TODO: implement interface.
    public final int m[][];
    
    //constructor to initialize m[][] with the values passed through matrix[][]
    BahlMatrix (int matrix[][])
    {
        int r = matrix.length;
        int c;
        if (r ==0 )
        {
            c = 0;
        }
        else
        {
         c = matrix[0].length;
        }
        
        m = new int[r][c];
        
        for ( int i=0 ; i< r ; i++ )
            for ( int j = 0; j< c ; j++)
            {
                m[i][j] = matrix[i][j];
            }
    }
    
    /**
     * Returns the element at particular point in the matrix.
     * @param y y position
     * @param x x position
     * @return element
     */
    @Override
    public int getElement(int y, int x)
    {
        return this.m[x][y];
    }
    
    /**
     * Returns the number of rows in the matrix.
     * @return rows
     */
    @Override
    public int getRows()
    {
        return this.m.length;
    }
    
    /**
     * Returns the number of columns in the matrix.
     * @return columns
     */
    @Override
    public int getColumns()
    {
        int r = m.length;
        int c;
        if (r ==0 )
        {
            c = 0;
        }
        else
        {
         c = m[0].length;
        }
        return c;
    }
    
     /**
     * Returns this matrix scaled by a factor. That is, computes kA where k is a
     * constant and A is a matrix (this object).
     * 
     * @param scalar scalar
     * @return matrix
     */
    @Override
    public Matrix scale(int scalar)
    {
        int result[][] = new int[this.getRows()][this.getColumns()];
        for (int i = 0; i< this.getRows(); i++){
            for(int j =0; j< this.getColumns(); j++)
            {
                result[i][j] = scalar * this.m[i][j];
            }
        }
        return new BahlMatrix(result);
        
    }
    
    /**
     *  Returns this matrix added with another matrix. That is, computes A+B 
     *  where A and B are matrices (this object, and another respectively).
     * @param other addend
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions.
     */
    public Matrix plus(Matrix other)
    {
        
        int otherRow = other.getRows();
        int otherCol = other.getColumns();
        int result[][] = new int[otherRow][otherCol];
        
        if ((this.getRows() != otherRow) && (this.getColumns()!= otherCol))
        {
         throw new RuntimeException("Mismatch in index of the provided matrices");   
        }
        else 
        {
            for (int i = 0; i< this.getRows(); i++){
                for(int j =0; j< this.getColumns(); j++)
                {
                    result[i][j] = this.m[i][j] + other.getElement(j, i);
                }
            }
            //throw new RuntimeException("Mismatch in index of the provided matrices");
        }
        return new BahlMatrix(result);
    
    }
    
    /**
     * Returns this matrix subtracted by another matrix. That is, computes A-B 
     *  where A and B are matrices (this object, and another respectively).
     * @param other subtrahend
     * @return matrix
     * @throws RuntimeException if matrices do not have matching dimensions.
     */
    public Matrix minus(Matrix other)
    {
        int otherRow = other.getRows();
        int otherCol = other.getColumns();
        int result[][] = new int[otherRow][otherCol];
        
        //check for number of rows and columns to be equal
        if ((this.getRows() == otherRow) && (this.getColumns()== otherCol))
        {
            
        for (int i = 0; i< this.getRows(); i++)
            for(int j =0; j< this.getColumns(); j++)
            {
                result[i][j] = this.m[i][j] - other.getElement(j, i);
            }
        }
        else 
        {
            throw new RuntimeException("Mismatch in index of the provided matrices");
        }
        return new BahlMatrix(result);
    }
    
    /**
     * Returns true if this matrix matches another matrix.
     * @param other another matrix
     * @return equality
     */
    @Override
    public boolean equals(Object other)
    {
        if (other instanceof BahlMatrix)
       {
        BahlMatrix otherCopy = (BahlMatrix)other;    
        
        int otherRow = otherCopy.getRows();
        int otherCol = otherCopy.getColumns();
        boolean check = false;

        if ((this.getRows() == otherRow) && (this.getColumns()== otherCol))
        {
            for (int i = 0; i < otherRow; i++)
            {
                for (int j = 0; j < otherCol; j++)
                {
                    if (this.getElement(j, i) != otherCopy.getElement(j, i))
                    {
                        check = false;
                        break;
                    }
                    else
                    {
                        check = true;
                    }
                }
                if (check == false)
                    
                {
                    break;
                }
            }
        }
        return check;
       }
        else
        {
            return false;
        }
    }
    
   /**
     * Returns a string representation of this matrix. A new line character will
     * separate each row, while a space will separate each column.
     * @return string representation
     */
    @Override
    public String toString()
    {
        int r = this.getRows();
        int c = this.getColumns();
        String result = "";
          
        for (int i = 0; i< this.getRows(); i++)
        {
            for(int j =0; j< this.getColumns(); j++)
            {
                result = result + " " + this.getElement(j, i);
            }
            result = result + System.lineSeparator();
    }
        return result;
    }
    
    /**
     * Entry point for matrix testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        
        Matrix m1 = new BahlMatrix(data1);
        Matrix m2 = new BahlMatrix(data2);
        Matrix m3 = new BahlMatrix(data3);
        Matrix m4 = new BahlMatrix(data4);
        
        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());
        
        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true
        
        //test operations (valid)
//        System.out.println("2 * m2:\n" + m2.scale(2));
//        System.out.println("m2 + m3:\n" + m2.plus(m3));
//        System.out.println("m2 - m3:\n" + m2.minus(m3));
        
        //test operations (invalid)
        System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }
}
