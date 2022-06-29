
package com.duran.travelapp.travelPlan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.duran.travelapp.R
import com.duran.travelapp.addPlan.AddPlanActivity
import com.duran.travelapp.databinding.FragmentTravelPlanBinding

class TravelPlanFragment : Fragment() {

    private lateinit var hBinding: FragmentTravelPlanBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_travel_plan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentTravelPlanBinding = FragmentTravelPlanBinding.bind(view)

        hBinding = fragmentTravelPlanBinding

        fragmentTravelPlanBinding.btnAddTravelPlan.setOnClickListener {
            context?.let {
                val intent = Intent(it, AddPlanActivity::class.java)
                startActivity(intent)
            }
        }

    }

}