package space.github.marstourism.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import space.github.marstourism.databinding.TicketListItemBinding
import space.github.marstourism.model.Ticket
import java.text.NumberFormat
import java.util.*


class TicketsAdapter(val tickets: ArrayList<Ticket>, val context: Context) :
    RecyclerView.Adapter<TicketsAdapter.ViewHolder>() {

    class ViewHolder(itemView: TicketListItemBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        private var binding = itemView
        fun bind(item: Ticket) {
            binding.tvTicketType.text = item.ticketType.name.toLowerCase().capitalize()
            binding.tvUnitPrice.text = currencyFormatString(item.ticketType.preco)

        }

        fun currencyFormatString(valor: Double): String {
            return NumberFormat.getCurrencyInstance(Locale("pt", "BR")).format(valor).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding: TicketListItemBinding = TicketListItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tickets[position])
    }

    override fun getItemCount(): Int {
        return tickets.size
    }

}