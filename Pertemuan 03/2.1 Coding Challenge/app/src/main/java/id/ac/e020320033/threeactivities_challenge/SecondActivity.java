package id.ac.e020320033.threeactivities_challenge;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView scrollTextView;
    TextView headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        scrollTextView = findViewById(R.id.article);
        headerView = findViewById(R.id.article_heading);


        headerView.setText(intent.getStringExtra(MainActivity.TITLE));
        switch (intent.getStringExtra(MainActivity.CHOICE)) {
            case "one":
                scrollTextView.setText(R.string.isicerita1);
                break;
            case "two":
                scrollTextView.setText(R.string.isicerita2);
                break;
            case "three":
                scrollTextView.setText(R.string.isicerita3);
                break;
            default:
                throw new IllegalStateException("Unexpected Value: "
                        + intent.getStringExtra(MainActivity.CHOICE));
        }
    }
}