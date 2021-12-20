package clpal.diffutilrecylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import clpal.diffutilrecylerview.databinding.ActivityMainBinding

class EmployeeAdapter() : ListAdapter<EmployeeData, EmployeeAdapter.EmployeeViewHolder>(DiffUtils()) {


    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val empId = view.findViewById<TextView>(R.id.empId)
        val name = view.findViewById<TextView>(R.id.name)
        val phone = view.findViewById<TextView>(R.id.phone)
        fun bind(item: EmployeeData) {
            empId.text = item.empId
            name.text = item.name
            phone.text = item.phone
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }

    class DiffUtils : DiffUtil.ItemCallback<EmployeeData>() {
        override fun areItemsTheSame(oldItem: EmployeeData, newItem: EmployeeData): Boolean {
            return oldItem.empId == newItem.empId
        }

        override fun areContentsTheSame(oldItem: EmployeeData, newItem: EmployeeData): Boolean {
            return oldItem == newItem
        }

    }
}