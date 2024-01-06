import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeCircles() {
        shapes.removeIf(shape -> (shape instanceof Circle));
    }

    /**
     * ad.
     * 
     * @return ad
     */
    public String getInfo() {
        String result = new String("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            result += shape.toString() + "\n";
        }
        return result;
    }

    /**
     * ad.
     */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape curShape = shapes.get(i);
            for (int j = i + 1; j < shapes.size();) {
                Shape shape = shapes.get(j);
                if (curShape.equals(shape)) {
                    shapes.remove(j);
                    continue;
                }
                j++;
            }
        }
    }
}
