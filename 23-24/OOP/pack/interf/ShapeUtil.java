import java.util.List;

public class ShapeUtil {
    /**
     * ok.
     */
    public String printInfo(List<GeometricObject> shapes) {
        String result = "";
        result += "Circle:\n";
        for (GeometricObject shape : shapes) {
            if (shape instanceof Circle) {
                result += ((Circle) shape).getInfo() + "\n";
            }
        }
        result += "Triangle:\n";
        for (GeometricObject shape : shapes) {
            if (shape instanceof Triangle) {
                result += ((Triangle) shape).getInfo() + "\n";
            }
        }
        return result;
    }
}
