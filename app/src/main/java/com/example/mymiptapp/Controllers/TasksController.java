package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.ButterKnife;

public class TasksController extends Controller {

    private SwipeRefreshLayout swipeContainer;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.tasks_controller, container, false);
        ButterKnife.bind(this, view);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_tasks);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_messages:
                            getRouter().pushController(RouterTransaction.with(new MessagesController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            return true;
                        case R.id.action_tasks:
                            return true;
                        case R.id.action_clock:
                            getRouter().pushController(RouterTransaction.with(new ScheduleController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            return true;
                        case R.id.action_login:
                            getRouter().pushController(RouterTransaction.with(new LoginController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            return true;
                    }
                    return false;
                });

        swipeContainer = view.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Сделать обновление страницы
//                swipeContainer.setRefreshing(false);
            }
        });

        swipeContainer.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorPrimaryDark);

        return view;
    }
}
