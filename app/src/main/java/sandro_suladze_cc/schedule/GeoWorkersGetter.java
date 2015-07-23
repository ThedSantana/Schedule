package sandro_suladze_cc.schedule;

/**
 * Created by Sandro on 14.07.2015.
 */
public class GeoWorkersGetter {

   private String names, phNumbers, images;

    public String getNames() {
        return names;
    }

    public String getPhNumbers() {
        return phNumbers;
    }

    public String getImages() {
        return images;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setPhNumbers(String phNumbers) {
        this.phNumbers = phNumbers;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public GeoWorkersGetter(String names, String phNumbers, String images) {
        this.names = names;
        this.phNumbers = phNumbers;
        this.images = images;


    }

    @Override
    public String toString() {
        return "GeoWorkersGetter{" +
                "names='" + names + '\'' +
                ", phNumbers='" + phNumbers + '\'' +
                ", images='" + images + '\'' +
                '}';
    }
}
