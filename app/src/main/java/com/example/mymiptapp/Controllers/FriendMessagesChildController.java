package com.example.mymiptapp.Controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;
import com.bluelinelabs.conductor.changehandler.FadeChangeHandler;
import com.example.mymiptapp.R;

import butterknife.ButterKnife;

public class FriendMessagesChildController extends Controller {
    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.friend_messages_child_controller, container, false);
        ButterKnife.bind(this, view);

        CardView myCard_2 = view.findViewById(R.id.note_card2);

        View.OnClickListener myCard = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRouter().pushController(RouterTransaction.with(new Message2Controller())
                        .popChangeHandler(new FadeChangeHandler())
                        .pushChangeHandler(new FadeChangeHandler()));
            }
        };

        // присвоим обработчик карточке
        myCard_2.setOnClickListener(myCard);

        return view;
    }
}
