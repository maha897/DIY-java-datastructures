package src.Lists;

public interface Liste <E>{
    int stoerrelse();
    void leggTil(E x);
    E hent();
    E fjern();
}
