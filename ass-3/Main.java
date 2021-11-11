import java.io.IOException;
import java.util.*;
class Temp{
    // determinant 
    public static int deter(int mat[][], int n){
        int D = 0; 
        if (n == 1)
            return mat[0][0];
        int temp[][] = new int[n][n];
        int sign = 1;
        for (int f = 0; f < n; f++)
        {
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                 * deter(temp, n - 1);
            sign = -sign;
        }
        return D;
    }
    static void getCofactor(int mat[][], int temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                if (row != p && col != q)
                {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    // function to find transpose of matrix
    public static int[][] transpose(int[][] array, int arrayRows, int arrayColumns) {
        int[][] transposedArray = new int[arrayColumns][arrayRows]; //swap number of rows and columns
        
        for (int i = 0; i < transposedArray.length; i++) { //take the length of transposedArray, not array
            for (int j = 0; j < transposedArray[i].length; j++) { //take the length of transposedArray, not array
                transposedArray[i][j] = array[j][i];
                
            }
            
            
        }
        return transposedArray;
    }
    static boolean checksym(int transpose_matrix[][],
                        int matrix[][], int n, int m)
    {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] != transpose_matrix[i][j])
                    return false;
        return true;
    }
 
    // Utility function to check skew - symmetric
    // matrix condition
    static boolean check(int transpose_matrix[][],
                        int matrix[][], int n, int m)
    {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (matrix[i][j] != -transpose_matrix[i][j])
                    return false;
        return true;
    }
    // Function to check matrix is in
    // upper triangular form or not.
    public static Boolean isUpperTriangularMatrix(int mat[][])
    {
        for (int i = 1; i < mat.length ; i++)
            for (int j = 0; j < i; j++)
                if (mat[i][j] != 0)
                    return false;
        return true;
    }
    // Function to check matrix is
    // in lower triangular form or not.
    static boolean isLowerTriangularMatrix(int mat[][])
    {
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                if (j>i && mat[i][j] != 0)
                    return false;
 
        return true;
    }
    static boolean isDiagonalMatrix(int mat[][])
    {
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
      
                
                if ((i != j) && (mat[i][j] != 0))
                    return false;
 
        return true;
    }
    static boolean isScalarMatrix(int mat[][])
    {
        // Check all elements
        // except main diagonal are
        // zero or not.
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if ((i != j)
                  && (mat[i][j] != 0))
                    return false;
      
        // Check all diagonal elements
        // are same or not.
        for (int i = 0; i < mat.length - 1; i++)
            if (mat[i][i] != mat[i + 1][i + 1])
                return false;
        return true;
    }
    // function to print Identity Matrix
    static boolean identity(int[][] mat)
    {
        int flag=0;
        
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
            {
                // Checking if row is equal to column
                if (mat[i][j]==1 && i==j)
                    flag=0;
                else if(mat[i][j]==0 && (i>j || i<j))
                    flag=0;
                else 
                    flag=1;    
            }
        }
        if(flag==0)
        {
            return true;
        }
        return false;
    }
    // function to check ones
    static boolean ones(int[][] mat)
    {
        int flag=0;
        for(int i =0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                {
                    flag=0;
                }
                else{
                    flag=1;
                }
            }
        }
        if(flag==0)
        {
            return true;
        }
        return false;
    }
    static boolean zeros(int[][] mat)
    {
        int flag=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]!=0)
                {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        if(flag==1)
        {
            return false;
        }
        return true;
    }
    static int[][] add(int A[][], int B[][])
    {
        int i, j;
        int C[][] = new int[A.length][A[0].length];

        for (i = 0; i < A.length; i++)
            for (j = 0; j < A[0].length; j++)
                C[i][j] = A[i][j] + B[i][j];

        return C;
    }
    static int[][] sub(int A[][], int B[][])
    {
        int i, j;
        int C[][] = new int[A.length][A[0].length];

        for (i = 0; i < A.length; i++)
            for (j = 0; j < A[0].length; j++)
                C[i][j] = A[i][j] - B[i][j];

        return C;
    }
    static int[][] mul(int Mat1[][], int Mat2[][])
    {
        int i, j, k;
        int row1=Mat1.length;
        // int col1=Mat1[0].length;
        int row2=Mat2.length;
        int col2=Mat2[0].length;
        
 
        // Check if multiplication is Possible
        // if (row2 != col1) {
 
        //     System.out.println(
        //         "\nMultiplication Not Possible");
        //     return;
        // }
 
        // Matrix to store the result
        // The product matrix will
        // be of size row1 x col2
        int C[][] = new int[row1][col2];
 
        // Multiply the two matrices
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += Mat1[i][k] * Mat2[k][j];
            }
        }
        return C;
 
        
    }
    public static int[][] inv(int m[][])
    {
        int[][] temp=new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
               temp[i][j]=((m[(j+1)%3][(i+1)%3] * m[(j+2)%3][(i+2)%3]) - (m[(j+1)%3][(i+2)%3] * m[(j+2)%3][(i+1)%3]))/deter(m,3);}
        }
        return temp;
    }
    public static int[][] inv2(int mat[][],int det)
    {
        int temp = mat[0][0];
        mat[0][0] = mat[1][1];
        mat[1][1] = temp;
        mat[0][1] = - mat[0][1];
        mat[1][0] = - mat[1][0];
        mat[0][0]=mat[0][0]/det;
        mat[0][1]=mat[0][1]/det;
        mat[1][0]=mat[1][0]/det;
        mat[1][1]=mat[1][1]/det;
        return mat;
    }
    static int[][] Ele_mul(int Mat1[][], int Mat2[][])
    {
        
        int i, j;
        int C[][] = new int[Mat1.length][Mat1[0].length];

        for (i = 0; i < Mat1.length; i++)
            for (j = 0; j < Mat1[0].length; j++)
                C[i][j] = Mat1[i][j] * Mat2[i][j];

        return C;
        
    }
    static int[][] Ele_div(int Mat1[][], int Mat2[][])
    {
        
        int i, j;
        int C[][] = new int[Mat1.length][Mat1[0].length];

        for (i = 0; i < Mat1.length; i++)
            for (j = 0; j < Mat1[0].length; j++)
                C[i][j] = Mat1[i][j]/Mat2[i][j];

        return C;
        
    }
    // take input for matrix
    public static int[][] input(int n, int m)
    {
        int[][] arr1=new int[n][m];
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the elements: \n");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr1[i][j]=s.nextInt();
            }
        }
       
        return arr1;
    }
}


