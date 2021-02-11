package com.saiful.codetestwheelgame.ui.gamescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.saiful.codetestwheelgame.R
import com.saiful.codetestwheelgame.data.model.SpinWheelDataWrapper
import com.saiful.codetestwheelgame.databinding.FragmentGameScreenBinding
import com.saiful.codetestwheelgame.ui.MainActivity
import com.saiful.codetestwheelgame.ui.gamescreen.spinwheel.OnSpinWheelReachedTarget
import com.saiful.codetestwheelgame.ui.gamescreen.spinwheel.SpinWheelItem
import com.saiful.codetestwheelgame.ui.viewmodel.GameScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import timber.log.Timber

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */

@AndroidEntryPoint
class GameScreenFragment : Fragment() {
    private val gameScreenViewModel: GameScreenViewModel by this.viewModels()

    private var _binding: FragmentGameScreenBinding? = null
    private val binding get() = _binding!!

    private val wheelItems: MutableList<SpinWheelItem> = ArrayList()
    private val colors: List<Int> =
        listOf(R.color.wheel_lighter_background, R.color.wheel_dark_background)
    private var randomNumber: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSpinWheel()
        (activity as MainActivity).mainToolbar.toolbarTitle.text = resources.getString(R.string.game_screen_title)
        binding.btnSpin.setOnClickListener {
            randomNumber = (1..wheelItems.size).random()
            Timber.d(randomNumber.toString())
            binding.spinWheelView.rotateWheelTo(randomNumber)
            binding.btnSpin.isClickable = false
        }
    }

    private fun setupSpinWheel() {
        val spinWheelData = gameScreenViewModel.getSpinWheelData()
        spinWheelData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is SpinWheelDataWrapper.Loading -> {
                    Timber.i("Loading...")
                }
                is SpinWheelDataWrapper.Success -> {
                    for ((index, value) in it.data!!.withIndex()) {
                        wheelItems.add(SpinWheelItem(colors[index % 2], value.displayText))
                    }
                    binding.spinWheelView.addWheelItems(wheelItems)
                    binding.spinWheelView.setSpinWheelReachTarget(object :
                        OnSpinWheelReachedTarget {
                        override fun onReachTarget() {
                            Toast.makeText(
                                context,
                                "Reward Result: " + it.data[randomNumber - 1].displayText + " " + it.data[randomNumber - 1].currency,
                                Toast.LENGTH_LONG
                            ).show()
                            randomNumber = (1..wheelItems.size).random()
                            binding.btnSpin.isClickable = true
                        }
                    })
                    randomNumber = (1..wheelItems.size).random()
                    Timber.i("Result success: %s", it.data)
                }
                is SpinWheelDataWrapper.Failed -> {
                    Timber.e("Result Failed")
                    Toast.makeText(activity, "Result Failed " + it.message, Toast.LENGTH_LONG)
                        .show()
                    binding.btnSpin.isClickable = true
                }
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.spinWheelView.setSpinWheelReachTarget(null)
        _binding = null

    }

}