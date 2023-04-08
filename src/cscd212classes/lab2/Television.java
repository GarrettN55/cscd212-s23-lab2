package cscd212classes.lab2;

import java.util.Objects;

public class Television implements Comparable <Television>  {

    private final boolean fourK;
    private final String make;
    private final String model;
    private final int resolution;
    private final int screenSize;
    private final boolean smart;
    //===================================================================================================================================
    public Television(String make, String model, boolean smart, int screenSize, int resolution) {
        if(make == null || model == null || make.isBlank() || model.isBlank() || screenSize < 32 || resolution < 720)
                throw new IllegalArgumentException("error somewhere");


        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.fourK = resolution == 2160;


    }
    //===================================================================================================================================
    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make) {


        this(make, model, smart, screenSize, resolution);

    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getResolution() {
        return resolution;
    }

    public int getScreenSize() {
        return screenSize;
    }
    //===================================================================================================================================
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Television that = (Television) o;
        return fourK == that.fourK && resolution == that.resolution && screenSize == that.screenSize && smart == that.smart && Objects.equals(make, that.make) && Objects.equals(model, that.model);
    }
    //===================================================================================================================================
    @Override
    public int hashCode() {
        return this.make.hashCode() + this.model.hashCode() + this.resolution + Boolean.hashCode(this.smart) + Boolean.hashCode(this.fourK);
    }
    //===================================================================================================================================
    @Override
    public String toString() {
        if (fourK) {
            return make + "-" + model + ", " + screenSize + " inch tv with " + resolution + " resolution";
        } else {
            return make + "-" + model + ", " + screenSize + " inch tv with no 4K support";
        }
    }
//===================================================================================================================================
    @Override
        public int compareTo(final Television another) {
            if(another == null) {
                    throw new IllegalArgumentException("Another is null");
            }
            int makeComp = this.make.compareTo(another.make);
            if(makeComp != 0) {
                return makeComp;
            }
            int modelComp = this.model.compareTo(another.model);
            if(modelComp != 0) {
                return modelComp;
            }
        return this.screenSize - another.screenSize;
        }
}
