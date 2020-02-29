package com.example.mymiptapp.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.net.URI;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AuthController extends Controller {
    private TextView textLogin;
    private TextView textPassword;
    private boolean flag = false;
    private static final String MY_SETTINGS = "my_settings";
    SharedPreferences sp;


    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {

        sp = getApplicationContext().getSharedPreferences(MY_SETTINGS,
                Context.MODE_PRIVATE);
        boolean hasVisited = sp.getBoolean("hasAuthed", false);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (hasVisited) {
            getRouter().pushController(RouterTransaction.with(new LoginController())
                    .popChangeHandler(new FadeChangeHandler())
                    .pushChangeHandler(new FadeChangeHandler()));
            getRouter().popController(this);
            View view = inflater.inflate(R.layout.empty_layout, container, false);
            return view;
        }
        View view = inflater.inflate(R.layout.auth_controller, container, false);
        ButterKnife.bind(this, view);
        textLogin = view.findViewById(R.id.login);
        textPassword = view.findViewById(R.id.login);
        return view;
    }

    @OnClick({R.id.authButton}) void launchAuth() {
        String log = "";
        String pas = "";
        try {
            log = ((EditText) getView().findViewById(R.id.login)).getText().toString();
            pas = ((EditText) getView().findViewById(R.id.password)).getText().toString();
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(log, pas).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    flag = true;
                    // String userId = authResult.getUser().getUid();
                    // Toast.makeText(getApplicationContext(), userId, Toast.LENGTH_LONG).show();

                }
            });
            if (flag) {
                boolean authed = sp.getBoolean("hasAuthed", false);

                getRouter().pushController(RouterTransaction.with(new LoginController())
                        .popChangeHandler(new FadeChangeHandler())
                        .pushChangeHandler(new FadeChangeHandler()));
                getRouter().popController(this);
                flag = false;
                if (!authed) {
                    Editor e = sp.edit();
                    e.putBoolean("hasAuthed", true);
                    e.commit();
                }
            } else {

                Toast.makeText(getApplicationContext(), "Что-то не так!", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
