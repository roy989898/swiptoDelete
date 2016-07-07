package pom.poly.com.tryhorizontalroll;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.SimpleCallback;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvList)
    RecyclerView rvList;
    int i = 0;
    private MyAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private String[] as;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rvList.setHasFixedSize(true);

        // use a linear layout manager


        mLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
         as = new String[]{"a", "2", "B", "c", "D", "a", "2", "B", "c", "D", "a", "2", "B", "c", "D", "a", "2", "B", "c", "D"};
        ArrayList<String> stringArrayList=new ArrayList<>(Arrays.asList(as));
        mAdapter = new MyAdapter(stringArrayList);
        rvList.setAdapter(mAdapter);


        ItemTouchHelper.SimpleCallback callback=new SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                switch (direction){
                    case ItemTouchHelper.LEFT:
                        int position=viewHolder.getPosition();
                        mAdapter.remove(position);
                        break;
                }

            }
        };
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rvList);


    }
}
