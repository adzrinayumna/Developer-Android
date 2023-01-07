package id.ac.e020320033.challenge_shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("msg", getString(R.string.keju));
            startActivity(intent);
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("msg", getString(R.string.nasi));
            startActivity(intent);
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("msg", getString(R.string.apel));
            startActivity(intent);
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("msg", getString(R.string.roti));
            startActivity(intent);
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("msg", getString(R.string.susu));
            startActivity(intent);
        });

    }

    }

