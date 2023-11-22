public class Stabel<E> extends Lenkeliste<E>{
    @Override
    public void leggTil(E x){
        // Nye elementer legges til først i listen.

        Node tmp = start;
        start = new Node(x);
        start.neste = tmp;
    }
}
