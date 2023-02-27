package com.example.diffutil

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var mAdapter: adapter

    //lateinit var binding: ActivityMainBinding
    private lateinit var mViewmodelclass: viewmodelclass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview: RecyclerView = findViewById(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
      //  mAdapter = adapter()
        //recyclerview.adapter = mAdapter
        val repository = repository(database.getcontext(this).dao())

        mViewmodelclass =
            ViewModelProvider(this, viewmodelfactory(repository))[viewmodelclass::class.java]

        val p1 = mynote(1, "new")
        val p2 = mynote(2, "tyagi")
        val p3 = mynote(3, "delhi")
        val p4 = mynote(4, "india")
        val p5 = mynote(5, "virat")

        try {
            lifecycleScope.launch {
                mViewmodelclass.modellivedata(p1)
            }

        }
        catch (e:Exception){
            Log.d(TAG, "onCreate: ${e.message}")
        }

        mViewmodelclass.livedata?.observe(this){
          //  mAdapter.updateitem(it)
            Log.d("TAG", "onCreate: $it")
        }

    }
}