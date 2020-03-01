package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.bluelinelabs.conductor.support.RouterPagerAdapter;
import com.example.mymiptapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MessagesController extends Controller {

    private SwipeRefreshLayout swipeContainer;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private final RouterPagerAdapter pagerAdapter;

    public MessagesController() {
        pagerAdapter = new RouterPagerAdapter(this) {
            @Override
            public void configureRouter(@NonNull Router router, int position) {
                if (!router.hasRootController()) {
                    if (position == 0) {
                        Controller page = new FriendMessagesChildController();
                        router.setRoot(RouterTransaction.with(page));
                    } else if (position == 1) {
                        Controller page = new TeacherMessagesChildController();
                        router.setRoot(RouterTransaction.with(page));
                    } else if (position == 2) {
                        Controller page = new ChatBotMessagesChildController();
                        router.setRoot(RouterTransaction.with(page));
                    }
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return "Друзья";
                } else if (position == 1) {
                    return "Учителя";
                } else if (position == 2) {
                    return "Чат-бот";
                }
                return "Page " + position;
            }
        };
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.messages_controller, container, false);
        ButterKnife.bind(this, view);

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_messages);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    switch (item.getItemId()) {
                        case R.id.action_messages:
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
