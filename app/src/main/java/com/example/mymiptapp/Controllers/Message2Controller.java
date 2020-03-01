package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Message2Controller extends Controller {

    private FloatingActionButton buttonExit;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.message2_controller, container, false);
        ButterKnife.bind(this, view);

        buttonExit = view.findViewById(R.id.button_exit);
        return view;
    }

    @OnClick({R.id.button_exit}) void exit() {
        getRouter().popController(this);
    }
}
