package shapes;

public abstract class Shapes implements Comparable<Shapes> 
{    
    public abstract double getHeight();
    public abstract double getBaseArea();
    public abstract double getVolume();
    
    @Override
    public int compareTo(Shapes other) {
        
        return Double.compare(this.getHeight(), other.getHeight());
    }
}
