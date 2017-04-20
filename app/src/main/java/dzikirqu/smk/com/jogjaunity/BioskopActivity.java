package dzikirqu.smk.com.jogjaunity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
//import dzikirqu.smk.com.jogjaunity.Adapters.AdapterBioskop;
import dzikirqu.smk.com.jogjaunity.Adapters.AdapterBioskop;
import dzikirqu.smk.com.jogjaunity.Gson.GsonBioskop;

public class BioskopActivity extends AdapterBioskop {

    @InjectView(R.id.rvBioskop)
    RecyclerView rvBioskop;
    @InjectView(R.id.swipeRefreshBioskop)
    SwipeRefreshLayout swipeRefreshBioskop;
    RequestQueue requestQueueBioskop;
    StringRequest stringRequestBioskop;
    GsonBioskop gsonBioskop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bioskop);
        ButterKnife.inject(this);

        swipeRefreshBioskop.setColorSchemeResources(R.color.colorPrimaryBioskop);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvBioskop.setLayoutManager(llm);


        swipeRefreshBioskop.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                proses();
            }
        });


        proses();

    }

    private void proses() {

        swipeRefreshBioskop.setRefreshing(true);

        rvBioskop.setVisibility(View.INVISIBLE);

        requestQueueBioskop = Volley.newRequestQueue(BioskopActivity.this);

        String url = "http://ibacor.com/api/jadwal-bioskop?k=a2cd2ed95d54a1b30cf7069b2ca6724e&id=23";


        stringRequestBioskop = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                gsonBioskop = gson.fromJson(response, GsonBioskop.class);
                AdapterRecyclerBioskop adapter = new AdapterRecyclerBioskop(getApplicationContext(), gsonBioskop.dataBioskop,gsonBioskop);
                rvBioskop.setAdapter(adapter);

                swipeRefreshBioskop.setRefreshing(false);

                rvBioskop.setVisibility(View.VISIBLE);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "err", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        requestQueueBioskop.add(stringRequestBioskop);


    }

}
