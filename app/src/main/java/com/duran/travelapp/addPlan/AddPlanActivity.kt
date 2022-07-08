package com.duran.travelapp.addPlan

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.duran.travelapp.MainActivity
import com.duran.travelapp.R
import com.duran.travelapp.databinding.ActivityAddPlanBinding
import com.duran.travelapp.dto.AddPlanDto
import java.text.SimpleDateFormat
import java.util.*

class AddPlanActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddPlanBinding

    private lateinit var tvStartDatePicker : TextView
    private lateinit var btnStartDatePicker : ImageView

    private lateinit var tvEndDatePicker : TextView
    private lateinit var btnEndDatePicker : ImageView

    val sCalendar = Calendar.getInstance()
    val eCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPlanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val type = intent.getStringExtra("type")

        if(type.equals("ADD")){
            binding.btnAddPlan.text = "일정 추가하기"
        } else {
            binding.btnAddPlan.text = "일정 수정하기"
        }

        initBackBtn()
        initStartDatePicker()
        initEndDatePicker()
        initBtnAddPlan()

    }

    //  여행 시작일 DatePicker 클릭
    private fun initStartDatePicker() {
        tvStartDatePicker = findViewById(R.id.plan_tv_start_date)
        btnStartDatePicker = findViewById(R.id.plan_iv_start_dataPicker)

        val sDatePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            sCalendar.set(Calendar.YEAR, year)
            sCalendar.set(Calendar.MONTH, month)
            sCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateStartDateLable(sCalendar)
        }

        btnStartDatePicker.setOnClickListener {
            DatePickerDialog(this, sDatePicker, sCalendar.get(Calendar.YEAR), sCalendar.get(Calendar.MONTH), sCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    //  여행 시작일 DatePicker 날짜 넣기
    private fun updateStartDateLable(sCalendar: Calendar) {
        val myFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvStartDatePicker.setText(sdf.format(sCalendar.time))
    }

    //  여행 종료일 DatePicker 클릭
    private fun initEndDatePicker() {
        tvEndDatePicker = findViewById(R.id.plan_tv_end_date)
        btnEndDatePicker = findViewById(R.id.plan_iv_end_dataPicker)

        val eDatePicler = DatePickerDialog.OnDateSetListener { view, year, month, datOfMonth ->
            eCalendar.set(Calendar.YEAR, year)
            eCalendar.set(Calendar.MONTH, month)
            eCalendar.set(Calendar.DAY_OF_MONTH, datOfMonth)
            updateEndDateLable(eCalendar)
        }

        btnEndDatePicker.setOnClickListener {
            DatePickerDialog(this, eDatePicler, eCalendar.get(Calendar.YEAR), eCalendar.get(Calendar.MONTH), eCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    //  여행 종료일 DatePicker 날짜 넣기
    private fun updateEndDateLable(eCalendar: Calendar) {
        val myFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvEndDatePicker.setText(sdf.format(eCalendar.time))
    }

    //  뒤로가기 버튼 클릭 시 이전 엑티비티로 돌아가기기
   private fun initBackBtn() {
        val btn_back = findViewById<ImageView>(R.id.iv_top_bar_arrow_back)

        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
   }

    private fun initBtnAddPlan() {

        val type = intent.getStringExtra("type")

        binding.btnAddPlan.setOnClickListener {
            val title = binding.planEtTitle.text.toString()
            val sDate = binding.planTvStartDate.text.toString()
            val eDate = binding.planTvEndDate.text.toString()

            if(type.equals("ADD")){
                if(title.isNotEmpty() && sDate.isNotEmpty() && eDate.isNotEmpty()){
                    val addPlan = AddPlanDto(0, title, sDate, eDate)
                    val intent = Intent().apply {
                        putExtra("addPlan", addPlan)
                        putExtra("flag", 0)
                    }
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                    // 여행계획 수정
                }
           }
        }
    }


}