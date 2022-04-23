public class Buzka implements Skalowalny, PrzedstawiaEmocje {
    String buzka;

    public Buzka (){
        buzka = ":-)";
    }

    @Override
    public void draw() {
        System.out.println(buzka);
    }

    @Override
    public boolean czySieUsmiecha() {
        return false;
    }

    @Override
    public void przestanSieUsmiechac() {

    }

    @Override
    public void draw(int times) {
        System.out.println(buzka);
    }

    @Override
    public String toString() {
        return ":-";
    }
}
