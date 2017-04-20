package dzikirqu.smk.com.jogjaunity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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
import dzikirqu.smk.com.jogjaunity.Adapters.AdapterOleh;
import dzikirqu.smk.com.jogjaunity.Gson.GsonOleh;
import dzikirqu.smk.com.jogjaunity.Gson.GsonWisata;
import dzikirqu.smk.com.jogjaunity.Server.URL;

public class OlehActivity extends AdapterOleh {

    @InjectView(R.id.rvOleh)
    RecyclerView rvOleh;
    @InjectView(R.id.swipeRefreshOleh)
    SwipeRefreshLayout swipeRefreshOleh;
    private RequestQueue requestQueueOleh;
    private StringRequest stringRequestOleh;
    GsonOleh gsonOleh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oleh);
        ButterKnife.inject(this);

        swipeRefreshOleh.setColorSchemeResources(R.color.colorPrimaryWisata);

        GridLayoutManager llm = new GridLayoutManager(this, 2);
        llm.setOrientation(GridLayoutManager.VERTICAL);
        rvOleh.setLayoutManager(llm);


        swipeRefreshOleh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                proses();
            }
        });


        proses();

    }

    private void proses() {

        swipeRefreshOleh.setRefreshing(true);

        String Url = URL.URL_OLEH;

        rvOleh.setVisibility(View.INVISIBLE);

        requestQueueOleh = Volley.newRequestQueue(OlehActivity.this);


        stringRequestOleh = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                gsonOleh = gson.fromJson(response, GsonOleh.class);
                AdapterRecyclerOleh adapter = new AdapterRecyclerOleh(getApplicationContext(), gsonOleh.dataOleh);
                rvOleh.setAdapter(adapter);

                swipeRefreshOleh.setRefreshing(false);

                rvOleh.setVisibility(View.VISIBLE);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };

        requestQueueOleh.add(stringRequestOleh);


    }

}
