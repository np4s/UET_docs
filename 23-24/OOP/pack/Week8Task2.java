import java.io.FileNotFoundException;
import java.io.IOException;

public class Week8Task2 {
    /**
     * ok.
     */
    public void nullPointerEx() {
        throw new NullPointerException();
    }

    /**
     * ok.
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
        return "Không có lỗi";
    }

    /**
     * ok.
     */
    public void arrayIndexOutOfBoundsEx() {
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     * ok.
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
        return "Không có lỗi";
    }

    /**
     * ok.
     */
    public void arithmeticEx() {
        throw new ArithmeticException();
    }

    /**
     * ok.
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
        return "Không có lỗi";
    }

    /**
     * ok.
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    /**
     * ok.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
        return "Không có lỗi";
    }

    /**
     * ok.
     */
    public void ioEx() throws IOException {
        throw new IOException();
    }

    /**
     * ok.
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return "Lỗi IO";
        }
        return "Không có lỗi";
    }
}
