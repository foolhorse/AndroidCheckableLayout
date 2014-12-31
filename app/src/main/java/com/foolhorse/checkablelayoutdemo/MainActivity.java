package com.foolhorse.checkablelayoutdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;

import com.foolhorse.checkablelayout.CheckableFrameLayout;
import com.foolhorse.checkablelayout.CheckableLinearLayout;
import com.foolhorse.checkablelayout.CheckableRelativeLayout;
import com.foolhorse.checkablelayout.OnCheckedChangeListener;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Checkable) v).toggle();
            }
        };
        OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View view, boolean isChecked) {
                Toast.makeText(MainActivity.this, "View:" + view + " checked change to : " + isChecked, Toast.LENGTH_SHORT).show();
            }
        };

        CheckableFrameLayout fl = (CheckableFrameLayout) findViewById(R.id.fl);
        CheckableLinearLayout ll = (CheckableLinearLayout) findViewById(R.id.ll);
        CheckableRelativeLayout rl = (CheckableRelativeLayout) findViewById(R.id.rl);


        fl.setOnClickListener(onClickListener);
        ll.setOnClickListener(onClickListener);
        rl.setOnClickListener(onClickListener);

        fl.setOnCheckedChangeListener(onCheckedChangeListener);
        ll.setOnCheckedChangeListener(onCheckedChangeListener);
        rl.setOnCheckedChangeListener(onCheckedChangeListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
