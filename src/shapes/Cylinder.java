package shapes;

public class Cylinder extends Shapes 
{
    private double radius;
    private double height;
    
    public Cylinder(double radius, double height) 
    {
        this.radius = radius;
        this.height = height;
    }
    @Override
    public double getHeight(){
        return height;
    }
    @Override
    public double getBaseArea(){
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getVolume(){
        return  getBaseArea() * height;
    }
}
