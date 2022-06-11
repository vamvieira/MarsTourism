package space.github.marstourism

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import space.github.marstourism.databinding.FragmentTicketsBinding
import space.github.marstourism.model.Database
import space.github.marstourism.model.Ticket
import space.github.marstourism.model.TicketTypeEnum


class TicketsFragment : Fragment() {

    private lateinit var binding:FragmentTicketsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tickets, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pickerChild.minValue = 0
        binding.pickerChild.maxValue = 20
        binding.pickerAdult.minValue = 0
        binding.pickerAdult.maxValue = 20
        binding.pickerOld.minValue = 0
        binding.pickerOld.maxValue = 20

        binding.btnNext.setOnClickListener {

            MutableList(binding.pickerChild.value){Ticket(TicketTypeEnum.CRIANCA)}.also {
                Database.tripInfo.tickets.addAll(it)
            }
            MutableList(binding.pickerAdult.value){Ticket(TicketTypeEnum.ADULTO)}.also {
                Database.tripInfo.tickets.addAll(it)
            }
            MutableList(binding.pickerOld.value){Ticket(TicketTypeEnum.IDOSO)}.also {
                Database.tripInfo.tickets.addAll(it)
            }

            view.findNavController().navigate(R.id.action_ticketsFragment_to_paymentFragment)
        }
    }
}