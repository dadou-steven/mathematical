package appsinc.fr.lesmaths.matrix;

public interface MatrixExpression {
}

class Identity implements MatrixExpression {
    public Identity() {
    }
}

class Scalar implements MatrixExpression {
    private final double value;
    public Scalar(double value) {
        this.value = value;
    }
}

class Matrix implements MatrixExpression {
    private final double[][] array;
    public Matrix(double[][] array) {
        this.array = array;
    }
}

class Product implements MatrixExpression {
    private final MatrixExpression m1;
    private final MatrixExpression m2;
    public Product(MatrixExpression m1, MatrixExpression m2) {
        this.m1 = m1;
        this.m2 = m2;
    }
}
