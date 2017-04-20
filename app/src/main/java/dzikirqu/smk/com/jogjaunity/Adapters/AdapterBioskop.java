package dzikirqu.smk.com.jogjaunity.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import dzikirqu.smk.com.jogjaunity.Gson.GsonBioskop;
import dzikirqu.smk.com.jogjaunity.R;

/**
 * Created by Mayburger on 2/27/2017.
 */
public class AdapterBioskop extends AppCompatActivity {

    public class AdapterRecyclerBioskop extends RecyclerView.Adapter<AdapterRecyclerBioskop.ViewHolder> {

        Context context;
        public List<GsonBioskop.DataBioskop> dataBioskop;
        GsonBioskop gsonBioskop;

        public AdapterRecyclerBioskop(Context context, List<GsonBioskop.DataBioskop> dataBioskop, GsonBioskop gsonBioskop) {
            this.context = context;
            this.dataBioskop = dataBioskop;
            this.gsonBioskop = gsonBioskop;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_jadwal, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.tvListTanggal.setText(gsonBioskop.tanggalBioskop);
            holder.tvListMovie.setText(gsonBioskop.dataBioskop.get(position).namaMovie);
            holder.tvListGenre.setText(gsonBioskop.dataBioskop.get(position).genreMovie);
            Typeface MontSerrat = Typeface.createFromAsset(getAssets(), "fonts/montserratregular.otf");
            Typeface ZonaBold = Typeface.createFromAsset(getAssets(), "fonts/zonabold.otf");
            Typeface ZonaThin = Typeface.createFromAsset(getAssets(), "fonts/zonathin.otf");
            holder.tvListMovie.setTypeface(ZonaBold);
            holder.tvListTanggal.setTypeface(MontSerrat);
            holder.tvListGenre.setTypeface(MontSerrat);

        }

        @Override
        public int getItemCount() {
            return dataBioskop.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvListTanggal, tvListMovie, tvListGenre;

            public ViewHolder(View itemView) {
                super(itemView);

                tvListTanggal = (TextView)itemView.findViewById(R.id.tvListTanggal);
                tvListMovie = (TextView)itemView.findViewById(R.id.tvListMovie);
                tvListGenre = (TextView)itemView.findViewById(R.id.tvListGenre);

            }
        }
    }


}
