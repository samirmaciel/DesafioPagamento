package com.example.desafiopagamento.feature.presentation.payscreen

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.desafiopagamento.R
import com.example.desafiopagamento.databinding.FragmentPayBinding
import com.example.desafiopagamento.feature.data.MockData
import com.example.desafiopagamento.feature.domain.model.Transaction
import com.example.desafiopagamento.feature.presentation.bottomsheetreceipt.ReceiptBottomSheet
import com.example.desafiopagamento.feature.utils.MoneyTextWatcher
import java.time.LocalDateTime

class PayFragment : Fragment(R.layout.fragment_pay){

    private var _bingind : FragmentPayBinding? = null
    private val binding : FragmentPayBinding get() = _bingind!!
    private val viewModel : PayViewModel by viewModels {
        PayViewModel.PayViewModelFactory(
            MockData.getIntance()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bingind = FragmentPayBinding.bind(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()

        viewModel.getUserByID(getUserIDFromArguments())

        binding.edtMoneyInput.addTextChangedListener(MoneyTextWatcher(binding.edtMoneyInput))

        binding.btnBackButton.setOnClickListener {
            findNavController().navigate(R.id.action_payFragment_to_homeFragment)
        }

        binding.btnPay.setOnClickListener{
            val transactionID = viewModel.registerTransaction(getTransaction())
            val args = Bundle()

            args.putInt("transactionID", transactionID)

            val bottomsheet = ReceiptBottomSheet()

            bottomsheet.arguments = args

            bottomsheet.show(childFragmentManager, "ReceiptBottomSheet")
        }

        binding.edtMoneyInput.doOnTextChanged{ text, _, _, _ ->
            binding.btnPay.isEnabled = !text.isNullOrEmpty()

            if(!text.isNullOrEmpty()){
                binding.tvSymbol.setTextColor(resources.getColor(R.color.green))
            }else{
                binding.tvSymbol.setTextColor(resources.getColor(R.color.graylight))
            }
        }

        viewModel.userForTransaction.observe(this){ user ->
            binding.ivImageUser.setImageResource(user.drawableID)
            binding.tvUserName.text = user.nickname
            binding.tvUserName.text = user.name
        }

        setClickListeners()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTransaction() : Transaction{

        val transaction = Transaction(
            card_number = viewModel.getCard().cardNumber,
            destination_user_id = viewModel.userForTransaction.value!!.id,
            transactionDateTime = LocalDateTime.now().toString(),
            cvv = viewModel.getCard().cardCvv,
            expiry_date = viewModel.getCard().dueDate,
            value = binding.edtMoneyInput.text.toString()
        )

        return transaction
    }

    private fun setClickListeners(){
        binding.keyboardComponent.btnKeyboard1.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}1")
        }
        binding.keyboardComponent.btnKeyboard2.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}2")
        }
        binding.keyboardComponent.btnKeyboard3.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}3")
        }
        binding.keyboardComponent.btnKeyboard4.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}4")
        }
        binding.keyboardComponent.btnKeyboard5.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}5")
        }
        binding.keyboardComponent.btnKeyboard6.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}6")
        }
        binding.keyboardComponent.btnKeyboard7.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}7")
        }
        binding.keyboardComponent.btnKeyboard8.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}8")
        }
        binding.keyboardComponent.btnKeyboard9.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}9")
        }
        binding.keyboardComponent.btnKeyboard0.setOnClickListener {
            binding.edtMoneyInput.setText("${binding.edtMoneyInput.text}0")
        }

        binding.keyboardComponent.btnBackSpace.setOnClickListener {
            backSpaceKeyboardFeature()
        }
    }

    private fun backSpaceKeyboardFeature(){
        if(binding.edtMoneyInput.text.length > 0){

            var stringWithOnlyNumber = binding.edtMoneyInput.text.toString().replace("[,.]".toRegex(), "").replace("\\s+".toRegex(), "")

            if(stringWithOnlyNumber[0].toString().equals("0", true)){
                stringWithOnlyNumber = stringWithOnlyNumber.drop(1)

                if(stringWithOnlyNumber[0].toString().equals("0", true)) {
                    stringWithOnlyNumber = stringWithOnlyNumber.drop(1)
                }
            }

            stringWithOnlyNumber = stringWithOnlyNumber.drop(1)

            if (stringWithOnlyNumber.length == 0){
                stringWithOnlyNumber = ""
            }

            binding.edtMoneyInput.setText(stringWithOnlyNumber)
        }
    }

    private fun getUserIDFromArguments() : Int {
        val userID = arguments?.getInt("userID", -1)
        return userID!!
    }


    override fun onDestroy() {
        super.onDestroy()
        _bingind = null
    }
}