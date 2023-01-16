package com.example.singleselectionactivity.singleselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.singleselectionactivity.R

class SingleSelectionRV : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView;
    private  var employees = ArrayList<Employee>()
    private  lateinit var adapter: SingleAdapter

    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_selection_rv)

        recyclerView = findViewById(R.id.recyclerViewCard)
        button = findViewById(R.id.button_get_selected)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        adapter = SingleAdapter(this, employees)
        recyclerView.adapter = adapter


        createList()

        button.setOnClickListener{

            if(adapter.selected != null) {
                showToast(adapter.selected.name);
            } else {
                showToast("No selections!")
            }
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    private fun createList() {
        employees = ArrayList()
        for(i in 0..20) {
            val employee = Employee()
            employee.name = "Suman " + ( i + 1)
            employee.isChecked = false
            employees.add(employee)
        }

        adapter.setEmployees(employees)
    }
}