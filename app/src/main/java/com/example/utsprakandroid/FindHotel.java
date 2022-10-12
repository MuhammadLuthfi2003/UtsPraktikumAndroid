package com.example.utsprakandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FindHotel extends AppCompatActivity {

    //array of numbers
    String[] amount = {"1","2","3","4"};
    private String SpinnerLabel = "";
    String date = "";
    String checkInDate = "";
    String checkOutDate = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_hotel);

        //get the two buttons to spawn a datepicker fragment
        Button checkInButton = (Button) findViewById(R.id.checkInDate);
        Button checkOutButton = (Button) findViewById(R.id.checkOutDate);

        //get two text
        TextView checkInDisplay = (TextView) findViewById(R.id.textCheckIn);
        TextView checkOutDisplay = (TextView) findViewById(R.id.textCheckOut);


        //find the button to redirect to the hotel lists
        Button search = (Button) findViewById(R.id.button_search);

        checkInButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 DialogFragment newFragment = new DatePicker();

                 newFragment.show(getSupportFragmentManager(),
                         getString(R.string.date_picker));

                 checkInDisplay.setText(checkInDate);

             }
         });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new DatePicker_2(); //fragments are split into two depending on which one is touched

                newFragment.show(getSupportFragmentManager(),
                        getString(R.string.date_picker));

                checkOutDisplay.setText(checkOutDate);

            }
        });

        //goes to the recyclerview interface
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HotelLists.class);
                intent.putExtra("check_in", checkInDate);
                intent.putExtra("check_out", checkOutDate);
                intent.putExtra("room", SpinnerLabel);
                startActivity(intent);
            }
        });


        // make the spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_kamar);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.jumlah_kamar, android.R.layout.simple_spinner_item );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerLabel = parent.getItemAtPosition(position).toString();
                System.out.println(SpinnerLabel);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //processdatepicker method
    public void processDatePicker(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        checkInDate = dateMessage;

    }

    public void processDatePicker2(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string + "/" + day_string + "/" + year_string);
        checkOutDate = dateMessage;

    }

}