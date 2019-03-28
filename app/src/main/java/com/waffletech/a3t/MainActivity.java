package com.waffletech.a3t;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public String player = "X";

    public int[][] winPosition = {
            { 0, 1, 2 },
            { 3, 4, 5 },
            { 6, 7, 8 },
            { 0, 3, 6 },
            { 1, 4, 7 },
            { 2, 5, 8 },
            { 0, 4, 8 },
            { 2, 4, 6 }
    };

    public String[] boardPosition = new String[9];

    public void onClick(View view) {
        ImageView imageView = (ImageView) view;
        int currentPosition = Integer.parseInt(view.getTag().toString());
        String lastPlayer = player;

        if (lastPlayer == "X") {
            imageView.setImageResource(R.drawable.x);
            boardPosition[currentPosition] = lastPlayer;
            player = "O";
        } else {
            imageView.setImageResource(R.drawable.o);
            boardPosition[currentPosition] = lastPlayer;
            player = "X";
        }

        for (int[] position : winPosition) {
            if (boardPosition[position[0]] == boardPosition[position[1]]
                    && boardPosition[position[1]] == boardPosition[position[2]]
                    && boardPosition[position[0]] != null) {

                Toast.makeText(this, lastPlayer + " Win!!", Toast.LENGTH_SHORT).show();
                break;
            }
        }

        Log.d("info", Arrays.toString(boardPosition));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
