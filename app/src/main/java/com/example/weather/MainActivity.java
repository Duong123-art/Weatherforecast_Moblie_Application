package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.APIService.APIService;
import com.example.weather.model.Weatherforecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity {
    private static final String APIkey = "28fc9310b6afe62f6c02871a74fda4c0";
    private TextView apicountry;
    private TextView apitemp;
    private Button searchbtn;
    private TextView apistatus;
    private TextView Tempmin;
    private TextView Tempmax;
    private TextView windspeed;
    private TextView visibility;
    private TextView sunrise;
    private TextView sunset;
    private TextView humidity;
    private SearchView searchany;
    private CharSequence querySearch;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        apicountry = (TextView) findViewById(R.id.apicountry);
        apitemp = (TextView) findViewById(R.id.apitemp);
        apistatus = (TextView) findViewById(R.id.apistatus);

        Tempmin = (TextView) findViewById(R.id.temp_min);
        Tempmax = (TextView) findViewById(R.id.temp_max);
        windspeed = (TextView) findViewById(R.id.wind_speed);
       visibility = (TextView) findViewById(R.id.visibility);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunset = (TextView) findViewById(R.id.sunset);
        humidity = (TextView) findViewById(R.id.humidity);
        imageview = (ImageView) findViewById(R.id.image);

        searchany = (SearchView) findViewById(R.id.searchview);
        querySearch = searchany.getQuery();
        searchany.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getAPI();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                querySearch = searchany.getQuery();
                return false;
            }
        });
        searchbtn = (Button) findViewById(R.id.searchbtn);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAPI();
            }
        });
    }

    private void getAPI() {
        APIService.apiservice.getInforWeather( querySearch, APIkey).enqueue(new Callback<Weatherforecast>() {
            @Override
            public void onResponse(Call<Weatherforecast> call, Response<Weatherforecast> response) {
                Weatherforecast weatherforecast = response.body();

                if(weatherforecast != null){
                    apicountry.setText(weatherforecast.getName());

                    apitemp.setText(String.valueOf(round(weatherforecast.getMain().getTemp() - 273)) + "°C");

                    apistatus.setText(weatherforecast.getWeather().get(0).getMain());

                    Tempmin.setText("Temperature min: " + String.valueOf(round(weatherforecast.getMain().getTemp_min() - 273)) + "°C");

                    Tempmax.setText("Temperature max: " + String.valueOf(round(weatherforecast.getMain().getTemp_max() - 273)) + "°C");

                    windspeed.setText("Wind speed: " + String.valueOf(weatherforecast.getWind().getSpeed()) + "m/s");

                    sunrise.setText("Sunrise: " + String.valueOf(weatherforecast.getSys().getSunrise()) + "s");

                    sunset.setText("Sunset: " + String.valueOf(weatherforecast.getSys().getSunset()) + "s");

                    humidity.setText("Humidity: " + String.valueOf(weatherforecast.getMain().getHumidity()) + "%");

                    visibility.setText("Visibility: " + String.valueOf(weatherforecast.getVisibility()/1000) + "km");
                    switch(weatherforecast.getWeather().get(0).getMain()){
                        case "Clouds":
                            imageview.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cloud1));
                            break;
                        case "Clear":
                            imageview.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.sun1));
                            break;
                        case "Rain":
                            imageview.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.rain));
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Please enter your country!!!", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<Weatherforecast> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR!!!!", Toast.LENGTH_SHORT )
                        .show();
            }
        });
    }
}