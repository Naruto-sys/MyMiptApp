package com.example.mymiptapp.Controllers;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScheduleController extends Controller {

    private SwipeRefreshLayout swipeContainer;
    private Button currentButton;
    @BindViews({R.id.container_1}) ViewGroup[] childContainers;

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.schedule_controller, container, false);
        ButterKnife.bind(this, view);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_clock);
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
                            return true;
                        case R.id.action_login:
                            getRouter().pushController(RouterTransaction.with(new LoginController())
                                    .popChangeHandler(new FadeChangeHandler())
                                    .pushChangeHandler(new FadeChangeHandler()));
                            getRouter().popController(this);
                            return true;
                    }
                    return false;
                });

        swipeContainer = view.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeContainer.setRefreshing(false);
            }
        });

        swipeContainer.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorPrimaryDark);

        return view;
    }

    @OnClick({R.id.n1, R.id.n2, R.id.n3, R.id.n4, R.id.n5,
            R.id.n6, R.id.n7, R.id.n8, R.id.n9, R.id.n10,
            R.id.n11, R.id.n12, R.id.n13, R.id.n14, R.id.n15,
            R.id.n16, R.id.n17, R.id.n18, R.id.n19, R.id.n20,
            R.id.n21, R.id.n22, R.id.n23, R.id.n24, R.id.n25,
            R.id.n26, R.id.n27, R.id.n28, R.id.n29, R.id.n30,})
    void num_ckicked(View view) {
        switch (view.getId()) {
            case R.id.n1:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button = view.findViewById(R.id.n1);
                button.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button;
                break;
            case R.id.n2:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button2 = view.findViewById(R.id.n2);
                button2.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button2;
                break;
            case R.id.n3:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button3 = view.findViewById(R.id.n3);
                button3.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button3;
                break;
            case R.id.n4:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button4 = view.findViewById(R.id.n4);
                button4.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button4;
                break;
            case R.id.n5:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button5 = view.findViewById(R.id.n5);
                button5.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button5;
                break;
            case R.id.n6:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button6 = view.findViewById(R.id.n6);
                button6.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button6;
                break;
            case R.id.n7:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button7 = view.findViewById(R.id.n7);
                button7.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button7;
                break;
            case R.id.n8:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button8 = view.findViewById(R.id.n8);
                button8.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button8;
                break;
            case R.id.n9:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button9 = view.findViewById(R.id.n9);
                button9.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button9;
                break;
            case R.id.n10:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button10 = view.findViewById(R.id.n10);
                button10.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button10;
                break;
            case R.id.n11:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button11 = view.findViewById(R.id.n11);
                button11.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button11;
                break;
            case R.id.n12:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button12 = view.findViewById(R.id.n12);
                button12.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button12;
                break;
            case R.id.n13:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button13 = view.findViewById(R.id.n13);
                button13.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button13;
                break;
            case R.id.n14:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button14 = view.findViewById(R.id.n14);
                button14.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button14;
                break;
            case R.id.n15:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button15 = view.findViewById(R.id.n15);
                button15.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button15;
                break;
            case R.id.n16:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button16 = view.findViewById(R.id.n16);
                button16.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button16;
                break;
            case R.id.n17:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button17 = view.findViewById(R.id.n17);
                button17.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button17;
                break;
            case R.id.n18:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button18 = view.findViewById(R.id.n18);
                button18.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button18;
                break;
            case R.id.n19:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button19 = view.findViewById(R.id.n19);
                button19.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button19;
                break;
            case R.id.n20:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button20 = view.findViewById(R.id.n20);
                button20.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button20;
                Router childRouter = getChildRouter(childContainers[0]).setPopsLastView(false);
                if (!childRouter.hasRootController()) {
                    childRouter.setRoot(RouterTransaction.with(new ScheduleChildController()));
                }
                break;
            case R.id.n21:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button21 = view.findViewById(R.id.n21);
                button21.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button21;
                break;
            case R.id.n22:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button22 = view.findViewById(R.id.n22);
                button22.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button22;
                break;
            case R.id.n23:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button23 = view.findViewById(R.id.n23);
                button23.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button23;
                break;
            case R.id.n24:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button24 = view.findViewById(R.id.n24);
                button24.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button24;
                break;
            case R.id.n25:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button25 = view.findViewById(R.id.n25);
                button25.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button25;
                break;
            case R.id.n26:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button26 = view.findViewById(R.id.n26);
                button26.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button26;
                break;
            case R.id.n27:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button27 = view.findViewById(R.id.n27);
                button27.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button27;
                break;
            case R.id.n28:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button28 = view.findViewById(R.id.n28);
                button28.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button28;
                break;
            case R.id.n29:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button29 = view.findViewById(R.id.n29);
                button29.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button29;
                break;
            case R.id.n30:
                if (currentButton != null){
                    currentButton.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                Button button30 = view.findViewById(R.id.n30);
                button30.setBackgroundColor(Color.parseColor("#ffa500"));
                currentButton = button30;
                break;
        }
    }
}
