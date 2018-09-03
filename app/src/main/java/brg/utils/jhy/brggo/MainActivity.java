package brg.utils.jhy.brggo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar arrCalendar = Calendar.getInstance();
    Calendar depCalendar = Calendar.getInstance();

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
//                Snackbar.make(view, "출발날짜를 선택해주세요.", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                Toast toast = Toast.makeText(MainActivity.this,"Choose arrive date",Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.TOP,0,300);
//                toast.show();

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, arrDateListner, arrCalendar
                        .get(Calendar.YEAR), arrCalendar.get(Calendar.MONTH),
                        arrCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }
        });
    }


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
            dialog.show();
        }
    };
    DatePickerDialog.OnDateSetListener depDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            depCalendar.set(Calendar.YEAR, year);
            depCalendar.set(Calendar.MONTH, monthOfYear);
            depCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        }
    };

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
