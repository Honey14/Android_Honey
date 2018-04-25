package com.example.honeysonwani.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        getLisr();
       }


    private void getLisr(){
        Retrofit retrofit = new Retrofit.Builder() //add base url and convertor factory
                .baseUrl(Interactor.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build(); //final build

        Interactor allobjects = retrofit.create(Interactor.class); //create interface class in retrofit

        Call<List<ConvertJsonToJavaObjects>> call = allobjects.getAllObjects(); //put all array received into list

        call.enqueue(new Callback<List<ConvertJsonToJavaObjects>>() {
            @Override
            public void onResponse(Call<List<ConvertJsonToJavaObjects>> call, Response<List<ConvertJsonToJavaObjects>> response) {
                List<ConvertJsonToJavaObjects> lsitobject = response.body();
                String[] listofjavaovjects = new String[lsitobject.size()];
                for(int i=0;i<lsitobject.size();i++){
                    listofjavaovjects[i] = lsitobject.get(i).getName();
                }
                listview.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,listofjavaovjects));
            }

            @Override
            public void onFailure(Call<List<ConvertJsonToJavaObjects>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Could not get data",Toast.LENGTH_LONG).show();
            }
        });
    }



}
