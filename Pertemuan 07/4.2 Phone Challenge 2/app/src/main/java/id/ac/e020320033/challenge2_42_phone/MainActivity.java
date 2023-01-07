package id.ac.e020320033.challenge2_42_phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Creates the activity and sets the view, then sets the listener to
     * detect if a key was pressed in the EditText view.
     *
     * @param savedInstanceState    Instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Yumna - Challenge 2 Phone");
        setContentView(R.layout.activity_main);


        EditText editText = findViewById(R.id.editText_main);

        if (editText != null)
            editText.setOnEditorActionListener(
                    (textView, actionId, keyEvent) -> {
                        boolean handled = false;
                        if (actionId == EditorInfo.IME_ACTION_SEND) {
                            dialNumber();
                            handled = true;
                        }
                        return handled;
                    });

    }

    private void dialNumber() {
        EditText editText = findViewById(R.id.editText_main);
        String phoneNum = null;

        if (editText != null) phoneNum = "tel:" + editText.getText().toString();

        Log.d(TAG, "dialNumber: " + phoneNum);

        Intent intent = new Intent(Intent.ACTION_DIAL);


        intent.setData(Uri.parse(phoneNum));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(TAG, "ImplicitIntents: Can't handle this!");
        }
    }
}