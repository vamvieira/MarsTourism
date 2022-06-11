package space.github.marstourism

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import space.github.marstourism.databinding.FragmentTimeFrameBinding
import space.github.marstourism.model.Database
import java.util.*

class TimeFrameFragment : Fragment() {

    private lateinit var binding: FragmentTimeFrameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_time_frame, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNext.setOnClickListener {
            Database.tripInfo.startDate = getDateFromPicker(binding.dtIda)
            Database.tripInfo.endDate = getDateFromPicker(binding.dtIda)
            if (Database.tripInfo.startDate!! < Database.tripInfo.endDate)
                view.findNavController().navigate(R.id.action_timeFrameFragment_to_ticketsFragment)
            else
                Toast.makeText(context,"A data de volta nao pode ser inferior a data de ida",Toast.LENGTH_SHORT).show()
        }
    }

    private fun getDateFromPicker(datePicker: DatePicker): Date? {
        val day: Int = datePicker.dayOfMonth
        val month: Int = datePicker.month
        val year: Int = datePicker.year

        val calendar = Calendar.getInstance()
        calendar[year, month] = day

        return calendar.time
    }
}