package dzikirqu.smk.com.jogjaunity.Gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mayburger on 4/20/2017.
 */

public class GsonBioskop {
    @SerializedName("date")
    public String tanggalBioskop;

    @SerializedName("kota")
    public String namaKota;

    @SerializedName("data")
    public List<DataBioskop> dataBioskop;


    public class DataBioskop {
        @SerializedName("movie")
        public String namaMovie;

        @SerializedName("genre")
        public String genreMovie;

        @SerializedName("duration")
        public String durasiMovie;

        @SerializedName("jadwal")
        public List<DataJadwal> dataJadwal;

        public class DataJadwal {
            @SerializedName("biosko")
            public String namaBioskop;
        }

        @SerializedName("harga")
        public String hargaBioskop;
    }
}

