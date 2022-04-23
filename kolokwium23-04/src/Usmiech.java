public class Usmiech extends Buzka implements Skalowalny, Rysowalny, PrzedstawiaEmocje {
    String usmiech;

    public Usmiech(){
        usmiech = ")";
    }
    @Override
    public void draw() {
        System.out.println(usmiech);
    }

    @Override
    public String toString() {
        if(czySieUsmiecha())
        return ")";
        else
            return "(";
    }

    @Override
    public void draw(int times) {
        System.out.println(usmiech);
    }

    @Override
    public boolean czySieUsmiecha() {
        return false;
    }

    @Override
    public void przestanSieUsmiechac() {

    }
}
