package com.example.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.countries.R
import com.example.countries.databinding.FragmentFirstBinding
import com.example.countries.viewmodels.FragmentsViewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FragmentsViewModel by activityViewModels()

    private val navController by lazy {
        findNavController()
    }

    private val adapter by lazy {
        CountriesRecyclerAdapter {
            viewModel.openedItem.postValue(it)
            navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.adapter = adapter
        binding.recycler.addItemDecoration(
            OffsetItemDecorator(
                resources.getDimension(R.dimen.country_recycler_item_text_margin).toInt()
            )
        )

        viewModel.countries.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            binding.errorView.root.visibility = if (it == null) View.VISIBLE else View.GONE
        }

        viewModel.isRefresh.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }

        binding.refresh.setOnClickListener {
            viewModel.refreshData()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}