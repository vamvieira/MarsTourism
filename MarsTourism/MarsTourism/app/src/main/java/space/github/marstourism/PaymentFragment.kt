package space.github.marstourism

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import space.github.marstourism.adapter.TicketsAdapter
import space.github.marstourism.databinding.FragmentPaymentBinding
import space.github.marstourism.model.Database
import space.github.marstourism.model.Ticket
import java.text.NumberFormat
import java.util.*

class PaymentFragment : Fragment() {

    private lateinit var binding:FragmentPaymentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_payment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var _adapter = TicketsAdapter(Database.tripInfo.tickets as ArrayList<Ticket>,this.requireActivity())
        binding.recycler.adapter = _adapter
        var total = 0.0
        Database.tripInfo.tickets.forEach { total += it.ticketType.preco }
        binding.tvTotal.text = currencyFormatString(total)
        binding.btnNext.setOnClickListener {
            view.findNavController().navigate(R.id.action_paymentFragment_to_receiptFragment)
        }
    }

    fun currencyFormatString(valor: Double): String {
        return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(valor).toString()
    }
}