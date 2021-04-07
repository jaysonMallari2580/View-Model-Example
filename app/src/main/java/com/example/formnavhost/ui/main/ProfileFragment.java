package com.example.formnavhost.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.formnavhost.R;
import com.example.formnavhost.databinding.FormEntryBinding;
import com.example.formnavhost.databinding.ProfileFragmentBinding;
import com.google.android.material.textview.MaterialTextView;

public class ProfileFragment extends Fragment {

    private ProfileFragmentBinding binding;
    private MainViewModel mMainViewModel;

    public ProfileFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = ProfileFragmentBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);


        binding.nameTv.setText(mMainViewModel.getName());
        binding.emailTv.setText(mMainViewModel.getEmail());
        binding.schoolNameTv.setText(mMainViewModel.getSchoolName());



        /*binding.nameTv.setText(MainViewModel.get);
        binding.emailTv.setText(requireArguments().get("email").toString());
        binding.schoolNameTv.setText(requireArguments().get("school_name").toString());*/




        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                returnToNameFragment();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void returnToNameFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_profile_fragment_pop);
    }


}
