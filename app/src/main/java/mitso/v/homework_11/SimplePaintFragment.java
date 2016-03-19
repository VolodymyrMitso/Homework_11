package mitso.v.homework_11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SimplePaintFragment extends BaseFragment implements View.OnClickListener {

    private CanvasView mCustomCanvas;
    private Button mButton_Black;
    private Button mButton_Blue;
    private Button mButton_Red;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_paint_fragment, container, false);

        mCustomCanvas = (CanvasView) view.findViewById(R.id.signature_canvas);

        mButton_Black = (Button) view.findViewById(R.id.btn_Black_SF);
        mButton_Black.setOnClickListener(this);
        mButton_Blue = (Button) view.findViewById(R.id.btn_Blue_SF);
        mButton_Blue.setOnClickListener(this);
        mButton_Red = (Button) view.findViewById(R.id.btn_Red_SF);
        mButton_Red.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_Black_SF:

                break;
            case R.id.btn_Blue_SF:

                break;
            case R.id.btn_Red_SF:

        }
    }
}
