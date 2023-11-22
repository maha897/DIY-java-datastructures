public class Stabel<E> extends Lenkeliste<E>{
    /*-- Last in, first out --
     * Nye elementer legges til først i listen, og fjerning skjer første element i listen.
    */

    @Override
    public void leggTil(E x){
        // Nye elementer legges til først i listen.

        Node tmp = start;
        start = new Node(x);
        start.neste = tmp;
    }
}
