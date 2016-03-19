package mitso.v.homework_11;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MovingViewsFragment extends BaseFragment implements View.OnTouchListener, View.OnClickListener {

    private ViewGroup mRelativeLayout_MovingViewsLayout;

    private int VIEW_CODE = 0;
    private final int BUTTON_CODE = 1;
    private final int TEXT_CODE = 2;
    private final int IMAGE_CODE = 3;

    private int _xDelta;
    private int _yDelta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.moving_views_fragment, container, false);

        mRelativeLayout_MovingViewsLayout = (ViewGroup) view.findViewById(R.id.rl_MovingViews_MF);

        Button mButton_Button = (Button) view.findViewById(R.id.btn_Button_MF);
        mButton_Button.setOnClickListener(this);
        Button mButton_Image = (Button) view.findViewById(R.id.btn_Image_MF);
        mButton_Image.setOnClickListener(this);
        Button mButton_Text = (Button) view.findViewById(R.id.btn_Text_MF);
        mButton_Text.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        RelativeLayout.LayoutParams layoutParams;
        switch(v.getId()) {
            case R.id.btn_Button_MF:
                if (VIEW_CODE != BUTTON_CODE)
                    mRelativeLayout_MovingViewsLayout.removeAllViews();

                Button mButton = new Button(mainActivity);
                mButton.setText(getResources().getString(R.string.s_buttonTitle));
                mRelativeLayout_MovingViewsLayout.addView(mButton);
                layoutParams = new RelativeLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp),
                        getResources().getDimensionPixelSize(R.dimen.d_size_50dp));
                mButton.setLayoutParams(layoutParams);
                mButton.setOnTouchListener(this);

                VIEW_CODE = BUTTON_CODE;
                break;
            case R.id.btn_Text_MF:
                if (VIEW_CODE != TEXT_CODE)
                    mRelativeLayout_MovingViewsLayout.removeAllViews();

                TextView mTextView = new TextView(mainActivity);
                mTextView.setText(getResources().getString(R.string.s_textContent));
                mTextView.setGravity(Gravity.CENTER);
                mTextView.setTextColor(getResources().getColor(R.color.c_text));
                mRelativeLayout_MovingViewsLayout.addView(mTextView);
                layoutParams = new RelativeLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp),
                        getResources().getDimensionPixelSize(R.dimen.d_size_50dp));
                mTextView.setLayoutParams(layoutParams);
                mTextView.setOnTouchListener(this);

                VIEW_CODE = TEXT_CODE;
                break;
            case R.id.btn_Image_MF:
                if (VIEW_CODE != IMAGE_CODE)
                    mRelativeLayout_MovingViewsLayout.removeAllViews();

                ImageView mImageView = new ImageView(mainActivity);
                mImageView.setBackgroundResource(R.drawable.bg_nature);
                mRelativeLayout_MovingViewsLayout.addView(mImageView);
                layoutParams = new RelativeLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp),
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp));
                mImageView.setLayoutParams(layoutParams);
                mImageView.setOnTouchListener(this);

                VIEW_CODE = IMAGE_CODE;
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                        .getLayoutParams();
                layoutParams.leftMargin = X - _xDelta;
                layoutParams.topMargin = Y - _yDelta;
                layoutParams.rightMargin = -250;
                layoutParams.bottomMargin = -250;
                view.setLayoutParams(layoutParams);
                break;
        }
        mRelativeLayout_MovingViewsLayout.invalidate();
        return true;
    }
}

