package brg.utils.jhy.brggo;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import brg.utils.jhy.brggo.data.Hotel;
import brg.utils.jhy.brggo.data.HotelBrand;
import brg.utils.jhy.brggo.data.HotelCity;
import brg.utils.jhy.brggo.data.HotelName;
import brg.utils.jhy.brggo.data.HotelRegion;
import brg.utils.jhy.brggo.utils.Constant;

public class MainActivity extends AppCompatActivity {
    Calendar arrCalendar = Calendar.getInstance();
    Calendar depCalendar = Calendar.getInstance();
    Hotel hotels = Constant.getInstance().getHotels();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "ㅁㅇㄹ.", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Toast toast = Toast.makeText(MainActivity.this,"Choose arrive date",Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP,0,300);
//                toast.show();

//                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, arrDateListner, arrCalendar
//                        .get(Calendar.YEAR), arrCalendar.get(Calendar.MONTH),
//                        arrCalendar.get(Calendar.DAY_OF_MONTH));
//                dialog.setCancelable(false);
//                dialog.show();
                startActivity(new Intent(MainActivity.this,SearchWebActivity.class));
            }
        });
    }

    //step1 . 체크인 날짜 선
    DatePickerDialog.OnDateSetListener arrDateListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            arrCalendar.set(Calendar.YEAR, year);
            arrCalendar.set(Calendar.MONTH, monthOfYear);
            arrCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            depCalendar.set(Calendar.YEAR, year);
            depCalendar.set(Calendar.MONTH, monthOfYear);
            depCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            depCalendar.add(Calendar.DATE,1);

            DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, depDate, depCalendar
                    .get(Calendar.YEAR), depCalendar.get(Calendar.MONTH),
                    depCalendar.get(Calendar.DAY_OF_MONTH));
            dialog.setCancelable(false);
            dialog.show();
        }
    };
    //setp2 . 체크아웃날짜 선택
    DatePickerDialog.OnDateSetListener depDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            depCalendar.set(Calendar.YEAR, year);
            depCalendar.set(Calendar.MONTH, monthOfYear);
            depCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            showHotelSelectDialog(hotels.getHotels());
        }
    };

    //step3. 호텔 선택
    ArrayList<?> chooseList;
    private void showHotelSelectDialog(ArrayList<?> list) {
        String cells[] = new String[list.size()];

        int index = 0;
        if(null != list && list.get(0) instanceof HotelBrand) {
            for(Object cell : list) {
                cells[index] = ((HotelBrand)cell).getBrandName();
                chooseList = ((HotelBrand)cell).getHotelRegions();
                index++;
            }
        }else if(null != list && list.get(0) instanceof HotelRegion) {
            for(Object cell : list) {
                cells[index] = ((HotelRegion)cell).getRegionName();
                chooseList = ((HotelRegion)cell).getCities();
                index++;
            }
        }else if(null != list && list.get(0) instanceof HotelCity) {
            for(Object cell : list) {
                cells[index] = ((HotelCity)cell).getCityName();
                chooseList = ((HotelCity)cell).getHotelList();
                index++;
            }
        }else if(null != list && list.get(0) instanceof HotelName) {
            for(Object cell : list) {
                cells[index] = ((HotelName)cell).getName();
                index++;
            }
        }

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("choose");
        dialogBuilder.setSingleChoiceItems(cells, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                showHotelSelectDialog(chooseList);
            }
        });
        dialogBuilder.setCancelable(false);
        dialogBuilder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
