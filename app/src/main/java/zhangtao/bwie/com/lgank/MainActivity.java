package zhangtao.bwie.com.lgank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ImmerSionUtil.ImmersionUtils;

public class MainActivity extends AppCompatActivity {
    private int times = 4;
    private TextView time_dao;
    private Button btn_entry;
    private Handler ler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ImmersionUtils().setImmersion(getWindow(),getSupportActionBar());
        time_dao = (TextView) findViewById(R.id.time_dao);
        btn_entry = (Button) findViewById(R.id.btn_entry);
        ler.postDelayed(runs,0);
    }
    Runnable runs = new Runnable() {
        @Override
        public void run() {
            times--;
            ler.postDelayed(this,1000);
            time_dao.setText(times+"s");
            if(times == 0) {
                Intent intent = new Intent(MainActivity.this,Two_activity.class);
                startActivity(intent);
                finish();
            }else {
                btn_entry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,Two_activity.class);
                        startActivity(intent);
                        //结束线程
                        ler.removeCallbacks(runs);
                        finish();
                    }
                });
            }
        }
    };
}
