package com.example.cloudmusic.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;

import com.example.cloudmusic.R;

import java.util.HashMap;
import java.util.Map;

public class MvSelectButton extends RelativeLayout {

    @SuppressLint("StaticFieldLeak")
    private static Map<String, TextView> textViewMap;
    @SuppressLint("StaticFieldLeak")
    private static Context context;


    public MvSelectButton(Context context) {
        this(context, null);
    }

    public MvSelectButton(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MvSelectButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if(textViewMap==null)textViewMap=new HashMap<>();
        MvSelectButton.context = context;
        View view = View.inflate(getContext(), R.layout.select_button_layout, null);
        addView(view);
        @SuppressLint({"Recycle", "CustomViewStyleable"})
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SelectButton);
        String buttonText = typedArray.getString(R.styleable.SelectButton_buttonText);
        boolean isSelected = typedArray.getBoolean(R.styleable.SelectButton_isSelected, false);
        typedArray.recycle();
        TextView textView = view.findViewById(R.id.select_button_text);
        textView.setText(buttonText);
        if (isSelected) {
            textView.setBackgroundResource(R.drawable.selected_btn);
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
        textViewMap.remove(buttonText);
        textViewMap.put(buttonText, textView);
    }


    @BindingAdapter(value = {"isSelected", "key"}, requireAll = true)
    public static void isSelected(MvSelectButton mvSelectButton, boolean isSelected, String key) {
        TextView textView = textViewMap.get(key);
        if (textView == null) return;
        if (isSelected) {
            textView.setBackgroundResource(R.drawable.selected_btn);
            textView.setTextColor(ContextCompat.getColor(context, R.color.white));
        } else {
            textView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            textView.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }
}
