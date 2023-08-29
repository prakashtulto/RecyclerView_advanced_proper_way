package com.example.recyclerviewadvanced

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewadvanced.databinding.RvItemBinding

class CustomAdapter(var datalist: ArrayList<Model>, var context: Context,) :RecyclerView.Adapter<CustomAdapter.ViewHolder>(){


  inner class ViewHolder(var binding: RvItemBinding ):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding=RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

         holder.binding.imageView.setImageResource(datalist[position].image)

         holder.binding.marqueeTextView.text=datalist[position].desc

         holder.binding.marqueeTextView.isSelected=true

         holder.binding.imageView.setOnClickListener{

            Toast.makeText(context, datalist[position].desc,Toast.LENGTH_SHORT).show()
             val dialog = Dialog(context)
             dialog.setContentView(R.layout.dialog)
             var imageView:ImageView =dialog.findViewById(R.id.imageDialog)
             imageView.setImageResource(datalist[position].image)
             dialog.show()
        }

        //call animation
        setAniamtion(holder.itemView,position)

    }

    override fun getItemCount(): Int {
       return   datalist.size
    }


    //set animation
    @SuppressLint("SuspiciousIndentation")
    private fun setAniamtion(viewToAnimate: View, position: Int){

           val animation : Animation =
             AnimationUtils.loadAnimation(context, R.anim.test)
             viewToAnimate.startAnimation(animation)

    }

}
