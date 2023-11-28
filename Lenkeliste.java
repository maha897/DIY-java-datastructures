public abstract class Lenkeliste <E> implements Liste <E>{
    /*  Nye elementer settes inn på slutten av listen og tas ut fra starten
    slik at det elementet som ble satt inn først, er det første som blir tatt ut.
    */

    protected class Node{
        Node neste = null, forrige = null;
        E data;

        Node (E x){
            data = x;
        }
    }

    protected Node start = null, siste = null;
    
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

        Node node = new Node(x);
        if (start == null){
            start = node;
        } else {
            siste.neste = node;
            
            /* 
            Node peker = start;
            while (peker.neste != null){
                peker = peker.neste;
            }

            peker.neste = new Node(x);
            */
        }
        node.forrige = siste;
        siste = node;
    }

    @Override
    public E hent(){
        // Returnerer det første elementet i listen.

        if (start != null) return start.data;
        else throw new UgyldigListeIndeks(0);
    }

    @Override
    public E fjern() throws UgyldigListeIndeks{
        // Fjerner det første elementet i listen og returnerer det.

        if (start != null){
            Node tmp = start;
            start = start.neste;
            
            if (start != null) start.forrige = null;

            return tmp.data;
        } else {
            throw new UgyldigListeIndeks(0);
        }
    }

    @Override 
    public String toString(){
        String str = "[";
        Node peker = start;
        
        while (peker != null){
            str += peker.data + ",";
            peker = peker.neste;
        }
        str += "\b]";

        return str;
    }
}
