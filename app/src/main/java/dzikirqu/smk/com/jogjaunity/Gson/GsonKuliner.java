package dzikirqu.smk.com.jogjaunity.Gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mayburger on 4/19/2017.
 */

public class GsonKuliner {

    @SerializedName("kuliner")
    public List<Kuliner> dataKuliner;

    public class Kuliner {
        @SerializedName("id_kuliner")
        public String id_kuliner;
        @SerializedName("id_kategori")
        public String id_kategoriKuliner;
        @SerializedName("kuliner")
        public String namaKuliner;
        @SerializedName("imgkuliner")
        public String imgKuliner;
        @SerializedName("isikuliner")
        public String isiKuliner;
    }
}
