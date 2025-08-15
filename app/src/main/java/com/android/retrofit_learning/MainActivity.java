package com.android.retrofit_learning;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends AppCompatActivity {
    private TextView text;

    interface singleUser{
        @GET("api/users/{uid}")
        Call<DataClass> getUser(@Path("uid") String uid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text=findViewById(R.id.text);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        singleUser single_user = retrofit.create(singleUser.class);
        single_user.getUser("2").enqueue(new Callback<DataClass>() {
            @Override
            public void onResponse(Call<DataClass> call, @NonNull Response<DataClass> response) {
                assert response.body() != null;
                text.setText(response.body().data.first_name);
            }

            @Override
            public void onFailure(Call<DataClass> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }
}