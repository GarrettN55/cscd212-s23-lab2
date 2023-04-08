package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionModelScreenSizeComparator implements Comparator <Television> {

    public int compare(final Television t1,final Television t2) {
        int modelComp = t1.getModel().compareTo(t2.getModel());
        if(modelComp != 0) {
            return modelComp;
        }
        return Integer.compare(t1.getScreenSize(), t2.getScreenSize());
    }
}

