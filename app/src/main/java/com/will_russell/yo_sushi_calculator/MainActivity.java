package com.will_russell.yo_sushi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView green_tv;
    TextView blue_tv;
    TextView purple_tv;
    TextView orange_tv;
    TextView pink_tv;
    TextView grey_tv;
    TextView price_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        green_tv = (TextView) findViewById(R.id.green_total);
        blue_tv = (TextView) findViewById(R.id.blue_total);
        purple_tv = (TextView) findViewById(R.id.purple_total);
        orange_tv = (TextView) findViewById(R.id.orange_total);
        pink_tv = (TextView) findViewById(R.id.pink_total);
        grey_tv = (TextView) findViewById(R.id.grey_total);
        price_tv = (TextView) findViewById(R.id.total_cost_text);
    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.green_left_button:
                remove(green_tv);
                break;
            case R.id.blue_left_button:
                remove(blue_tv);
                break;
            case R.id.purple_left_button:
                remove(purple_tv);
                break;
            case R.id.orange_left_button:
                remove(orange_tv);
                break;
            case R.id.pink_left_button:
                remove(pink_tv);
                break;
            case R.id.grey_left_button:
                remove(grey_tv);
                break;
            case R.id.green_right_button:
                add(green_tv);
                break;
            case R.id.blue_right_button:
                add(blue_tv);
                break;
            case R.id.purple_right_button:
                add(purple_tv);
                break;
            case R.id.orange_right_button:
                add(orange_tv);
                break;
            case R.id.pink_right_button:
                add(pink_tv);
                break;
            case R.id.grey_right_button:
                add(grey_tv);
                break;
        }
    }

    public void add(TextView tv) {
        System.out.println("Adding");
        String text = tv.getText().toString();
        int value = Integer.parseInt(text);
        value++;
        tv.setText(String.valueOf(value));
        increasePrice(tv);
    }

    public void remove(TextView tv) {
        System.out.println("Removing");
        String text = tv.getText().toString();
        int value = Integer.parseInt(text);
        if (value != 0) {
            value--;
            tv.setText(String.valueOf(value));
            decreasePrice(tv);
        }
    }

    public void increasePrice(TextView tv) {

        if (tv.equals(green_tv)) {
            changePrice(2.30);
        } else if (tv.equals(blue_tv)) {
            changePrice(3.00);
        } else if (tv.equals(purple_tv)) {
            changePrice(4.00);
        } else if (tv.equals(orange_tv)) {
            changePrice(4.50);
        } else if (tv.equals(pink_tv)) {
            changePrice(5.00);
        } else if (tv.equals(grey_tv)) {
            changePrice(5.50);
        }
    }

    public void decreasePrice(TextView tv) {
        if (tv.equals(green_tv)) {
            changePrice(-2.30);
        } else if (tv.equals(blue_tv)) {
            changePrice(-3.00);
        } else if (tv.equals(purple_tv)) {
            changePrice(-4.00);
        } else if (tv.equals(orange_tv)) {
            changePrice(-4.50);
        } else if (tv.equals(pink_tv)) {
            changePrice(-5.00);
        } else if (tv.equals(grey_tv)) {
            changePrice(-5.50);
        }
    }

    public void changePrice(double change) {
        String text = price_tv.getText().toString();
        double value = Double.parseDouble(text.substring(1));
        value += change;
        value = Math.round(value * 100d) / 100d;
        String total = "£" + String.valueOf(value) + 0;
        price_tv.setText(total);
    }

    public void clear(View v) {
        green_tv.setText("0");
        blue_tv.setText("0");
        purple_tv.setText("0");
        orange_tv.setText("0");
        pink_tv.setText("0");
        grey_tv.setText("0");
        price_tv.setText("£0.00");
    }
}