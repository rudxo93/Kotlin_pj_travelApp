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
import java.text.SimpleDateFormat
import java.util.*

class AddPlanActivity : AppCompatActivity() {

    private lateinit var tvStartDatePicker : TextView
    private lateinit var btnStartDatePicker : ImageView

    private lateinit var tvEndDatePicker : TextView
    private lateinit var btnEndDatePicker : ImageView

    val sCalendar = Calendar.getInstance()
    val eCalendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plan)

        initBackBtn()
        initStartDatePicker()
        initEndDatePicker()

    }

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

    private fun updateStartDateLable(sCalendar: Calendar) {
        val myFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvStartDatePicker.setText(sdf.format(sCalendar.time))
    }

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

    private fun updateEndDateLable(eCalendar: Calendar) {
        val myFormat = "yyyy/MM/dd"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvEndDatePicker.setText(sdf.format(eCalendar.time))
    }

    private fun initBackBtn() {
        val btn_back = findViewById<ImageView>(R.id.iv_top_bar_arrow_back)

        btn_back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}