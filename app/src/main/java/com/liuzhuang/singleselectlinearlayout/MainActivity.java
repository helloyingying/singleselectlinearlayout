package com.liuzhuang.singleselectlinearlayout;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.liuzhuang.library.ISingleSelectCallback;
import com.liuzhuang.library.SingleSelectLinearLayout;


public class MainActivity extends ActionBarActivity implements ISingleSelectCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((SingleSelectLinearLayout) findViewById(R.id.single_select_test)).setDefaultSelectedPosition(2).initChildClickListener(this);
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

    @Override
    public void onItemSelected(View view) {
        int id = view.getId();
        if (id == R.id.layout4) {
            TextView t1 = (TextView)view.findViewById(R.id.t1);
            TextView t2 = (TextView) view.findViewById(R.id.t2);
            t1.setTextColor(Color.RED);
            t2.setTextColor(Color.RED);
        } else {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.RED);
            }
        }
    }

    @Override
    public void onItemUnSelected(View view) {
        int id = view.getId();
        if (id == R.id.layout4) {
            TextView t1 = (TextView)view.findViewById(R.id.t1);
            TextView t2 = (TextView) view.findViewById(R.id.t2);
            t1.setTextColor(Color.BLACK);
            t2.setTextColor(Color.BLACK);
        } else {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(Color.BLACK);
            }
        }
    }
}
