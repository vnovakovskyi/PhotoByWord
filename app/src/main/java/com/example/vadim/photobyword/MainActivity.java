package com.example.vadim.photobyword;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vadim.photobyword.api.PhotoApi;
import com.example.vadim.photobyword.lvadapters.HistoryLVAdapter;
import com.example.vadim.photobyword.lvadapters.ResultLVAdapter;
import com.example.vadim.photobyword.pojo.DBFilePojo;
import com.example.vadim.photobyword.pojo.ResponsePojo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private Retrofit retrofitPhoto;
    private PhotoApi photoApi;
    private DBFilePojo dbFilePojo;
    private String toSearch;
    public static ResponsePojo responsePojo;
    public static Realm mRealm;

    private ListView historyLV, resultLV;
    private EditText searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = MainActivity.this;

        Realm.init(context);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        mRealm = Realm.getInstance(config);

        gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        retrofitPhoto = new Retrofit.Builder()
                .baseUrl(PhotoApi.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        photoApi = retrofitPhoto.create(PhotoApi.class);

        searchField = (EditText) findViewById(R.id.search_field);
        searchField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                    Call<ResponsePojo> callIpPOJO = photoApi.searchPhoto("id,title,thumb", "best", String.valueOf(searchField.getText()));
                    callIpPOJO.enqueue(photoCallback);
                    toSearch = String.valueOf(searchField.getText());
                    searchField.setText("");
                    return true;
                }
                return false;
            }
        });

        resultLV = (ListView) findViewById(R.id.search_result_lv);
        historyLV = (ListView) findViewById(R.id.search_history_lv);
        historyLV.setAdapter(new HistoryLVAdapter(MainActivity.this));
    }

    Callback photoCallback = new Callback<ResponsePojo>() {

        @Override
        public void onResponse(Call<ResponsePojo> call, Response<ResponsePojo> response) {
            int code = response.code();

            Log.e("MEGATAG", "MainActivity.photoCallback.onResponse code: " + code);

            if (code == 200) {

                responsePojo = response.body();

                try {
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            dbFilePojo = realm.createObject(DBFilePojo.class);
                            dbFilePojo.setUrl(responsePojo.getImages().get(0).getDisplaySizes().get(0).getUri());
                            dbFilePojo.setTitle(toSearch);
                            realm.copyToRealm(dbFilePojo);
                        }
                    });

                    resultLV.setAdapter(new ResultLVAdapter(MainActivity.this));
                    historyLV.setAdapter(new HistoryLVAdapter(MainActivity.this));
                } catch (IndexOutOfBoundsException e){
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Image not found!", Toast.LENGTH_SHORT);
                    toast.show();
                }
            } else {
                Log.e("MEGATAG", "MainActivity.photoCallback.onResponse Did not work: " + code);
            }
        }

        @Override
        public void onFailure(Call<ResponsePojo> call, Throwable t) {
            Log.e("MEGATAG", "MainActivity.photoCallback.onFailure nope " + t.getMessage());
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
