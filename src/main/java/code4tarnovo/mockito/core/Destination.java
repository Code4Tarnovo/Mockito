package code4tarnovo.mockito.core;

/**
 * Created by alroy on 22.10.16.
 */
public class Destination {
    public final String name;
    public final String type;
    public final String adress;
    public final String info;
    public final Double rating;

    @Override
    public String toString() {
        return "Destination{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", adress='" + adress + '\'' +
                ", info='" + info + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Destination(String name, String type, String adress, String info, Double rating) {
        this.name = name;
        this.type = type;
        this.adress = adress;
        this.info = info;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Destination that = (Destination) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }
}
