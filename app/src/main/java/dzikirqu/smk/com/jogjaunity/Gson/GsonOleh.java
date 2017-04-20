package dzikirqu.smk.com.jogjaunity.Gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mayburger on 4/20/2017.
 */

public class GsonOleh {
    @SerializedName("data")
    public List<DataOleh> dataOleh;

    public class DataOleh{
        @SerializedName("id_oleh")
        public String id_oleh;
        @SerializedName("oleh")
        public String namaOleh;
        @SerializedName("isioleh")
        public String isiOleh;
        @SerializedName("imgoleh")
        public String imgOleh;
    }
}
