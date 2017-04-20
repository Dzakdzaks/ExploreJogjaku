package dzikirqu.smk.com.jogjaunity.Gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mayburger on 4/19/2017.
 */

public class GsonWisata {

    @SerializedName("data")
    public List<Wisata> dataWisata;

    public class Wisata {
        @SerializedName("id_wisata")
        public String id_wisata;
        @SerializedName("wisata")
        public String namaWisata;
        @SerializedName("isiwisata")
        public String isiWisata;
        @SerializedName("imgwisata")
        public String imgWisata;
        @SerializedName("lokasi")
        public String lokasiWisata;
        @SerializedName("harga")
        public String hargaWisata;
    }
}
