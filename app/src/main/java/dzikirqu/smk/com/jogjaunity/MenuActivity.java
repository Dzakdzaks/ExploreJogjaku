package dzikirqu.smk.com.jogjaunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MenuActivity extends AppCompatActivity {

    @InjectView(R.id.cardWisata)
    CardView cardWisata;
    @InjectView(R.id.cardKuliner)
    CardView cardKuliner;
    @InjectView(R.id.cardBioskop)
    CardView cardBioskop;
    @InjectView(R.id.cardOleh)
    CardView cardOleh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.inject(this);

        cardWisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WisataActivity.class));
            }
        });

        cardKuliner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), KulinerActivity.class));
            }
        });

        cardBioskop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BioskopActivity.class));
            }
        });

        cardOleh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OlehActivity.class));
            }
        });

    }
}
