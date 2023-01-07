package id.ac.e020320033.threeactivities_challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String CHOICE =
            "id.ac.e020320033.threeactivities_challenge.CHOICE";
    public static final String TITLE =
            "id.ac.e020320033.threeactivities_challenge.TITLE";

    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, SecondActivity.class);
    }

    public void launchOne(View view) {
        intent.putExtra(CHOICE, "one");
        intent.putExtra(TITLE,"Cinderella");
        startActivity(intent);
    }

    public void launchTwo(View view) {
        intent.putExtra(CHOICE, "two");
        intent.putExtra(TITLE,"Cinderella");
        startActivity(intent);
    }

    public void launchThree(View view) {
        intent.putExtra(CHOICE, "three");
        intent.putExtra(TITLE,"Cinderella");
        startActivity(intent);
    }
}


