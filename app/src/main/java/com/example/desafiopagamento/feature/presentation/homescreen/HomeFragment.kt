package com.example.desafiopagamento.feature.presentation.homescreen

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentHomeBinding
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.presentation.adpter.ContactRecyclerViewAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding : FragmentHomeBinding get() = _binding!!
    lateinit var mAdapter : ContactRecyclerViewAdapter

    private val viewModel : HomeViewModel by viewModels {
        HomeViewModel.HomeViewModelFactory(
            MockData.getIntance()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        initRecyclerVIew()
    }

    override fun onResume() {
        super.onResume()

        binding.edtSearch.doOnTextChanged { text, start, before, count ->
            viewModel.searchContact(text.toString())
        }

        viewModel.contactsWorkList.observe(this){ listContact ->
            mAdapter.itemList = listContact
            mAdapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerVIew(){
        mAdapter = ContactRecyclerViewAdapter { contactID ->
            val id = contactID
            val args = Bundle()
            args.apply {
                putInt("userID", contactID)
            }
            if(viewModel.checkUserCard()){
                findNavController().navigate(R.id.action_homeFragment_to_payFragment, args)
            }else{
                findNavController().navigate(R.id.action_homeFragment_to_preCardRegisterFragment, args)
            }
        }
        binding.rvContacts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvContacts.adapter = mAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}