package appDomain;

import java.util.Comparator;
import shapes.Shapes;

public class BaseArea implements Comparator<Shapes> {

    @Override
    public int compare(Shapes o1, Shapes o2) {
        return Double.compare(o2.getBaseArea(), o1.getBaseArea());
    }

    
}
