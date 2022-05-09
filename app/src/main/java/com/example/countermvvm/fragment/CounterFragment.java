package com.example.countermvvm.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.View;

import com.example.countermvvm.R;
import com.example.countermvvm.base.BaseFragment;
import com.example.countermvvm.data.model.CounterModel;
import com.example.countermvvm.data.model.CounterViewModel;
import com.example.countermvvm.databinding.FragmentCounterBinding;

public class CounterFragment extends BaseFragment<FragmentCounterBinding> {

    NavController navController;

    @Override
    public FragmentCounterBinding getLayoutBinding() {
        return FragmentCounterBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        CounterViewModel counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        binding.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterViewModel.increment();
            }
        });

        binding.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterViewModel.decrement();
            }
        });

        counterViewModel.getNumber().observe(getViewLifecycleOwner(), new Observer<CounterModel>() {
            @Override
            public void onChanged(CounterModel counterModel) {
                binding.resultTv.setText(counterModel.getCounter()+"");
            }
        });
    }
}