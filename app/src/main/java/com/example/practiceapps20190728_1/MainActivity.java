package com.example.practiceapps20190728_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    RadioButton rb1, rb2;
    SearchView sv1;
    EditText et1;
    RatingBar star1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        rb1 = findViewById(R.id.radioButton1);
        rb2 = findViewById(R.id.radioButton2);
        sv1 = findViewById(R.id.searchView1);
        et1 = findViewById(R.id.editText1);
        star1 = findViewById(R.id.ratingBar1);
        tv1 = findViewById(R.id.textView1);

        btn1.setOnClickListener(clickJob1);
        rb1.setOnClickListener(clickJob2);
        rb2.setOnClickListener(clickJob3);

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                tv1.setText(editable);
            }
        });

        sv1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                tv1.setText(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                tv1.setText(s);
                return false;
            }
        });

        star1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //float starCount;
                //starCount = ratingBar.getNumStars();
                tv1.setText(Boolean.toString(b));
            }
        });

    }

    View.OnClickListener clickJob1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv1.setText(btn1.getText());
            Toast.makeText(MainActivity.this, btn1.getText(),Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener clickJob2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv1.setText(rb1.getText());
            Toast.makeText(MainActivity.this, rb1.getText(), Toast.LENGTH_SHORT).show();
        }
    };

    View.OnClickListener clickJob3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            tv1.setText(rb2.getText());
            Toast.makeText(MainActivity.this, rb2.getText(), Toast.LENGTH_SHORT).show();
        }
    };

}
