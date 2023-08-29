package com.example.recyclerviewadvanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewadvanced.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var dataList: ArrayList<Model>

    lateinit var adapter: CustomAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        dataList=ArrayList()

        dataList.addAll(dataprovider.getData())

        binding.recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.recyclerView.adapter =CustomAdapter(dataList,this@MainActivity)

    }


//        val animation:Animation=
//             AnimationUtils.loadAnimation(applicationContext,R.anim.test)
//              imageView.startAnimation(animation)
//

    }


