package com.example.testpopuwindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testpopuwindow.spinnerList.SimplePopHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private String TAG = "MainActivity";
    private SimplePopHelper simplePopHelper;
    private Button button;
    private ArrayList<String> strings;
    private Button btnRefresh;
    private Button btnAddEach;
    private Button btnAddList;

    /**
     * 提供 simplePopHelper,然后加入具体的数据即可;
     *
     */


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        simplePopHelper = new SimplePopHelper(this)
        {
            @Override
            public void onItemClickCB(int position, String itemText)
            {
                Toast.makeText(MainActivity.this, "position:" + position + ", itemText:" + itemText, Toast.LENGTH_SHORT).show();
            }
        };

        strings = new ArrayList<>();
        simplePopHelper.refreshData(strings, 0);
    }
  
}
