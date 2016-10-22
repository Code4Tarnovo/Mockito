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
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (info != null ? !info.equals(that.info) : that.info != null) return false;
        return rating != null ? rating.equals(that.rating) : that.rating == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }
}
