package brg.utils.jhy.brggo.utils;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import brg.utils.jhy.brggo.IntroActivity;
import brg.utils.jhy.brggo.data.Hotels;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by hayoung on 2018. 9. 6..
 * gkduduu@naver.com
 */
public class RealmUtils {

    private static Realm set(Context context) {
        Realm.init(context);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("jhy.brg")
                .schemaVersion(Constant.REALM_VERSION)
                .build();

        return Realm.getInstance(config);
    }

    public static void initData(Context context, final JSONObject json) {

        Realm realm = set(context);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                for (int i = 1; true; i++) {

                    try {
                        JSONArray array = json.getJSONArray(i + "");
                        Hotels hotels = realm.createObject(Hotels.class, array.get(0).toString());
//                        hotels.setNAME(array.get(0).toString());
                        hotels.setBRAND(array.get(1).toString());
                        hotels.setCOUNTRY(array.get(2).toString());
                        hotels.setCITY(array.get(3).toString());
                        hotels.setLINK_OFFICIAL(array.get(4).toString());
                        hotels.setLINK_KAYAK(array.get(5).toString());
                        hotels.setLINK_TRIVAGO(array.get(6).toString());
                        hotels.setLINK_COMBINE(array.get(7).toString());
                        hotels.setLINK_GETAROOM(array.get(8).toString());
                    } catch (JSONException e) {
                        e.getStackTrace();
                        break;
                    }
                }

            }
        });

        realm.close();
    }

    public static void queryAll(Context context) {
        Realm realm = set(context);

        RealmResults<Hotels> result = realm.where(Hotels.class).findAll();
        Log.i("jhy", "size ===> " + result.size());
        realm.close();
    }

    public static List<Hotels> queryKeyword(Context context,String[] keywords) {
        Realm realm = set(context);

        RealmQuery<Hotels> query = realm.where(Hotels.class);
        for(String key : keywords) {
            if(null == key || key.equals(""))continue;
            query.contains("NAME",key, Case.INSENSITIVE);
        }

        RealmResults<Hotels> result = query.findAll();
        Log.i("jhy", "size ===> " + result.size());

        List<Hotels> list = realm.copyFromRealm(result);

        realm.close();

        return list;
    }
}
