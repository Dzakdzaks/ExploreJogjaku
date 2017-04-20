package dzikirqu.smk.com.jogjaunity.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import dzikirqu.smk.com.jogjaunity.Gson.GsonWisata;
import dzikirqu.smk.com.jogjaunity.R;
import dzikirqu.smk.com.jogjaunity.Server.URL;
import dzikirqu.smk.com.jogjaunity.WisataActivity;

/**
 * Created by Mayburger on 4/19/2017.
 */
public class AdapterWisata extends AppCompatActivity {

    public class AdapterRecyclerWisata extends RecyclerView.Adapter<AdapterRecyclerWisata.ViewHolder> {

        Context context;
        public List<GsonWisata.Wisata> dataWisata;

        public AdapterRecyclerWisata(Context context, List<GsonWisata.Wisata> dataWisata) {
            this.context = context;
            this.dataWisata = dataWisata;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_wisata, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Glide.with(context)
                    .load(URL.URL_IMAGE + dataWisata.get(position).imgWisata)
                    .crossFade()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgListWisata);

            holder.tvListWisata.setText(dataWisata.get(position).namaWisata);

        }

        @Override
        public int getItemCount() {
            return dataWisata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgListWisata;
            TextView tvListWisata;

            public ViewHolder(View itemView) {
                super(itemView);

                imgListWisata = (ImageView)itemView.findViewById(R.id.imgListWisata);
                tvListWisata = (TextView) itemView.findViewById(R.id.tvListWisata);
            }
        }
    }
}
