package com.saiful.codetestwheelgame.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.saiful.codetestwheelgame.R
import com.saiful.codetestwheelgame.databinding.FragmentMainScreenBinding
import com.saiful.codetestwheelgame.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Created by Md Saiful Islam on 2/10/21.
 * saiful.aux@gmail.com
 */

@AndroidEntryPoint
class MainScreenFragment : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).mainToolbar.toolbarTitle.text = resources.getString(R.string.main_screen_title)
        binding.btnSpinTheWheel.setOnClickListener {
            findNavController().navigate(R.id.action_mainscreen_to_gamescreen)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}