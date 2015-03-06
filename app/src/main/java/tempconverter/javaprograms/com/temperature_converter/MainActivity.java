package tempconverter.javaprograms.com.temperature_converter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    private EditText tempEditText;
    private Button celsiusButton;
    private Button farenButton;
    private Button kelvinButton;
    private Button fahKelvinButton;
    private TextView showTempTextView;

    DecimalFormat round = new DecimalFormat("0.0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempEditText = (EditText) findViewById(R.id.editText2);
        celsiusButton = (Button) findViewById(R.id.CelsiusButtonId);
        farenButton = (Button) findViewById(R.id.FButtonId);
        kelvinButton = (Button) findViewById(R.id.KbuttonId);
        showTempTextView = (TextView) findViewById(R.id.showResultTextView);

        //Set up our buttons event listeners
        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call the convert to celsius method
                //we are assigning to variables so that it is easier to manipulate and use them

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    //make sure the user has entered something, if he hasn't
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else{
                    //we are good
                    //We are taking the text and converting it into an integer
                    double doubleEditText = Double.parseDouble(editTextVal);
                    double convertedVal = convertToCelsius(doubleEditText);
                    double convertedVal2 = KeltoCelsius(doubleEditText);
                    String result = String.valueOf(round.format(convertedVal));
                    String result2 = String.valueOf(round.format(convertedVal2));
                    showTempTextView.setText(editTextVal + " F = " + result + " C" +
                            "\n" + editTextVal+" K = " + result2 + " C");


                }
            }
        });

        farenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call the convert to fahrenheit method

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else{
                    //we are good
                    double doubleEditText = Double.parseDouble(editTextVal);
                    double convertedVal2 = KeltoFahren(doubleEditText);
                    double convertedVal = convertToFaren(doubleEditText);
                    String result = String.valueOf(round.format(convertedVal));
                    String result2 = String.valueOf(round.format(convertedVal2));
                    showTempTextView.setText(editTextVal+ " C = " + result + " F"
                            + "\n" + editTextVal + " K = " + result2 + " F");
                }
            }
        });

        kelvinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //call to convert celsius to kelvin method

                String editTextVal = tempEditText.getText().toString();

                if(editTextVal.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Enter a value", Toast.LENGTH_LONG).show();
                }else{
                    //we are good
                    double doubleEditText = Double.parseDouble(editTextVal);
                    double convertedVal2 = FahconvertToKelvin(doubleEditText);
                    double convertedVal = convertToKelvin(doubleEditText);
                    String result = String.valueOf(round.format(convertedVal));
                    String result2 = String.valueOf(round.format(convertedVal2));
                    showTempTextView.setText(editTextVal +" C = "+ result + " K" +
                            "\n" + editTextVal + " F = " + result2 + " K");
                }
            }
        });

    }
    public double convertToCelsius(double farenV){
        //[°C] = ([°F] − 32) × 5/9
        double resultCel;
        resultCel = (farenV - 32) * 5/9;
        return resultCel;
    }

    public double convertToKelvin(double celsiusV){
        //[K] = [°C] + 273.15
        double resultKel;
        resultKel = (celsiusV) + 273.15;
        return resultKel;
    }
    public double convertToFaren(double celV){
        //[°F] = [°C] × 9/5 + 32
        double resultFahren;
        resultFahren = (celV) * 9/5 + 32;
        return resultFahren;
    }

    public double FahconvertToKelvin(double fahrenheitV){
        //[K] = ([°F] + 459.67) × 5/9
        double resultKel;
        resultKel = (fahrenheitV + 459.67) * 5/9;
        return resultKel;
    }

    public double KeltoCelsius(double kelVal1){
        //[°C] = [K] − 273.15
        double resultKelVal1;
        resultKelVal1 = (kelVal1) - 273.15;
        return resultKelVal1;
    }

    public double KeltoFahren(double kelV2){
        //[°F] = [K] × 9/5 − 459.67
        double resultkelV2;
        resultkelV2 = (kelV2 * 9/5) - 459.67;
        return resultkelV2;
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