class Matrix{
    private int n;
    private int m;
    private int det=Integer.MIN_VALUE;
    private int id;
    private ArrayList<String> type = new ArrayList<>();
    private ArrayList<Integer> type_no=new ArrayList<>();
    private int[][] arr1;
    private int[][] trans_of_arr1;// transpose matrix
    private int[][] inverse_arr1;
    private int flag=0;
    public int D()
    {
        return det;
    }
    public int[][] A()
    {
        return arr1;
    }
    public ArrayList<String> B()
    {
        return type;
    }
    public int ret_id()
    {
        return id;
    }
    public int[][] Trans_A()
    {
        return trans_of_arr1;
    }
    public int[][] ret_inv()
    {
        return inverse_arr1;
    }
    public ArrayList<Integer> C()
    {
        return type_no;
    }
    public int[] row_sum()
    {
        int[] sum=new int[arr1.length];
        int sum1;
        for(int i = 0; i < arr1.length; i++){    
            sum1 = 0;    
            for(int j = 0; j < arr1[0].length; j++){    
              sum1= sum1 + arr1[i][j];    
            }
            sum[i]=sum1;
        }
        for(int i=0;i<sum.length;i++)
        {
            sum[i]=sum[i]/arr1[0].length;
        } 
        return sum;   
    }
    public int[] col_sum()
    {
        int[] sum=new int[arr1.length];
        int sum1;
        for(int i = 0; i < arr1[0].length; i++){    
            sum1 = 0;    
            for(int j = 0; j < arr1.length; j++){    
              sum1= sum1 + arr1[i][j];    
            }
            sum[i]=sum1;
        }
        for(int i=0;i<sum.length;i++)
        {
            sum[i]=sum[i]/arr1.length;
        } 
        return sum;   
    }
    public int whole_sum()
    {
        int sum=0;
        for(int i=0;i<arr1.length;i++)
        {
            for(int j=0;j<arr1[0].length;j++)
            {
                sum=sum+arr1[i][j];
            }
        }
        sum=sum/(arr1.length*arr1[0].length);
        return sum;
    }
    public Matrix(int n,int m)throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter id for matrix: ");
        this.id=s.nextInt();
        // System.out.println("enter no of rows: \n");
        // this.n=s.nextInt();
        // System.out.println("enter no of coloumns: \n");
        // this.m=s.nextInt();
        this.n=n;
        this.m=m;
        arr1=Temp.input(this.n,this.m);
        // System.out.println("Enter the elements: \n");
        // for(int i=0;i<this.n;i++)
        // {
        //     for(int j=0;j<this.m;j++)
        //     {
        //         this.arr1[i][j]=s.nextInt();
        //     }
        // }
        this.trans_of_arr1=Temp.transpose(this.arr1, this.n, this.m);
        if(this.n>this.m && this.n<this.m && (this.n>1 && this.m>1))
        {
            this.type.add("Rectangular Matrix");
            this.type_no.add(1);
        }
        if(this.n==1 && this.m>1)
        {
            this.type.add("Row Matrix");
            this.type_no.add(2);
        }
        if(this.m==1 && this.n>1)
        {
            this.type.add("Column Matrix");
            this.type_no.add(3);
        }
        
