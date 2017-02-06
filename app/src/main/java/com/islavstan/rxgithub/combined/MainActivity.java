package com.islavstan.rxgithub.combined;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.islavstan.rxgithub.R;
import com.islavstan.rxgithub.second_lesson.Main2Activity;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    String loginName = "islavstan";
    String loginName2 = "MaxDubovoi";
    Button nextActivityBtn;
    TextView login, email, public_repos, public_gists, login2, email2, public_repos2, public_gists2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextActivityBtn = (Button) findViewById(R.id.nextActivityBtn);

        nextActivityBtn.setOnClickListener(v-> startActivity(new Intent(MainActivity.this, Main2Activity.class)));

        login = (TextView) findViewById(R.id.login);
        email = (TextView) findViewById(R.id.email);
        public_repos = (TextView) findViewById(R.id.public_repos);
        public_gists = (TextView) findViewById(R.id.public_gists);
        login2 = (TextView) findViewById(R.id.login2);
        email2 = (TextView) findViewById(R.id.email2);
        public_repos2 = (TextView) findViewById(R.id.public_repos2);
        public_gists2 = (TextView) findViewById(R.id.public_gists2);


        Retrofit repo = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        Observable<UserInfo> userObservable = repo
                .create(Points.GitHubUser.class)
                .getUser(loginName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<UserInfo2> userObservable2 = repo
                .create(Points.GitHubUser2.class)
                .getUser(loginName2)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());


        // Lately we use RxJava’s zip method to combine our two Observables and wait for them to complete before creating a new Observable.

        Observable<CombinedUserInfo> combined = Observable.zip(userObservable, userObservable2, new Func2<UserInfo, UserInfo2, CombinedUserInfo>() {
            @Override
            public CombinedUserInfo call(UserInfo userInfo, UserInfo2 userInfo2) {
                return new CombinedUserInfo(userInfo, userInfo2);
            }
        });
        combined.subscribe(new Subscriber<CombinedUserInfo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CombinedUserInfo userInfo) {
                String log = userInfo.getUserInfo().getLogin();
                String log2 = userInfo.getUserInfo2().getLogin();

                String em = userInfo.getUserInfo().getEmail();
                String em2 = userInfo.getUserInfo2().getEmail();


                String public_rep = userInfo.getUserInfo().getPublic_repos();
                String public_rep2 = userInfo.getUserInfo2().getPublic_repos();

                String public_gis = userInfo.getUserInfo().getPublic_gists();
                String public_gis2 = userInfo.getUserInfo2().getPublic_gists();

                login.setText(log);
                login2.setText(log2);

                email.setText(em);
                email2.setText(em2);

                public_repos.setText(public_rep);
                public_repos2.setText(public_rep2);

                public_gists.setText(public_gis);
                public_gists2.setText(public_gis2);


            }
        });

    }
}
