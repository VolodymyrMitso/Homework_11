package mitso.v.homework_11;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {
    private Paint mPaint;
    private Path mPath;
    private Paint mCanvasPaint;
    private Canvas mCanvas;
    private Bitmap mBitmap;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();

        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(getResources().getDimensionPixelSize(R.dimen.d_size_10dp));
        this.mPaint.setColor(getResources().getColor(R.color.c_black));
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setAntiAlias(true);
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mCanvasPaint = new Paint();
    }

    public void setColor(int color) {
        this.mPaint.setColor(color);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
        this.mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        this.mCanvas = new Canvas(this.mBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.mBitmap, 0, 0, this.mCanvasPaint);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.mPath.moveTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                this.mPath.lineTo(eventX, eventY);
                break;
            case MotionEvent.ACTION_UP:
                this.mCanvas.drawPath(this.mPath, this.mPaint);
                this.mPath.reset();
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}