        if(this.n==this.m)
        {
            this.det=Temp.deter(this.arr1, this.n);
            this.type.add("Square matrix");
            this.type_no.add(4);
        }
        if(this.n==this.m && Temp.checksym(this.trans_of_arr1, this.arr1, this.n, this.m))
        {
            this.type.add("Symmetric Matrix");
            this.type_no.add(5);
        }
        if(this.n==this.m && Temp.check(this.trans_of_arr1, this.arr1, this.n, this.m))
        {
            this.type.add("Skew-symmetric Matrix");
            this.type_no.add(6);
        }
        if(this.n==this.m && Temp.isUpperTriangularMatrix(this.arr1))
        {
            this.type.add("Upper-triangular Matrix");
            this.type_no.add(7);
        }
        if(this.n==this.m && Temp.isLowerTriangularMatrix(this.arr1))
        {
            this.type.add("Lower-triangular Matrix");
            this.type_no.add(8);
        }
        if(this.n==this.m && this.det==0)
        {
            this.type.add("Singular Matrix");
            this.type_no.add(9);
        }
        if(this.n==this.m && Temp.isDiagonalMatrix(this.arr1))
        {
            this.type.add("Diagonal Matrix");
            this.type_no.add(10);
        }
        if(this.n==this.m && Temp.isScalarMatrix(this.arr1))
        {
            this.type.add("Scalar Matrix");
            this.type_no.add(11);
        }
        if(this.n==this.m && Temp.identity(this.arr1))
        {
            this.type.add("Identity Matrix");
            this.type_no.add(12);
            flag=1;
        }
        if(this.n==1 && this.m==1)
        {
            this.type.add("Singleton Matrix");
            this.type_no.add(13);
            inverse_arr1[0][0]=1/arr1[0][0];
        }
        if(this.n==this.m && Temp.ones(this.arr1))
        {
            this.type.add("Ones Matrix");
            this.type_no.add(14);
        }
        
