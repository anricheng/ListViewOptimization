package scanner.chou.aric.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        final List<String> list= new ArrayList();

        for (int i = 0; i <100 ; i++) {

            list.add("这是第"+i+"个数据");

        }

        listView.setAdapter(new CommonAdapter<String>(list,MainActivity.this,R.layout.listview_item) {
            @Override
            public void convert(ViewHolder viewHolder, String s) {
                viewHolder.setText(R.id.li_tv,s);
            }
        });
    }
}
