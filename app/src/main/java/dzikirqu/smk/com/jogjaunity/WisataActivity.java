package dzikirqu.smk.com.jogjaunity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

import com.android.volley.AuthFailureError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import dzikirqu.smk.com.jogjaunity.Adapters.AdapterWisata;
import dzikirqu.smk.com.jogjaunity.Gson.GsonWisata;
import dzikirqu.smk.com.jogjaunity.Server.URL;

public class WisataActivity extends AdapterWisata {

    private RecyclerView rvWisata;
    private RequestQueue requestQueueWisata;
    private StringRequest stringRequestWisata;
    GsonWisata gsonWisata;
    private SwipeRefreshLayout swipeRefreshWisata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        swipeRefreshWisata = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshWisata);
        swipeRefreshWisata.setColorSchemeResources(R.color.colorPrimaryWisata);


        rvWisata = (RecyclerView) findViewById(R.id.rvWisata);
        GridLayoutManager llm = new GridLayoutManager(this, 2);
        llm.setOrientation(GridLayoutManager.VERTICAL);
        rvWisata.setLayoutManager(llm);


        swipeRefreshWisata.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                proses();
            }
        });


        proses();

    }

    private void proses() {

        swipeRefreshWisata.setRefreshing(true);

        String Url = URL.URL_WISATA;

        rvWisata.setVisibility(View.INVISIBLE);

        requestQueueWisata = Volley.newRequestQueue(WisataActivity.this);


        stringRequestWisata = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                gsonWisata = gson.fromJson(response, GsonWisata.class);
                AdapterRecyclerWisata adapter = new AdapterRecyclerWisata(getApplicationContext(), gsonWisata.dataWisata);
                rvWisata.setAdapter(adapter);

                swipeRefreshWisata.setRefreshing(false);

                rvWisata.setVisibility(View.VISIBLE);


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

        requestQueueWisata.add(stringRequestWisata);


    }

}