        if(Temp.zeros(this.arr1))
        {
            this.type.add("Null Matrix");
            this.type_no.add(15);
        }
        
        if(this.n==this.m)
        {
            if(this.n==3 && this.m==3)
            {
                this.inverse_arr1=Temp.inv(this.arr1);
            }
            if(this.n==3 && this.m==3 && flag==1)
            {
                this.inverse_arr1=this.arr1;
            }
            if(this.n==2 && this.m==2 && this.det!=0)
            {
                inverse_arr1=Temp.inv2(this.arr1,this.det);
            }
            if(this.n==2 && this.m==2 && this.det!=0 && flag==1)
            {
                inverse_arr1=this.arr1;
            }
            
        }
        
        A.func1(this);
        T_task.t();

    }
    
    

    
    
}
class A{
    private static ArrayList<Matrix> Mat=new ArrayList<Matrix>();
    static int[][] temp1;
    static int[][] temp2;
    static int[][] temp3;
    static int[] ans;
    public static void func1(Matrix M)
    {
        Mat.add(M);
    }
    // Function for task 4
    public static void display_all()
    {
        for(int i=0;i<Mat.size();i++)
        {
            int[][] t=Mat.get(i).A();
            ArrayList<String> temp_type=Mat.get(i).B();
            for(int j=0;j<t.length;j++)
            {
                for(int k=0;k<t[0].length;k++)
                {
                    System.out.println(t[j][k] + "\t");
                }
                System.out.println();
            }
            for(int x=0;x<temp_type.size();x++)
            {
                System.out.println(temp_type.get(x) + "  \n");
            }
            retrive.Z(temp3);
        }
            
    }
    public static void Arithmatic() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.err.println("Enter the id for the first matrix: ");
        int a=s.nextInt();
        System.err.println("Enter the id for the second matrix: ");
        int b=s.nextInt();
        System.out.println("Enter the operatin 1.+ 2.- 3.* 4./  0.for exit: ");
        int ch=s.nextInt();
        
