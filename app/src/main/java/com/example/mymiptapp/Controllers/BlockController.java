package com.example.mymiptapp.Controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;
import com.google.android.material.button.MaterialButton;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BlockController extends Controller {

    private String good_password = "1111";
    public String active_password = "";
    public View active_view;
    public int active_btn = 1;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.block_controller, container, false);
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
        System.out.println(active_view);
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
            if (isPassTrue(active_password)) {
                getRouter().pushController(RouterTransaction.with(new LoginController())
                        .popChangeHandler(new FadeChangeHandler())
                        .pushChangeHandler(new FadeChangeHandler()));
                getRouter().popController(this);
            } else {
                getView().findViewById(R.id.ellipse_1).setBackgroundResource(R.drawable.ellipse);
                getView().findViewById(R.id.ellipse_2).setBackgroundResource(R.drawable.ellipse);
                getView().findViewById(R.id.ellipse_3).setBackgroundResource(R.drawable.ellipse);
                getView().findViewById(R.id.ellipse_4).setBackgroundResource(R.drawable.ellipse);
                active_password = "";
                active_btn = 1;
                ImageButton canc = (ImageButton) getView().findViewById(R.id.face_id_btn);
                canc.setImageResource(R.drawable.face_id);
            }
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

    private boolean isPassTrue(String pass) {
        if (pass.equals(good_password)) {
            return true;
        }
        return false;
    }
}
