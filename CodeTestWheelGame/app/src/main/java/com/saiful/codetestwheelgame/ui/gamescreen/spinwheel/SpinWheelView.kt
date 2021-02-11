package com.saiful.codetestwheelgame.ui.gamescreen.spinwheel

import android.animation.Animator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.annotation.Nullable

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
class SpinWheelView : View {
    private var range = RectF()
    private lateinit var archPaint: Paint
    private lateinit var textPaint: Paint
    private var padding = 0
    private var radius = 0
    private var center = 0F
    private var spinWheelBackground = 0
    private var spinWheelItems: List<SpinWheelItem> = ArrayList()
    private var mOnSpinWheelReachedTarget: OnSpinWheelReachedTarget? = null
    private var onSpinningListener: OnSpinningListener? = null

    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    /**
     * Function to draw wheel background
     *
     * @param canvas Canvas of draw
     */
    private fun drawWheelBackground(canvas: Canvas) {
        val backgroundPainter = Paint()
        backgroundPainter.isAntiAlias = true
        backgroundPainter.isDither = true
        backgroundPainter.color = spinWheelBackground
        canvas.drawCircle(center, center, center, backgroundPainter)
    }

    private fun initComponents() {
        //arc paint object
        archPaint = Paint()
        archPaint.isAntiAlias = true
        archPaint.isDither = true

        //text paint object
        textPaint = Paint()
        textPaint.typeface = Typeface.create("sans-serif",Typeface.NORMAL);
        textPaint.color = Color.WHITE
        textPaint.isAntiAlias = true
        textPaint.isDither = true
        textPaint.textSize = 30f

        //rect rang of the arc
        range = RectF(
            padding.toFloat(),
            padding.toFloat(),
            (padding + radius).toFloat(),
            (padding + radius).toFloat()
        )
    }

    /**
     * Get the angle of the target
     *
     * @return Number of angle
     */
    private fun getAngleOfIndexTarget(target: Int): Float {
        return (360 / spinWheelItems.size * target).toFloat()
    }

    /**
     * Function to set wheel background
     *
     * @param wheelBackground Wheel background color
     */
    fun setWheelBackgoundWheel(wheelBackground: Int) {
        this.spinWheelBackground = wheelBackground
        invalidate()
    }

    /**
     * Function to set wheel listener
     *
     * @param onSpinWheelReachedTarget target reach listener
     */
    fun setWheelListener(onSpinWheelReachedTarget: OnSpinWheelReachedTarget?) {
        mOnSpinWheelReachedTarget = onSpinWheelReachedTarget
    }

    fun setOnRotationListener(onSpinningListener: OnSpinningListener) {
        this.onSpinningListener = onSpinningListener
    }

    /**
     * Function to add wheels items
     *
     * @param spinWheelItems Wheels model item
     */
    fun addSpinnerItems(spinWheelItems: List<SpinWheelItem>) {
        this.spinWheelItems = spinWheelItems
        invalidate()
    }

    /**
     * Function to draw text below image
     *
     * @param canvas     Canvas to draw
     * @param tempAngle  Temporary angle
     * @param sweepAngle current index angle
     * @param text       string to show
     */
    private fun drawText(canvas: Canvas, tempAngle: Float, sweepAngle: Float, text: String) {
        val path = Path()
        path.addArc(range, tempAngle, sweepAngle)

        val textWidth: Float = textPaint.measureText(text)
        val hOffset = (radius * Math.PI / spinWheelItems.size / 2 - textWidth / 2).toInt()
        val vOffset = radius / 2 / 3 - 3
        canvas.drawTextOnPath(text, path, hOffset.toFloat(), vOffset.toFloat(), textPaint)
    }

    /**
     * Function to rotate wheel to target
     *
     * @param target target number
     */
    fun rotateWheelToTarget(target: Int) {
        val wheelItemCenter =
            270 - getAngleOfIndexTarget(target) + 360 / spinWheelItems.size / 2

        animate().setInterpolator(DecelerateInterpolator())
            .setDuration(9000L)
            .rotation(360 * 15 + wheelItemCenter)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    if (mOnSpinWheelReachedTarget != null) {
                        mOnSpinWheelReachedTarget?.onReachTarget()
                    }
                    if (onSpinningListener != null) {
                        onSpinningListener?.onFinishSpinning()
                    }
                    clearAnimation()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
            .start()
    }

    /**
     * Function to rotate to zero angle
     *
     * @param target target to reach
     */
    fun resetSpinningLocationToZeroAngle(target: Int) {
        animate().setDuration(0)
            .rotation(0f).setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}
                override fun onAnimationEnd(animation: Animator) {
                    rotateWheelToTarget(target)
                    clearAnimation()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawWheelBackground(canvas)
        initComponents()

        var tempAngle = 0f
        val sweepAngle = 360 / spinWheelItems.size.toFloat()

        for (i in  spinWheelItems.indices) {
            archPaint.color = resources.getColor(spinWheelItems[i].backgroundColor)
            canvas.drawArc(range, tempAngle, sweepAngle, true, archPaint)
            drawText(canvas, tempAngle, sweepAngle, spinWheelItems[i].text)
            tempAngle += sweepAngle
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width: Int = measuredWidth.coerceAtMost(measuredHeight)
        padding = if (paddingLeft == 0) 5 else paddingLeft
        radius = width - padding * 2
        center = (width / 2).toFloat()
        setMeasuredDimension(width, width)
    }
}