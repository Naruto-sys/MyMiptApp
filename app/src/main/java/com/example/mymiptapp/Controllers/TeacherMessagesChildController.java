package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.example.mymiptapp.R;

import butterknife.ButterKnife;

public class TeacherMessagesChildController extends Controller {
    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.teacher_messages_child_controller, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
