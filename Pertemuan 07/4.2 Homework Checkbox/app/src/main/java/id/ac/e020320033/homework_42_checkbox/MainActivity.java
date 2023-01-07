package id.ac.e020320033.homework_42_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String message = "Toppings: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Yumna - Homework");
        setContentView(R.layout.activity_main);
    }
    public void showToast(View view) {
        selectToppings((CheckBox)
                findViewById(R.id.chocolate_syrup), getString(R.string.chocolate_syrup));
        selectToppings((CheckBox)
                findViewById(R.id.sprinkles), getString(R.string.sprinkles));
        selectToppings((CheckBox)
                findViewById(R.id.crushned_nuts), getString(R.string.crushned_nuts));
        selectToppings((CheckBox)
                findViewById(R.id.cherries), getString(R.string.cherries));
        selectToppings((CheckBox)
                findViewById(R.id.orio_cookies_cumbles), getString(R.string.orio_cookies_cumbles));
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void selectToppings(CheckBox checkBox, String topping) {
        if (checkBox.isChecked()){
            if (!message.contains(topping)){
                message = message + " " + topping;
            }
        }
        else{
            if (message.contains(topping)){
                message = message.replace(" " + topping, "");
            }
        }
    }


}