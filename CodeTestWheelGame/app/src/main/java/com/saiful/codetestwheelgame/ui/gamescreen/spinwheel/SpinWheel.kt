package com.saiful.codetestwheelgame.ui.gamescreen.spinwheel

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.annotation.Nullable
import com.saiful.codetestwheelgame.R
import com.saiful.codetestwheelgame.databinding.SpinWheelLayoutBinding
import kotlin.math.abs

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */
class SpinWheel : FrameLayout, View.OnTouchListener, OnSpinningListener {
    private var target = -1
    private var spinning = false
    private val SWIPE_DISTANCE_THRESHOLD = 100
    private var x1 = 0f
    private var x2 = 0f
    private var y1 = 0f
    private var y2 = 0f
    private var dx = 0f
    private var dy = 0f

    private var _binding: SpinWheelLayoutBinding? = null
    private val binding get() = _binding!!

    constructor(context: Context, @Nullable attrs: AttributeSet?) : super(context, attrs) {
        initComponent()
        applyAttribute(attrs)
    }

    constructor(context: Context, @Nullable attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initComponent()
        applyAttribute(attrs)
    }

    private fun initComponent() {
        _binding = SpinWheelLayoutBinding.inflate(LayoutInflater.from(context), this, true)
        setOnTouchListener(this)
        binding.spinWheelView.setOnRotationListener(this)
    }

    private fun applyAttribute(attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.SpinWheelStyle, 0, 0)
        try {
//            val backgroundColor = typedArray.getColor(R.styleable.SpinWheel_background_color, Color.GREEN)
            val arrowImage = typedArray.getResourceId(R.styleable.SpinWheelStyle_arrow_image, R.drawable.spin_wheel_stopper)
//            binding.spinWheelView.setWheelBackgoundWheel(backgroundColor)
            binding.imgSpinWheelStopper.setImageResource(arrowImage)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        typedArray.recycle()
    }

    /**
     * Function to set lucky wheel reach the target listener
     *
     * @param onSpinWheelReachedTarget Lucky wheel listener
     */
    fun setSpinWheelReachTarget(onSpinWheelReachedTarget: OnSpinWheelReachedTarget?) {
        binding.spinWheelView.setWheelListener(onSpinWheelReachedTarget)
    }

    /**
     * Function to add items to wheel items
     *
     * @param wheelItems Wheel items
     */
    fun addWheelItems(wheelItems: List<SpinWheelItem>) {
        binding.spinWheelView.addSpinnerItems(wheelItems)
    }

    /**
     * @param target target to rotate before swipe
     */
    fun setTarget(target: Int) {
        this.target = target
    }

    /**
     * Function to rotate wheel to degree
     *
     * @param number Number to rotate
     */
    fun rotateWheelTo(number: Int) {
        spinning = true
        binding.spinWheelView.resetSpinningLocationToZeroAngle(number)
    }


    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        if (target < 0 || spinning) {
            return false
        }
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = event.x
                y1 = event.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = event.x
                y2 = event.y
                dx = x2 - x1
                dy = y2 - y1
                if (abs(dx) > abs(dy)) {
                    if (dx < 0 && abs(dx) > SWIPE_DISTANCE_THRESHOLD) rotateWheelTo(
                        target
                    )
                } else {
                    if (dy > 0 && abs(dy) > SWIPE_DISTANCE_THRESHOLD) rotateWheelTo(
                        target
                    )
                }
            }
            else -> return true
        }
        return true
    }

    override fun onFinishSpinning() {
        spinning = false
    }

}