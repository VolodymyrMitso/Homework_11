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

public class MovableViewsFragment extends BaseFragment implements View.OnTouchListener, View.OnClickListener {

    private ViewGroup mRelativeLayout_MovableViewsLayout;

    private int VIEW_CODE = 0;
    private final int BUTTON_CODE = 1;
    private final int TEXT_CODE = 2;
    private final int IMAGE_CODE = 3;

    private int _xDelta;
    private int _yDelta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movable_views_fragment, container, false);

        mRelativeLayout_MovableViewsLayout = (ViewGroup) view.findViewById(R.id.rl_MovableViews_MF);

        Button mButton_Button = (Button) view.findViewById(R.id.btn_Button_MF);
        mButton_Button.setOnClickListener(this);
        Button mButton_Text = (Button) view.findViewById(R.id.btn_Text_MF);
        mButton_Text.setOnClickListener(this);
        Button mButton_Image = (Button) view.findViewById(R.id.btn_Image_MF);
        mButton_Image.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        RelativeLayout.LayoutParams mLayoutParams;
        switch(v.getId()) {
            case R.id.btn_Button_MF:
                if (VIEW_CODE != BUTTON_CODE)
                    mRelativeLayout_MovableViewsLayout.removeAllViews();

                Button mButton = new Button(mMainActivity);
                mButton.setText(getResources().getString(R.string.s_buttonTitle));
                mButton.setBackgroundResource(R.drawable.sh_btn_created);
                mRelativeLayout_MovableViewsLayout.addView(mButton);
                mLayoutParams = new RelativeLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.d_size_80dp),
                        getResources().getDimensionPixelSize(R.dimen.d_size_40dp));
                mButton.setLayoutParams(mLayoutParams);
                mButton.setOnTouchListener(this);

                VIEW_CODE = BUTTON_CODE;
                break;
            case R.id.btn_Text_MF:
                if (VIEW_CODE != TEXT_CODE)
                    mRelativeLayout_MovableViewsLayout.removeAllViews();

                TextView mTextView = new TextView(mMainActivity);
                mTextView.setText(getResources().getString(R.string.s_textContent));
                mTextView.setGravity(Gravity.CENTER);
                mTextView.setTextColor(getResources().getColor(R.color.c_text));
                mRelativeLayout_MovableViewsLayout.addView(mTextView);
                mLayoutParams = new RelativeLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp),
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp));
                mTextView.setLayoutParams(mLayoutParams);
                mTextView.setOnTouchListener(this);

                VIEW_CODE = TEXT_CODE;
                break;
            case R.id.btn_Image_MF:
                if (VIEW_CODE != IMAGE_CODE)
                    mRelativeLayout_MovableViewsLayout.removeAllViews();

                ImageView mImageView = new ImageView(mMainActivity);
                mImageView.setBackgroundResource(R.drawable.bg_nature);
                mRelativeLayout_MovableViewsLayout.addView(mImageView);
                mLayoutParams = new RelativeLayout.LayoutParams(
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp),
                        getResources().getDimensionPixelSize(R.dimen.d_size_100dp));
                mImageView.setLayoutParams(mLayoutParams);
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
        mRelativeLayout_MovableViewsLayout.invalidate();
        return true;
    }
}

