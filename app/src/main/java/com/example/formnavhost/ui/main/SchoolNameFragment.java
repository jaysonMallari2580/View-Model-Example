package com.example.formnavhost.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.formnavhost.R;
import com.example.formnavhost.databinding.FormEntryBinding;
import com.google.android.material.textview.MaterialTextView;

public class SchoolNameFragment extends Fragment {

    private FormEntryBinding binding;
    private MainViewModel mMainViewModel;

    public SchoolNameFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FormEntryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.formTextView.setText(R.string.my_school);
        binding.formHint.setText(R.string.school_name_hint);
        binding.editTextHint.setHint("Enter your school name . . ");

        MaterialTextView schoolInput = view.findViewById(R.id.school_name_tv);
        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        binding.formEditText.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.continueButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                binding.continueButton.setEnabled(true);
                mMainViewModel.setSchoolName(binding.formEditText.getEditText().getText().toString());
            }
        });

        binding.continueButton.setOnClickListener(v -> {
           /* Bundle profileFragmentArgs = new ProfileFragmentArgs.Builder().setName(requireArguments()
                   *//* .get("name").toString()).setEmail(requireArguments().get("email").toString())
                    .setSchoolName(binding.formEditText.getEditText().getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_profile_fragment, profileFragmentArgs);*/

            NavHostFragment.findNavController(this).navigate(R.id.destination_profile_fragment);


        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                returnToEmailFragment();
            }
        });
    }

    private void returnToEmailFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_school_name_fragment_pop);
    }
}
