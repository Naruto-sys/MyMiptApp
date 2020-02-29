package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthController extends Controller {
    private boolean isAuth = false;
    private TextView textLogin;
    private TextView textPassword;



    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.auth_controller, container, false);
        ButterKnife.bind(this, view);
        textLogin = view.findViewById(R.id.login);
        textPassword = view.findViewById(R.id.login);
        return view;
    }


    @OnClick({R.id.regButton}) void launchReg() {
        getRouter().pushController(RouterTransaction.with(new RegController())
                .popChangeHandler(new FadeChangeHandler())
                .pushChangeHandler(new FadeChangeHandler()));
    }
    private boolean isPasswordValid(String text) {
        return text != null && text.length() >= 8;
    }
}
