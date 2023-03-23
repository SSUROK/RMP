package ru.surok.myfirstapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AccountAndSearchFragment extends Fragment {
    private final int duration = Toast.LENGTH_SHORT;
    private static final String TAG = "Music app top fragment";

    public AccountAndSearchFragment() {
        super(R.layout.account_search_menu_fragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharSequence text = "onCreate toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "creating fragment");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        CharSequence text = "onCreateView toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "creating view fragment");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CharSequence text = "onViewCreate toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "view fragment created");

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        CharSequence text = "onViewStateRestored toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "view restored fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        CharSequence text = "onStart toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "start fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        CharSequence text = "onResume toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "resume fragment");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence text = "onSaveInstanceState toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "onSaveInstanceState fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        CharSequence text = "onPause toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "onPause fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        CharSequence text = "onStop toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "onStop fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        CharSequence text = "onDestroyView toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "onDestroyView fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        CharSequence text = "onDestroy toast";
        Context context = getActivity().getApplicationContext();
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Log.i(TAG, "onDestroy fragment");
    }
}
