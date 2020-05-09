package com.panshuljindal.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    List<RetroPhoto> retroPhoto;
    String content = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<List<RetroPhoto>> call = api.getRetroPhoto();
        textView = (TextView) findViewById(R.id.textView);
        getRetroPhoto();

    }
    private void getRetroPhoto(){
        final Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<List<RetroPhoto>> call = api.getRetroPhoto();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                List<RetroPhoto>  retroPhoto = response.body();
                for(int i=0;i<retroPhoto.size();i++){
                    content+= "\n"+"Name : "+ retroPhoto.get(i).getName() + "\n" +
                            "Realname : "+retroPhoto.get(i).getRealName()+"\n"+
                            "Team : "+retroPhoto.get(i).getTeam() +"\n" +
                            "First Appearance : "+retroPhoto.get(i).getFirstAppearance()+"\n"+
                            "Created By :"+retroPhoto.get(i).getCreatedBy()+"\n"+
                            "Publisher : "+retroPhoto.get(i).getPublisher()+"\n"+
                            "ImageUrl : "+retroPhoto.get(i).getImageUrl()+"\n"+
                            "Bio : "+retroPhoto.get(i).getBio()+"\n"
                            +"----------------------------------------------------------------------------------------------------------"+"\n";
                    textView.setText(content);
                    textView.setMovementMethod( new ScrollingMovementMethod());
                }
            SharedPreferences sp = getSharedPreferences("MyUserPreference", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            Gson gson = new Gson();
            String json = gson.toJson(retroPhoto);
            editor.putString("Retro",json );
            editor.apply();
            }
            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                textView.setText(t.toString());
            }
        });
    }
}
