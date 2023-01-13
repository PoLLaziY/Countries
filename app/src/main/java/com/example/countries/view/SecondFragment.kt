package com.example.countries.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.countries.databinding.CurrencyViewBinding
import com.example.countries.databinding.FragmentSecondBinding
import com.example.countries.databinding.TimeZoneViewBinding
import com.example.countries.viewmodels.FragmentsViewModel

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FragmentsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.countries.observe(viewLifecycleOwner) {
            val index = viewModel.openedItem.value ?: return@observe
            val country = it?.get(index) ?: return@observe

            binding.name.text = country.name
            binding.capital.text = country.capital
            binding.region.text = country.region

            Glide.with(binding.root)
                .load(country.flags?.png)
                .into(binding.flagImage)

            if (country.currencies.size == 0) {
                binding.currenciesText.visibility = View.GONE
                binding.currencies.visibility = View.GONE
            } else {
                binding.currenciesText.visibility = View.VISIBLE
                binding.currencies.visibility = View.VISIBLE
            }

            binding.currencies.removeAllViews()

            country.currencies.forEach { currency ->
                val currencyBinding = CurrencyViewBinding.inflate(layoutInflater)
                binding.currencies.addView(currencyBinding.root)
                currencyBinding.name.text = currency.name
                currencyBinding.code.text = currency.code
                currencyBinding.symbol.text = currency.symbol
            }

            if (country.timezones.size == 0) {
                binding.timezones.visibility = View.GONE
                binding.timezonesText.visibility = View.GONE
            } else {
                binding.timezones.visibility = View.VISIBLE
                binding.timezonesText.visibility = View.VISIBLE
            }

            binding.timezones.removeAllViews()

            country.timezones.forEach { timeZone ->
                val timeZoneBinding = TimeZoneViewBinding.inflate(layoutInflater)
                binding.timezones.addView(timeZoneBinding.root)
                timeZoneBinding.root.text = timeZone
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}