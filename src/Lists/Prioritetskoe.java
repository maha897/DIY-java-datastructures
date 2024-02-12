package src.Lists;

import java.util.Collections;
import java.util.List;

public class Prioritetskoe<T extends Comparable<T>> extends IndeksertListe<T>{
    @Override
    public void leggTil(T x) {
        if (stoerrelse() == 0 || x.compareTo(hent(0)) < 0) {
            super.leggTil(0, x);
        } else {
            super.leggTil(x);
        }
        sorter();
    }

    private void sorter() {
        for (int i = 0; i < stoerrelse() - 1; i++) {
            for (int j = 0; j < stoerrelse() - i - 1; j++) {
                T element1 = hent(j);
                T element2 = hent(j + 1);
                if (element1.compareTo(element2) > 0) {
                    bytt(j, j + 1);
                }
            }
        }
    }

    private void bytt(int index1, int index2) {
        T temp = hent(index1);
        sett(index1, hent(index2));
        sett(index2, temp);
    }
}

