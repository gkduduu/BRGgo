package brg.utils.jhy.brggo;

import android.animation.Animator;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.SearchView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import brg.utils.jhy.brggo.data.Hotels;
import brg.utils.jhy.brggo.utils.RealmUtils;
import brg.utils.jhy.brggo.utils.SearchListAdapter;

public class MainActivity extends AppCompatActivity {
    Calendar arrCalendar = Calendar.getInstance();
    Calendar depCalendar = Calendar.getInstance();
//    Hotel hotels = Constant.getInstance().getHotels();

    View mainLayout;
    View planLayout;
    SearchView svHotel;
    FloatingActionButton fab;

    RecyclerView rvList;
    SearchListAdapter searchListAdapter;
    List<Hotels> hotelsList = new ArrayList<>();

    View relCheckin;
    View relCheckout;


    //plan뷰가 보이는지 여부
    boolean isShowPlan = false;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.LAYOUT_LIST_VIEW);
        planLayout =findViewById(R.id.LAYOUT_PLAN_VIEW);
        relCheckin = findViewById(R.id.REL_CHECKIN);
        relCheckout = findViewById(R.id.REL_CHECKOUT);
        svHotel = findViewById(R.id.SV_HOTEL);
        fab = findViewById(R.id.fab);
        rvList = findViewById(R.id.RV_LIST);

        rvList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvList.setHasFixedSize(true);
        searchListAdapter = new SearchListAdapter(this,hotelsList);
        rvList.setAdapter(searchListAdapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        svHotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                svHotel.setIconified(false);
            }
        });
        svHotel.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Log.i("jhy",s);
                String keyword = s.trim();
                hotelsList = RealmUtils.queryKeyword(MainActivity.this,keyword.split(" "));
                searchListAdapter.updateData(hotelsList);
                searchListAdapter.notifyDataSetChanged();
                return false;
            }
        });

        planLayout.setOnClickListener(null);
        relCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, arrDateListner, arrCalendar
                        .get(Calendar.YEAR), arrCalendar.get(Calendar.MONTH),
                        arrCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                dialog.setCancelable(false);
                dialog.show();
            }
        });
        relCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, depDate, arrCalendar
                        .get(Calendar.YEAR), arrCalendar.get(Calendar.MONTH),
                        arrCalendar.get(Calendar.DAY_OF_MONTH+1));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
                dialog.setCancelable(false);
                dialog.show();
            }
        });

        fab.setOnClickListener(floatClickListener);


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
            dialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
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
//            showHotelSelectDialog(hotels.getHotels());
        }
    };

    //float버튼 클릭 리스너
    View.OnClickListener floatClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(isShowPlan) {

                int cx = fab.getRight()-(fab.getWidth()/2);
                int cy = fab.getTop();
                float initialRadius = (float) Math.hypot(mainLayout.getWidth(), mainLayout.getHeight());
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(planLayout, cx, cy, initialRadius, 0);
                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                    }
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        planLayout.setVisibility(View.GONE);
                        fab.setImageResource(R.drawable.ic_add);
                    }
                    @Override
                    public void onAnimationCancel(Animator animator) {
                    }
                    @Override
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
                anim.start();
                fab.animate().rotation(90).start();
                fab.animate().translationY(0).start();
            }else {
                Snackbar.make(view, "Select check inout date & destination.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                int cx = fab.getRight()-(fab.getWidth()/2);
                int cy = fab.getTop();
                float initialRadius = (float) Math.hypot(mainLayout.getWidth(), mainLayout.getHeight());
                Animator anim =
                        ViewAnimationUtils.createCircularReveal(planLayout, cx, cy, 0, initialRadius);
                anim.start();
                planLayout.setVisibility(View.VISIBLE);
                fab.animate().rotation(-135).start();
                fab.animate().translationY(-230).start();
            }
            isShowPlan = !isShowPlan;
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
