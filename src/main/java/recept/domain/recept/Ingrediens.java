package recept.domain.recept;

import recept.domain.livsmedel.Livsmedel;
import recept.domain.service.Searchable;

/**
 * @Author: vda
 */
public class Ingrediens implements Searchable {

    private String id;
    private Livsmedel livsmedel;
    private Mangd mangd = new Mangd(3.0, "msk");

    public String getId() {
        return id;
    }

    public Livsmedel getLivsmedel() {
        return livsmedel;
    }

    public Mangd getMangd() {
        return mangd;
    }

    public class Mangd {
        private double storlek;
        private String enhet;

        public Mangd(double storlek, String enhet) {
            this.storlek = storlek;
            this.enhet = enhet;
        }

        public double getStorlek() {
            return storlek;
        }

        public String getEnhet() {
            return enhet;
        }
    }


}
