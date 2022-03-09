package by.godevelopment.daggerlearn.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.godevelopment.daggerlearn.R
import by.godevelopment.daggerlearn.data.DataSource
import by.godevelopment.daggerlearn.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        val dataSource = DataSource("I am DataSource")
        viewModel = ViewModelProvider(this, MyMainViewModelFactory(dataSource))[MainViewModel::class.java]
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        binding.message.text = viewModel.message
    }
}