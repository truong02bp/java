package matrix;

import java.util.Scanner;

public class Matrix {
    private float[][] a;

    public Matrix() {
        this.a = new float[3][3];
    }

    public Matrix(int rows, int cols) {
        this.a = new float[rows][cols];
    }

    public Matrix add(Matrix m) throws Exception {
        int rows = m.a.length;
        int cols = m.a[0].length;
        if (rows != this.a.length)
            throw new Exception("Số hàng không bằng nhau");
        if (cols != this.a[0].length)
            throw new Exception("Số cột không bằng nhau");
        Matrix result = new Matrix(rows,cols);
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++)
                result.a[i][j] = this.a[i][j] + m.a[i][j];
        return result;
    }

    public Matrix sub(Matrix m) throws Exception {
        int rows = m.a.length;
        int cols = m.a[0].length;
        if (rows != this.a.length)
            throw new Exception("Số hàng không bằng nhau");
        if (cols != this.a[0].length)
            throw new Exception("Số cột không bằng nhau");
        Matrix result = new Matrix(rows,cols);
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++)
                result.a[i][j] = this.a[i][j] - m.a[i][j];
        return result;
    }

    public Matrix neg() {
        int rows = this.a.length;
        int cols = this.a[0].length;
        Matrix result = new Matrix(rows,cols);
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++)
                result.a[i][j] = -this.a[i][j];
        return result;
    }

    public Matrix transpose() {
        int rows = this.a.length;
        int cols = this.a[0].length;
        Matrix result = new Matrix(cols,rows);
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++)
                result.a[j][i] = this.a[i][j];
        return result;
    }

    public Matrix mul(Matrix m) throws Exception {
        int currentRows = this.a.length;
        int rows = m.a.length;
        int cols = m.a[0].length;
        if (rows != this.a[0].length)
            throw new Exception("Số hàng, số cột của hai ma trận lệ");
        Matrix result = new Matrix(currentRows,cols);
        for (int i=0;i<currentRows;i++)
            for (int j=0;j<cols;j++)
                for (int k=0;k<rows;k++)
                    result.a[i][j]+=this.a[i][k]*m.a[k][j];
        return result;
    }

    public void output(){
        int rows = this.a.length;
        int cols = this.a[0].length;
        for (int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(this.a[i][j] + " ");
            System.out.println();
        }
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        int rows = this.a.length;
        int cols = this.a[0].length;
        for (int i=0;i<rows;i++)
            for (int j=0;j<cols;j++)
                this.a[i][j] = scanner.nextFloat();
    }
}
