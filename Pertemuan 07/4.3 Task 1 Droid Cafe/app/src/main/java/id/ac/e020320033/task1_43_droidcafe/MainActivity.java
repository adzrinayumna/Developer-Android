package id.ac.e020320033.task1_43_droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import id.ac.e020320033.task1_43_droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =
            "id.ac.e020320033.task1_43_droidcafe.extra.MESSAGE";

    private String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Yumna - Task 1 Droid Cafe");
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v-> {
            Intent intent = new Intent(this, OrderActivity.class);
            intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
            startActivity(intent);
        });

        ImageView imDonut = findViewById(R.id.donut);
        ImageView imIceCream = findViewById(R.id.ice_cream);
        ImageView imFroyo = findViewById(R.id.froyo);

        imDonut.setOnClickListener(view ->
                Toast.makeText(MainActivity.this,
                        mOrderMessage = getString(R.string.donut_order_message),
                        Toast.LENGTH_SHORT).show()
        );

        imIceCream.setOnClickListener(view ->
                Toast.makeText(MainActivity.this,
                        mOrderMessage = getString(R.string.ice_cream_order_message),
                        Toast.LENGTH_SHORT).show()
        );

        imFroyo.setOnClickListener(view ->
                Toast.makeText(MainActivity.this,
                        mOrderMessage = getString(R.string.froyo_order_message),
                        Toast.LENGTH_SHORT).show()
        );
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
        if (id == R.id.action_order) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}