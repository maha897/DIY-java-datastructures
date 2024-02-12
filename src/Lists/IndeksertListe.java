package src.Lists;

import src.UgyldigListeIndeks;

public class IndeksertListe<E> extends Lenkeliste<E> {


    public void leggTil(int pos, E x){
        if (sjekkIndeksEksklusiv(pos)){
            throw new UgyldigListeIndeks(pos);
        }
        Node node = new Node(x);
        if (pos == 0) {
            if (stoerrelse() == 0) {
                super.leggTil(x);
            } else {
                leggTilStart(node);
            }
        } else if (pos == stoerrelse()) {
            leggTilSiste(node);
        } else {
            leggTilMellom(pos, node);
        }
    }

    public void sett(int pos, E x){
        if (!sjekkIndeksInklusiv(pos)){
            throw new UgyldigListeIndeks(pos);
        }
        Node nyNode = new Node(x);
        if (pos == 0) {
            settStart(nyNode);
        } else if (pos == stoerrelse() - 1) {
            settSiste(nyNode);
        } else {
            settMellom(pos, nyNode);
        }
    }

    public E hent(int pos){
        if (!sjekkIndeksInklusiv(pos)){
            throw new UgyldigListeIndeks(pos);
        }

        Node peker = start;
        for (int i = 0; i < pos; i++){
            peker = peker.neste;
        }
        return peker.data;
    }

    public E fjern(int pos) {
        if (!sjekkIndeksInklusiv(pos)) {
            throw new UgyldigListeIndeks(pos);
        }

        Node peker = start;
        // Traverse to the node just before the one to be removed
        for (int i = 0; i < pos - 1; i++) {
            peker = peker.neste;
        }

        // Save the value of the node to be removed
        E fjernes = peker.neste.data;

        // Update the links
        if (peker.neste == siste) {
            // If the last element is being removed
            siste = peker;
            peker.neste = null;
        } else {
            // If an element from the middle is being removed
            peker.neste = peker.neste.neste;
            peker.neste.forrige = peker;
        }

        return fjernes;
    }

    private boolean sjekkIndeksEksklusiv(int pos){
        return pos < 0 || pos > stoerrelse();
    }
    private boolean sjekkIndeksInklusiv(int pos){
        return pos >= 0 && pos < stoerrelse();
    }

    private void leggTilStart(Node nyNode) {
        nyNode.neste = start;
        start.forrige = nyNode;
        start = nyNode;
    }

    private void leggTilSiste(Node nyNode) {
        siste.neste = nyNode;
        nyNode.forrige = siste;
        siste = nyNode;
    }

    private void leggTilMellom(int pos, Node nyNode) {
        Node peker = start;
        for (int i = 0; i < pos - 1; i++) {
            peker = peker.neste;
        }
        nyNode.neste = peker.neste;
        peker.neste = nyNode;
        nyNode.forrige = peker;
    }

    private void settStart(Node nyNode) {
        nyNode.neste = start.neste;
        start.neste.forrige = nyNode;
        start = nyNode;
    }

    private void settSiste(Node nyNode) {
        siste.forrige.neste = nyNode;
        nyNode.forrige = siste.forrige;
        siste = nyNode;
    }

    private void settMellom(int pos, Node nyNode) {
        Node peker = start
                ;
        for (int i = 0; i < pos - 1; i++) {
            peker = peker.neste;
        }
        nyNode.neste = peker.neste.neste;
        nyNode.neste.forrige = nyNode;
        peker.neste = nyNode;
        nyNode.forrige = peker;
    }
}
