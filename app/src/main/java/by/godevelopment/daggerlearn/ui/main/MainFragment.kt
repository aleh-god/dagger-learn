package by.godevelopment.daggerlearn.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import by.godevelopment.daggerlearn.R
import by.godevelopment.daggerlearn.appComponent
import by.godevelopment.daggerlearn.data.DataSource
import by.godevelopment.daggerlearn.databinding.MainFragmentBinding
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding

    @Inject
    lateinit var factory: MainViewModelFactory.Factory
    private val viewModel: MainViewModel by viewModels {
        factory.create("null")
    }

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.stateUi.collect {
                binding.message.text = it.message
            }
        }
    }
}