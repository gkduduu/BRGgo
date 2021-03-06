package brg.utils.jhy.brggo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

import org.json.JSONObject;

import java.util.HashMap;

import brg.utils.jhy.brggo.utils.RealmUtils;

public class IntroActivity extends AppCompatActivity {

    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private boolean mService;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        getRemote();
    }

    private void getRemote() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config);
        mFirebaseRemoteConfig.fetch().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    mFirebaseRemoteConfig.activateFetched();
                    getDatabase();
                }else {
                    appExit();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                appExit();
            }
        });
    }

    private void getDatabase() {
        mService = mFirebaseRemoteConfig.getBoolean("service");
        if(mService) {
            myRef = database.getReference("data");
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    JSONObject value = new JSONObject ((HashMap<String,String>)dataSnapshot.getValue());
//                    RealmUtils.initData(IntroActivity.this,value);

//                    Hotel hotels = new Hotel();
//                    ArrayList<HotelBrand> brandArray = new ArrayList<>();
//                    Log.d("jhy", "Value is: " + value);
//                    try {
//                        brandArray.add(JsonParser.parsingHilton(value.getJSONArray("hilton")));
//                    }catch(JSONException e) {
//                        e.getStackTrace();
//                    }
//                    hotels.setHotels(brandArray);
//                    Constant.getInstance().setHotels(hotels);
                    finish();
                    startActivity(new Intent(IntroActivity.this,MainActivity.class));
                    overridePendingTransition(0,0);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        } else {
            appExit();
        }
    }

    private void appExit() {
        finish();
    }
}
