package com.example.desafiopagamento.feature.presentation.bottomsheetreceipt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.BottomsheetReceiptBinding
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.presentation.payscreen.PayViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ReceiptBottomSheet : BottomSheetDialogFragment() {

    private var _binding : BottomsheetReceiptBinding? = null
    private val binding : BottomsheetReceiptBinding get() = _binding!!
    private val viewModel : ReceiptViewModel by viewModels {
        ReceiptViewModel.ReceiptViewModelFactory(
            MockData.getIntance()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BottomsheetReceiptBinding.bind(inflater.inflate(R.layout.bottomsheet_receipt, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

        val transactionID  = arguments?.getInt("transactionID", -1)

        viewModel.getTransactionByID(transactionID!!)

        viewModel.curruentTransaction.observe(this){
            val user = viewModel.getUserByID(it.destination_user_id)

            if(user != null){
                binding.ivUserImageReceipt.setImageResource(user.drawableID)
                binding.tvReceiptPayDateTime.text = it.transactionDateTime
                binding.tvReceiptTotalPayValue.text = it.value
                binding.tvReceiptPayValue.text = it.value
                binding.tvReceiptPayTransactionCode.text = it.id.toString()
            }

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}