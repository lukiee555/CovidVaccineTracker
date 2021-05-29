package com.la.covidvaccinetracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CenterAdapter(private val centerList: List<CenterModal>) :
    RecyclerView.Adapter<CenterAdapter.CenterViewHolder>() {
    class CenterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing all our text views along with  its ids.
        val centerNameTV: TextView = itemView.findViewById(R.id.idTVCenterName)
        val centerAddressTV: TextView = itemView.findViewById(R.id.idTVCenterAddress)
        val centerTimings: TextView = itemView.findViewById(R.id.idTVCenterTimings)
        val vaccineNameTV: TextView = itemView.findViewById(R.id.idTVVaccineName)
        val centerAgeLimitTV: TextView = itemView.findViewById(R.id.idTVAgeLimit)
        val centerFeeTypeTV: TextView = itemView.findViewById(R.id.idTVFeeType)
        val availabilityTV: TextView = itemView.findViewById(R.id.idTVAvaliablity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CenterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.center_rv_item,
            parent, false
        )
        return CenterViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return centerList.size
    }
    override fun onBindViewHolder(holder: CenterViewHolder, position: Int) {
        val currentItem = centerList[position]
        holder.centerNameTV.text = currentItem.centerName
        holder.centerAddressTV.text = currentItem.centerAddress
        holder.centerTimings.text = ("From : " + currentItem.centerFromTime + " To : " + currentItem.centerToTime)
        holder.vaccineNameTV.text = currentItem.vaccineName
        val ageLimit = "Age Limit : " + currentItem.ageLimit.toString()
        holder.centerAgeLimitTV.text = ageLimit
        holder.centerFeeTypeTV.text = currentItem.feeType
        val availability = "Availability : " + currentItem.availableCapacity.toString()
        holder.availabilityTV.text = availability
    }
}
