package cscd212comparators.lab2;

import cscd212classes.lab2.Television;

import java.util.Comparator;

public class TelevisionResolutionMakeDescendingComparator implements Comparator <Television> {

    public int compare(final Television t1, final Television t2) {
        int resolutionComp = Integer.compare(t1.getResolution(), t2.getResolution());
        if(resolutionComp != 0) {
            return resolutionComp;
        }
        return t1.getMake().compareTo(t2.getMake());
    }

}
