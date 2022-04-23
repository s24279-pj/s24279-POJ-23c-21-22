import java.util.Objects;

public class Kwadrat extends Prostokat {
    double i, j;
    @Override
    public String toString() {
        return "kwadrat";
    }

    public Kwadrat(double i) {
        super(i,i);
    }
    public Kwadrat(double i, double j) {
        super(i,j);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kwadrat)) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return Double.compare(kwadrat.i, i) == 0 && Double.compare(kwadrat.j, j) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
