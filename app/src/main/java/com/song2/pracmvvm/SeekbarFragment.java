package com.song2.pracmvvm;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.song2.pracmvvm.databinding.FragmentSeekbarBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeekbarFragment extends Fragment {

    FragmentSeekbarBinding binding;

    public SeekbarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_seekbar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final VmShareViewModel viewModel = ViewModelProviders.of(requireActivity()).get(VmShareViewModel.class);

        //activity 와 다른점 : 바인드로 뷰를 넣어줌
        binding = DataBindingUtil.bind(view);
        binding.setLifecycleOwner(requireActivity());
        binding.setViewModel(viewModel);


        binding.sbSbFrag.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewModel.progress.setValue(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
/*
        viewModel.progress.observe(requireActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer progress) {

                binding.sbSbFrag.setProgress(progress);
            }
        });*/

    }
}
