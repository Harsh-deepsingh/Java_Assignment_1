package shapes;

public class SquarePrism extends Shapes
{
    private double height;
    private double edgeLength;
    
    public SquarePrism(double height, double edgeLength){
        this.height = height;
        this.edgeLength = edgeLength;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getBaseArea() {
        return edgeLength * edgeLength;
    }

    @Override
    public double getVolume() {
         return getBaseArea() * height;
    }
    
    
}
