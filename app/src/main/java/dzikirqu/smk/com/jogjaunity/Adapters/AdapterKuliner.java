package dzikirqu.smk.com.jogjaunity.Adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import dzikirqu.smk.com.jogjaunity.Gson.GsonKuliner;
import dzikirqu.smk.com.jogjaunity.Gson.GsonWisata;
import dzikirqu.smk.com.jogjaunity.R;
import dzikirqu.smk.com.jogjaunity.Server.URL;

/**
 * Created by Mayburger on 4/19/2017.
 */
    public class AdapterKuliner extends RecyclerView.Adapter<AdapterKuliner.ViewHolder> {

        Context context;
        public List<GsonKuliner.Kuliner> dataKuliner;

        public AdapterKuliner(Context context, List<GsonKuliner.Kuliner> dataKuliner) {
            this.context = context;
            this.dataKuliner = dataKuliner;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kuliner, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Glide.with(context)
                    .load(URL.URL_IMAGE + dataKuliner.get(position).imgKuliner)
                    .crossFade()
                    .placeholder(R.drawable.glidekuliner)
                    .into(holder.imgListKuliner);

            holder.tvListKuliner.setText(dataKuliner.get(position).namaKuliner);

        }

        @Override
        public int getItemCount() {
            return dataKuliner.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgListKuliner;
            TextView tvListKuliner;

            public ViewHolder(View itemView) {
                super(itemView);

                imgListKuliner = (ImageView)itemView.findViewById(R.id.imgListKuliner);
                tvListKuliner = (TextView) itemView.findViewById(R.id.tvListKuliner);
            }
        }
    }
