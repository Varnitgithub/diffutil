package com.example.diffutil

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
        mAdapter = adapter()
        recyclerview.setHasFixedSize(true)
        recyclerview.adapter = mAdapter
        val repository = repository(database.getcontext(this).dao())

        mViewmodelclass =
            ViewModelProvider(this, viewmodelfactory(repository))[viewmodelclass::class.java]

        val p1 = mynote(1, "one")
        val p2 = mynote(2, "two")
        val p3 = mynote(3, "three")
        val p4 = mynote(4, "four")
        val p5 = mynote(5, "five")

        val p6 = mynote(1, "one")
        val p7 = mynote(2, "two")
        val p8 = mynote(3, "three")
        val p9 = mynote(4, "four")
        val p10 = mynote(5, "five")
        val p11 = mynote(10, "cristiano ronaldo")
        val p12 = mynote(120, "virat kohli")


        val newnote: List<mynote> = listOf(p1, p2, p3, p4, p5)
        val afternewnote: List<mynote> = listOf(p6, p7, p8, p9, p10, p11, p12/*p13,p14,p15*/)

        mAdapter.updateitem(afternewnote)

        val p13 = mynote(3, "thirteen ")
        val p14 = mynote(4, "fourteen")
        val p15 = mynote(5, "hi bro! how r u")

        CoroutineScope(Dispatchers.Main).launch {
            val list = listOf<mynote>(p6, p7, p8,p9,p10,p11, p12, p15)
            delay(15000)
            mAdapter.updateitem(list)
        }


        // mAdapter.updateitem(afternewnote)
        //  Log.d("TAG", "onCreate: $it")
    }

}