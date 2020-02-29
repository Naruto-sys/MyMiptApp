package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginController extends Controller {

    private SwipeRefreshLayout swipeContainer;
    private ExtendedFloatingActionButton buttonAddTask;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.login_controller, container, false);
        ButterKnife.bind(this, view);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_login);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_messages:
                            getRouter().pushController(RouterTransaction.with(new MessagesController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            getRouter().popController(this);
                            return true;
                        case R.id.action_tasks:
                            getRouter().pushController(RouterTransaction.with(new TasksController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            getRouter().popController(this);
                            return true;
                        case R.id.action_clock:
                            getRouter().pushController(RouterTransaction.with(new ScheduleController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            getRouter().popController(this);
                            return true;
                        case R.id.action_login:
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

//    @OnClick({R.id.floating_button_add}) void launchAdd() {
//        //
//    }
}
