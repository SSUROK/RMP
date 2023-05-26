package ru.surok.myfirstapplication.UI.Views.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import ru.surok.myfirstapplication.R;

public class FindSharedSongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null){
            if (intent.getAction().equals(Intent.ACTION_SEND)) {
                showFindPopup(intent);
            }
        }
    }
    private void showFindPopup(Intent intent){
        String song = intent.getStringExtra(Intent.EXTRA_TEXT);
        Uri data = intent.getData();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();
        View popupView = inflater.inflate(R.layout.fragment_popup_shared_song, null);

        // create the popup window
//        int width = RelativeLayout.LayoutParams.WRAP_CONTENT;
//        int height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        TextView songName = popupView.findViewById(R.id.songNameInPopup);
        songName.setText(song);
        builder.setView(popupView);
        builder.create();
        builder.show();

//        boolean focusable = true; // lets taps outside the popup also dismiss it
//        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
//        View view = findViewById(R.id.mainPage);
//        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
//        popupView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                popupWindow.dismiss();
//                return true;
//            }
//        });
    }
}
