
package com.duran.travelapp.travelPlan

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.duran.travelapp.R
import com.duran.travelapp.addPlan.AddPlanActivity
import com.duran.travelapp.databinding.FragmentTravelPlanBinding
import com.duran.travelapp.dto.AddPlanDto
import com.duran.travelapp.viewmodel.AddPlanViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TravelPlanFragment : Fragment() {

    private lateinit var hBinding: FragmentTravelPlanBinding

    lateinit var addPlanViewModel: AddPlanViewModel
    lateinit var travelPlanAdapter: TravelPlanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_travel_plan, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addPlanViewModel = ViewModelProvider(this)[AddPlanViewModel::class.java]

        val fragmentTravelPlanBinding = FragmentTravelPlanBinding.bind(view)

        hBinding = fragmentTravelPlanBinding

        fragmentTravelPlanBinding.btnAddTravelPlan.setOnClickListener {
            context?.let {
                val intent = Intent(it, AddPlanActivity::class.java).apply {
                    putExtra("type", "ADD")
                }
                requestActivity.launch(intent)
                //startActivity(intent)
            }
        }

        addPlanViewModel.addPlanList.observe(viewLifecycleOwner) {
            travelPlanAdapter.update(it)
        }

        travelPlanAdapter = TravelPlanAdapter(this)
        hBinding.articleRv.layoutManager = LinearLayoutManager(context)
        hBinding.articleRv.adapter = travelPlanAdapter
    }

    private val requestActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode == RESULT_OK){
            val addPlan = it.data?.getSerializableExtra("addPlan") as AddPlanDto

            when(it.data?.getIntExtra("flag", -1)) {
                0 -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        addPlanViewModel.insert(addPlan)
                    }
                    Toast.makeText(context, "일정이 추가되었습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}