package com.thx.hotsaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Description:
 * @Author: tanghongxiang（thx76222@gmail.com）
 * @Version: V1.00
 * @Create Date: 2018/12/16 16:27
 */
public class HotSaleView extends View {
    private TypedArray typedArray;
    private Paint paint;
    private float mViewHeight;
    private float mLeftBlockWidth;
    private float mRightBlockWidth;
    private float mStartRadius;
    private float mEndRadius;
    private Spanned mLeftBlockText;
    private String mRightBlockText;
    private boolean mCanShowRightBlock;

    public HotSaleView(Context context) {
        super(context);
    }

    public HotSaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.HotSaleView);
        mViewHeight = typedArray.getDimension(R.styleable.HotSaleView_HotSaleViewHeight, 300);
        mLeftBlockWidth = typedArray.getDimension(R.styleable.HotSaleView_LeftBlockWidth, 300);
        mRightBlockWidth = typedArray.getDimension(R.styleable.HotSaleView_RightBlockWidth, 300);
        mStartRadius = typedArray.getDimension(R.styleable.HotSaleView_HotSaleViewStartRadius, 16);
        mEndRadius = typedArray.getDimension(R.styleable.HotSaleView_HotSaleViewEndRadius, 28);
    }

    public HotSaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        drawLeftBlock(canvas);
        drawLeftText(canvas);
        if(mCanShowRightBlock||typedArray.getBoolean(R.styleable.HotSaleView_CanShowRightBlock,false)){
            drawRightBlock(canvas);
            drawRigthText(canvas);
        }
    }

    private void drawLeftBlock(Canvas canvas) {
//        paint.setColor(typedArray.getColor(R.styleable.HotSaleView_LeftBlockBGColor, 0XFFD0021B));
        int colors[] = new int[2];
        float positions[] = new float[2];
        if(typedArray.getBoolean(R.styleable.HotSaleView_LeftBlockMMColorGrad,false)){
            colors[0] = typedArray.getColor(R.styleable.HotSaleView_LeftBlockMMColorGradTop,0xFFDE38AD);
            positions[0] = 0;
            colors[1] = typedArray.getColor(R.styleable.HotSaleView_LeftBlockMMColorGradBottom,0xFFA23BCA);
            positions[1] = 0.5f;
            LinearGradient shader = new LinearGradient(
                    0, 0,
                    0, getHeight(),
                    colors,
                    positions,
                    Shader.TileMode.MIRROR);
            paint.setShader(shader);
        }else{
            paint.setColor(typedArray.getColor(R.styleable.HotSaleView_RightBlockBGColor, 0XFFD0021B));
        }
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Path path = new Path();
        path.moveTo(mLeftBlockWidth, 0);
        path.lineTo(mLeftBlockWidth, mViewHeight - mEndRadius);
        path.quadTo(mLeftBlockWidth, mViewHeight, mLeftBlockWidth - mEndRadius, mViewHeight);
        path.lineTo(0, mViewHeight);
        path.lineTo(0, mStartRadius);
        path.quadTo(0, 0, mStartRadius, 0);
        path.lineTo(mLeftBlockWidth, 0);
        canvas.drawPath(path, paint);
    }

    private void drawRightBlock(Canvas canvas) {
        canvas.restore();
        int colors[] = new int[2];
        float positions[] = new float[2];
        if(typedArray.getBoolean(R.styleable.HotSaleView_RightBlockMMColorGrad,false)){
            colors[0] = typedArray.getColor(R.styleable.HotSaleView_RightBlockMMColorGradTop,0xFFDE38AD);
            positions[0] = 0;
            colors[1] = typedArray.getColor(R.styleable.HotSaleView_RightBlockMMColorGradBottom,0xFFA23BCA);
            positions[1] = 0.5f;
            LinearGradient shader = new LinearGradient(
                    0, 0,
                    0, getHeight(),
                    colors,
                    positions,
                    Shader.TileMode.MIRROR);
            paint.setShader(shader);
        }else{
            paint.setColor(typedArray.getColor(R.styleable.HotSaleView_RightBlockBGColor, 0XFFA23BCA));
        }
        Path path2 = new Path();
        path2.moveTo(mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10) + mRightBlockWidth, 0);
        path2.lineTo(mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10) + mRightBlockWidth, mViewHeight - mEndRadius);
        path2.quadTo(
                mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10) + mRightBlockWidth,
                mViewHeight,
                mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10) + mRightBlockWidth - mEndRadius,
                mViewHeight);
        path2.lineTo(mLeftBlockWidth - mEndRadius + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10), mViewHeight);
        path2.quadTo(
                mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10),
                mViewHeight,
                mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10),
                mViewHeight - mEndRadius);
        path2.lineTo(mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10), 0);
        path2.lineTo(mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10) + mRightBlockWidth, 0);
        canvas.drawPath(path2, paint);
    }

    private void drawLeftText(Canvas canvas) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(typedArray.getColor(R.styleable.HotSaleView_LeftTextColor, 0xFFFFFFFF));
        textPaint.setTextSize(typedArray.getDimension(R.styleable.HotSaleView_LeftTextSize, 38));
        textPaint.setAntiAlias(true);//typedArray.getString(R.styleable.HotSaleView_LeftTextContent)
        StaticLayout layout = new StaticLayout(mLeftBlockText == null ? Html.fromHtml("OFF<br/><big>90</big>%") : mLeftBlockText, textPaint, (int) mLeftBlockWidth,
                Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
        canvas.save();
        canvas.translate(0, (mViewHeight - layout.getHeight()) / 2);
        layout.draw(canvas);
    }

    private void drawRigthText(Canvas canvas) {
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(typedArray.getColor(R.styleable.HotSaleView_RightTextColor, 0xFF00FF00));
        textPaint.setTextSize(typedArray.getDimension(R.styleable.HotSaleView_RightTextSize, 38));
        textPaint.setAntiAlias(true);
        StaticLayout layout = new StaticLayout(mRightBlockText == null ? typedArray.getString(R.styleable.HotSaleView_RightTextContent) : mRightBlockText, textPaint, (int) mRightBlockWidth,
                Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
        canvas.translate(mLeftBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10), (mViewHeight - layout.getHeight()) / 2);
        layout.draw(canvas);
        canvas.save();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension((int) (mLeftBlockWidth + mRightBlockWidth + typedArray.getDimension(R.styleable.HotSaleView_BlockMargin, 10)), (int) mViewHeight);
    }


    public void setLeftBlockText(Spanned content) {
        this.mLeftBlockText = content;
        invalidate();
    }

    public void setRightBlockText(String content) {
        this.mRightBlockText = content;
        invalidate();
    }

    public void setmCanShowRightBlock(boolean show){
        this.mCanShowRightBlock=show;
        invalidate();
    }
}