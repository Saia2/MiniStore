package com.example.student.ministore;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView numberTextView;
    int numberOfPeople = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberTextView = findViewById(R.id.number);
    }

    public void submitOrder(View view) {

        CheckBox brazilCheckBox = (CheckBox) findViewById(R.id.brazil);
        boolean hasBrazil = brazilCheckBox.isChecked();
        CheckBox kenyaCheckBox = (CheckBox) findViewById(R.id.kenya);
        boolean hasKenya = kenyaCheckBox.isChecked();
        CheckBox japanCheckBox = (CheckBox) findViewById(R.id.japan);
        boolean hasJapan = japanCheckBox.isChecked();

        displayQuantity(numberOfPeople);
        int price = calculatePrice(hasBrazil, hasKenya, hasJapan)
        displayPrice(price);

        String orderMessage = "Name:" + nameEditText.getText().toString() + "\n" +
                "Brazil: " + hasBrazil + "\n" +
                "Kenya: " + hasKenya + "\n" +
                "Japan" + hasJapan + "\n" +
                "Number of People: " + numberOfPeople + "\n" +
                "Total: $" + price;

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "DaScoop Order");
        intent.putExtra(Intent.EXTRA_TEXT, orderMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    private void displayQuantity(int numberOfPeople) {

    }

    public void increase(View view) {
        number++;
        numberTextView.setText("" + number);
    }

    public void decrease(View view) {
        number--;
        numberTextView.setText("" + number);
    }

}

    private int calculatePrice(boolean hasBrazil, boolean hasKenya, boolean hasJapan) {
    }

    }
    private void displayPrice(int price) {
