public abstract class Lenkeliste <E> implements Liste <E>{
    /*  Nye elementer settes inn på slutten av listen og tas ut fra starten
    slik at det elementet som ble satt inn først, er det første som blir tatt ut.
    */

    protected class Node{
        Node neste = null;
        E data;

        Node (E x){
            data = x;
        }
    }

    protected Node start = null;
    
    @Override
    public int stoerrelse(){
        int teller = 0;
        Node peker = start;

        while (peker != null){
            teller++;
            peker = peker.neste;
        }

        return teller;
    }

    @Override
    public void leggTil(E x){
        // Legger til nytt element x bakerst i listen.

        if (start == null){
            start = new Node(x);
        } else {
            Node peker = start;
            while (peker.neste != null){
                peker = peker.neste;
            }

            peker.neste = new Node(x);
        }
    }

    @Override
    public E hent(){
        // Returnerer det første elementet i listen.
        return start.data;
    }

    @Override
    public E fjern(){
        // Fjerner det første elementet i listen og returnerer det.

        Node tmp = start;
        start = start.neste;

        return tmp.data;
    }
}
