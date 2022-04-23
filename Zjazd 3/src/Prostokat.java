import java.util.Objects;

public class Prostokat implements MaWlasnosciRownolegloboku, MoznaWyznaczycPrzekatna, MoznaWyznaczycWysokosc, MoznaWyznaczycWielokrotnoscPrzekatnej {
    double i, j;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prostokat)) return false;
        Prostokat prostokat = (Prostokat) o;
        return Double.compare(prostokat.i, i) == 0 && Double.compare(prostokat.j, j) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return "prostokat";
    }

    public Prostokat(double i1, double j2) {
        i = i1;
        j = j2;

    }
    @Override
    public double podstawa() {
        return 0;
    }

    @Override
    public double bok() {
        return 0;
    }

    @Override
    public double katNachylenia() {
        return Math.PI / 2;
    }

    @Override
    public double przekatna() {
        return Math.sqrt((i+j));
    }

    @Override
    public double wysokosc() {
        return 0;
    }

    @Override
    public double wielokrotnoscPrzekatnej(double v) {
        return v * Math.sqrt((i * i) + (j * j));
    }
}
