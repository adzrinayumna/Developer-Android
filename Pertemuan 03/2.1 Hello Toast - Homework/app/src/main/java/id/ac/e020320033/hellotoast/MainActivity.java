package id.ac.e020320033.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    public static final String COUNT =
            "id.ac.e020320033.hellotoast.COUNT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
    }
    public void showToast(View view) {
//        Toast toast = Toast.makeText(this, "hello toast!",
//                Toast.LENGTH_SHORT);
//        toast.show();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(COUNT, Integer.parseInt(mShowCount.getText().toString()));
        startActivity(intent);

    }
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
        }
    }


}