package com.example.mymiptapp.Controllers;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetBlockController extends Controller {
    private static final String MY_SETTINGS = "my_settings";
    SharedPreferences sp;
    public View active_view;
    public int active_btn = 1;
    public String active_password = "";

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        sp = getApplicationContext().getSharedPreferences(MY_SETTINGS,
                Context.MODE_PRIVATE);
        String hasVisited = sp.getString("PIN", "");
        View view = inflater.inflate(R.layout.set_block_controller, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.n_0, R.id.n_1, R.id.n_2, R.id.n_3, R.id.n_4, R.id.n_5,
            R.id.n_6, R.id.n_7, R.id.n_8, R.id.n_9})
    void num_ckicked(View view) {
        ImageButton cancel = (ImageButton) getView().findViewById(R.id.face_id_btn);
        cancel.setImageResource(R.drawable.back);
        if (active_btn == 1) {
            active_view = (View) getView().findViewById(R.id.ellipse_1);
        }
        if (active_btn == 2) {
            active_view = (View) getView().findViewById(R.id.ellipse_2);
        }
        if (active_btn == 3) {
            active_view = (View) getView().findViewById(R.id.ellipse_3);
        }
        if (active_btn == 4) {
            active_view = (View) getView().findViewById(R.id.ellipse_4);
        }
        switch (view.getId()) {
            case R.id.n_1:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "1";
                break;
            case R.id.n_2:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "2";
                break;
            case R.id.n_3:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "3";
                break;
            case R.id.n_4:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "4";
                break;
            case R.id.n_5:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "5";
                break;
            case R.id.n_6:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "6";
                break;
            case R.id.n_7:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "7";
                break;
            case R.id.n_8:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "8";
                break;
            case R.id.n_9:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "9";
                break;
            case R.id.n_0:
                active_view.setBackgroundResource(R.drawable.green_elipse);
                active_password += "0";
                break;
        }

        this.active_btn += 1;
        if (this.active_btn == 5) {
            SharedPreferences.Editor e = sp.edit();
            e.putString("PIN", active_password);
            e.commit();
            getRouter().pushController(RouterTransaction.with(new LoginController())
                    .popChangeHandler(new FadeChangeHandler())
                    .pushChangeHandler(new FadeChangeHandler()));
            getRouter().popController(this);
        }
    }

    @OnClick({R.id.face_id_btn})
    void cancel(View view) {
        if (active_btn != 1) {
            active_password = active_password.substring(0, active_password.length() - 1);
            active_btn -= 1;
            if (active_btn == 1) {
                active_view = (View) getView().findViewById(R.id.ellipse_1);
            }
            if (active_btn == 2) {
                active_view = (View) getView().findViewById(R.id.ellipse_2);
            }
            if (active_btn == 3) {
                active_view = (View) getView().findViewById(R.id.ellipse_3);
            }
            if (active_btn == 4) {
                active_view = (View) getView().findViewById(R.id.ellipse_4);
            }
            active_view.setBackgroundResource(R.drawable.ellipse);
            if (active_btn == 1) {
                ImageButton cancel = (ImageButton) getView().findViewById(R.id.face_id_btn);
                cancel.setImageResource(R.drawable.face_id);
            }
        }
    }
}