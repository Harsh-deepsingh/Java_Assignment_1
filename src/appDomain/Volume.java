package appDomain;

import java.util.Comparator;
import shapes.Shapes;

public class Volume implements Comparator<Shapes>{
    
        @Override
    public int compare(Shapes o1, Shapes o2) {
        return Double.compare(o2.getVolume(), o1.getVolume()); 
    }
    
}
