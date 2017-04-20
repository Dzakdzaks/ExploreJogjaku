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

import dzikirqu.smk.com.jogjaunity.Gson.GsonOleh;
import dzikirqu.smk.com.jogjaunity.Gson.GsonWisata;
import dzikirqu.smk.com.jogjaunity.R;
import dzikirqu.smk.com.jogjaunity.Server.URL;

/**
 * Created by Mayburger on 4/19/2017.
 */
public class AdapterOleh extends AppCompatActivity {

    public class AdapterRecyclerOleh extends RecyclerView.Adapter<AdapterRecyclerOleh.ViewHolder> {

        Context context;
        public List<GsonOleh.DataOleh> dataOleh;

        public AdapterRecyclerOleh(Context context, List<GsonOleh.DataOleh> dataOleh) {
            this.context = context;
            this.dataOleh = dataOleh;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_oleh, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Glide.with(context)
                    .load(URL.URL_IMAGE + dataOleh.get(position).imgOleh)
                    .crossFade()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(holder.imgListOleh);

            holder.tvListOleh.setText(dataOleh.get(position).namaOleh);

        }

        @Override
        public int getItemCount() {
            return dataOleh.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imgListOleh;
            TextView tvListOleh;

            public ViewHolder(View itemView) {
                super(itemView);

                imgListOleh = (ImageView)itemView.findViewById(R.id.imgListOleh);
                tvListOleh = (TextView) itemView.findViewById(R.id.tvListOleh);
            }
        }
    }
}