        if(ch==1)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.add(temp1,temp2);

            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==2)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.sub(temp1,temp2);
            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==3)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.mul(temp1,temp2);
            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==4)
        {
            for(int i=0;i<Mat.size();i++)
            {
                // if(Mat.get(i).ret_id()==a)
                // {
                //     temp1=Mat.get(i).A();
                // }
                // if(Mat.get(i).ret_id()==b)
                // {
                //     temp2=Mat.get(i).A();
                // }
                
                // int[][] temp3=Temp.mul(temp1,temp2);
            }
        }
        if(ch==0)
        {
            T_task.t();
        }
        
    }    
    public static void Ele_Arithmatic() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.err.println("Enter the id for the first matrix: ");
        int a=s.nextInt();
        System.err.println("Enter the id for the second matrix: ");
        int b=s.nextInt();
        System.out.println("Enter the operatin 1.+ 2.- 3.* 4./ 0.exit: ");
        int ch=s.nextInt();
        
        if(ch==1)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.add(temp1,temp2);
            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==2)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.sub(temp1,temp2);
            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==3)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.Ele_mul(temp1,temp2);
            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==4)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                }
                if(Mat.get(i).ret_id()==b)
                {
                    temp2=Mat.get(i).A();
                }
                
                temp3=Temp.Ele_div(temp1,temp2);
            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            retrive.Z(temp3);
            T_task.t();
        }
        if(ch==0)
        {
            T_task.t();
        }
        
            
        

    }
    public static void transpose() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the id: ");
        int a=s.nextInt();
        for(int i=0;i<Mat.size();i++)
        {
            if(Mat.get(i).ret_id()==a)
            {
                temp3=Mat.get(i).Trans_A();
            }
        }
        for(int j=0;j<temp3.length;j++)
        {
            for(int k=0;k<temp3[0].length;k++)
            {
                System.out.println(temp3[j][k] + " ");
            }
            System.out.println();
        }
        
        retrive.Z(temp3);
        T_task.t();
    }
    public static void inverse() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.err.println("Enter id : ");
        int a=s.nextInt();
        for(int i=0;i<Mat.size();i++)
        {
            if(Mat.get(i).ret_id()==a)
            {
                temp3=Mat.get(i).ret_inv();
            }
        }
        for(int j=0;j<temp3.length;j++)
        {
            for(int k=0;k<temp3[0].length;k++)
            {
                System.out.println(temp3[j][k] + " ");
            }
            System.out.println();
        }
        
        retrive.Z(temp3);
        T_task.t();
    }
    
    public static void mean() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter id:");
        int a=s.nextInt();
        System.out.println(" 1.row _wise mean \n" + "2.column \n" + "3.all elements" + "0.exit\n");
        int ch=s.nextInt();
        

        if(ch==1)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                   ans = Mat.get(i).row_sum();
                }
            }
            for(int j=0;j<ans.length;j++)
            {
                System.out.println(ans[j] + " ");
            }
            T_task.t();
        }
        if(ch==2)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                   ans = Mat.get(i).col_sum();
                }
            }
            for(int j=0;j<ans.length;j++)
            {
                System.out.println(ans[j] + " ");
            }
            T_task.t();
        }
        if(ch==3)
        {
            for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                   System.out.println(Mat.get(i).whole_sum());
                }
            }
            T_task.t();
            
        }
        if(ch==0)
        {
            T_task.t();
        }
        
        
    }
    public static void det() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter id:");
        int a=s.nextInt();
        for(int i=0;i<Mat.size();i++)
        {
            if(Mat.get(i).ret_id()==a)
            {
                System.out.println(Mat.get(i).D());
            }
        }
        
        T_task.t();
    }
    public static void add_a_at() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter id:");
        int a=s.nextInt();
        for(int i=0;i<Mat.size();i++)
            {
                if(Mat.get(i).ret_id()==a)
                {
                    temp1=Mat.get(i).A();
                
                
                
                    temp2=Mat.get(i).Trans_A();
                }
                
                temp3=Temp.add(temp1,temp2);

            }
            for(int j=0;j<temp3.length;j++)
            {
                for(int k=0;k<temp3[0].length;k++)
                {
                    System.out.println(temp3[j][k] + " ");
                }
                System.out.println();
            }
            
            retrive.Z(temp3);
            T_task.t();
            
    }
    public static void t_3() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the id: \n");
        int a=s.nextInt();
        for(int i=0;i<Mat.size();i++)
        {
            if(Mat.get(i).ret_id()==a)
            {
                // ArrayList<String> temp=new ArrayList<>();
                // temp=Mat.get(i).B();
                ArrayList<Integer> temp2=new ArrayList<>();
                temp2=Mat.get(i).C();
                int[][] arr=Mat.get(i).A();
                System.out.println("Enter the position of element :");
                int x=s.nextInt();
                int y=s.nextInt();
                System.out.println("enter the new value: \n");
                int val=s.nextInt();
                arr[x-1][y-1]=val;
                boolean flag=false;
                for(int j=0;j<temp2.size();j++)
                {
                    int b=temp2.get(j);
                    if(b==5)
                    {
                        if(!Temp.checksym(Mat.get(i).Trans_A(), arr, arr.length, arr[0].length));
                        {
                            flag=true;
                            System.out.println("error");
                        }
                        
                        
                    }
                    if(b==6)
                    {
                        if(!Temp.check(Mat.get(i).Trans_A(), arr, arr.length, arr[0].length));
                        {
                            
                            flag=true;
                            break;
                            
                        }
                    }
                    if(b==7)
                    {
                        if(!Temp.isUpperTriangularMatrix(arr));
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(b==8)
                    {
                        if(!Temp.isLowerTriangularMatrix(arr));
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(b==9)
                    {
                        if(Mat.get(i).D()!=0);
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(b==10)
                    {
                        if(!Temp.isDiagonalMatrix(arr));
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(b==11)
                    {
                        if(!Temp.isScalarMatrix(arr));
                        {
                            flag=true;
                            break;
                        }
                    }
                    if(b==12)
                    {
                        if(!Temp.identity(arr));
                        {
                            flag=true;
                            break;

                        }
                    }
                    if(b==14)
                    {
                        if(!Temp.ones(arr))
                        {
                            flag=true;
                            break;
                        }
                        
                        
                    }
                    if(b==15)
                    {
                        if(!Temp.zeros(arr))
                        {
                            flag=true;
                            break;
                        }
                        
                        
                    }
                    if(flag)
                    {
                        System.out.println("error");
                    }


                }
            }
        }
        
        T_task.t();
    }
    public static void equtn() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("enter id for matrix: \n");
        int a=s.nextInt();
        for(int i=0;i<Mat.size();i++)
        {
            if(Mat.get(i).ret_id()==a)
            {
                int[][] temp=Mat.get(i).A();
                int[][] temp2=new int[temp.length][1];
                int[][] ans=Temp.mul(temp, temp2);
                for(int j=0;j<ans.length;j++)
                {
                    for(int k=0;k<ans[0].length;k++)
                    {
                        System.out.println(ans[j][k] + " ");
                    }
                    System.out.println();
                }
            }
        }
        
        T_task.t();
    }
    public static void print_all(String s) throws IOException
    {
        for(int i=0;i<Mat.size();i++)
        {
            
            ArrayList<String> ty=new ArrayList<>();
            ty=Mat.get(i).B();
            for(int k=0;k<ty.size();k++)
            {
                if(ty.get(k).equals(s))
                {
                    int[][] tearr=Mat.get(i).A();
                    for(int x=0;x<tearr.length;x++)
                    {
                        for(int y=0;y<tearr[0].length;y++)
                        {
                            System.out.println(tearr[x][y] + " ");
                        }
                        System.out.println();
                    }
                }
            }
            
            
            
        }
        for(int i=0;i<retrive.W().size();i++)
        {
            for(int j=0;j<retrive.W().get(i).size();j++)
            {
                if(retrive.W().get(i).get(j).equals(s))
                {
                    int[][] r =retrive.Q().get(i);
                    for(int x=0;x<r.length;x++)
                    {
                        for(int y=0;y<r[0].length;y++)
                        {
                            System.out.println(r[x][y] + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
        T_task.t();
        

    }
    
}
class created_mat{

    public static void created_t(int[][] arr1)
    {
        int n=arr1.length;
        int m=arr1[0].length;
        int det=Temp.deter(arr1, n);
        int[][] tans=Temp.transpose(arr1, n, m);
        ArrayList<String> ty1=new ArrayList<>();
        ArrayList<Integer> tn1=new ArrayList<>();
        if(n>m && n<m && (n>1 && m>1))
        {
            ty1.add("Rectangular Matrix");
            tn1.add(1);
        }
        if(n==1 && m>1)
        {
            ty1.add("Row Matrix");
            tn1.add(2);
        }
        if(m==1 && n>1)
        {
            ty1.add("Column Matrix");
            tn1.add(3);
            
        }
        
        if(n==m)
        {
            ty1.add("Square Matrix");
            tn1.add(4);
        }
        if(n==m && Temp.checksym(tans, arr1, n, m))
        {
            ty1.add("Symmetric Matrix");
            tn1.add(5);
            
        }
        if(n==m && Temp.check(tans, arr1, n, m))
        {
            ty1.add("Skew-symmetric Matrix");
            tn1.add(6);
        }
        if(n==m && Temp.isUpperTriangularMatrix(arr1))
        {
            ty1.add("Upper-triangular Matrix");
            tn1.add(7);
        }
        if(n==m && Temp.isLowerTriangularMatrix(arr1))
        {
            ty1.add("Lower-triangular Matrix");
            tn1.add(8);
        }
        if(n==m && det==0)
        {
            ty1.add("Singular Matrix");
            tn1.add(9);
        }
        if(n==m && Temp.isDiagonalMatrix(arr1))
        {
            ty1.add("Diagonal Matrix");
            tn1.add(10);
        }
        if(n==m && Temp.isScalarMatrix(arr1))
        {
            ty1.add("Scalar Matrix");
            tn1.add(11);
        }
        if(n==m && Temp.identity(arr1))
        {
            ty1.add("Identity Matrix");
            tn1.add(12);
        }
        if(n==1 && m==1)
        {
            ty1.add("Singleton Matrix");
            tn1.add(13);
        }
        if(n==m && Temp.ones(arr1))
        {
            ty1.add("Ones Matrix");
            tn1.add(14);
        }
        
        if(Temp.zeros(arr1))
        {
            ty1.add("Null Matrix");
            tn1.add(15);
        } 
        retrive.X(tn1, ty1);
    }
}
class retrive
{
    private static ArrayList<int[][]> e_mat=new ArrayList<>();
    private static ArrayList<ArrayList<String>> typeof=new ArrayList<>();
    private static ArrayList<ArrayList<Integer>> typeno=new ArrayList<>();
    public static void Z(int[][] M)
    {
        e_mat.add(M);
    }
    public static ArrayList<int[][]> Q()
    {return e_mat;}
    public static ArrayList<ArrayList<String>> W()
    {return typeof;}
    public static void X(ArrayList<Integer> a, ArrayList<String> type)
    {
        typeof.add(type);
        typeno.add(a);
    }
    void check()
    {
        for(int i=0;i<e_mat.size();i++)
        {
            created_mat.created_t(e_mat.get(i));;
        }
    }
}
class T_task
{
    public static void t() throws IOException
    {
        Scanner s=new Scanner(System.in);
        System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\n"+ 
        "2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\n"+
        "3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\n"+
        "4. Display all the matrix-type labels of a requested matrix.\n"+
        
        "5. Perform addition, subtraction, multiplication & division.\n"+
        "6. Perform element-wise operations.\n"+
        "7. Transpose matrices.\n"+
        "8. Inverse matrices.\n"+
        "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n"+
        "10. Compute determinants.\n"+
        "11. Use singleton matrices as scalars, if requested.\n"+
        "12. Compute A+AT for a matrix A.\n" +
        "13. Compute Eigen vectors and values.\n" +
        "14. Solve sets of linear equations using matrices.\n" +
        "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\n");
        System.out.println("Enter the task no: \n");
        int n=s.nextInt();
        if(n==1)
        {
            System.out.println("Enter the row and columns of matrix: \n");
            int x=s.nextInt();
            int y=s.nextInt();
            Matrix m=new Matrix(x,y);
        }
        // if(n==2)
        // {

        // }
        if(n==3)
        {
            A.t_3();
        }
        if(n==4)
        {
            A.display_all();
        }
        if(n==5)
        {
            A.Arithmatic();
        }
        if(n==6)
        {
            A.Ele_Arithmatic();
        }
        if(n==7)
        {
            A.transpose();
        }
        if(n==8)
        {
            A.inverse();
        }
        if(n==9)
        {
            A.mean();
        }
        if(n==10)
        {
            A.det();
        }
        // if(n==11)
        // {

        // }
        if(n==12)
        {
            A.add_a_at();
        }
        // if(n==13)
        // {

        // }
        if(n==14)
        {
            A.equtn();
        }if(n==15)
        {
            Scanner p=new Scanner(System.in);
            System.out.println("Enter the mat label: ");
            String T=p.next();
            A.print_all(T);
            p.close();
        }
        
        

    }
}
public class Main{
    public static void main(String[] args) throws IOException {
        
        
        T_task.t();
 
        
    }
    
}