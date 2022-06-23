package com.example.spotify

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.spotify.databinding.ItemTodoBinding


class ContentAdapter(
   private val content: List<Artist>
):RecyclerView.Adapter<ContentAdapter.TodoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        holder.bind(content[position])
    }

    override fun getItemCount(): Int {
        return content.size
    }

    inner class TodoViewHolder(val binding: ItemTodoBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(content: Artist){
//load image to the recyclerview use glide library
            Glide.with(binding.root).load(content.image).into(binding.imageView)
            Log.d("response",content.image)

            binding.textViewArtistName.text = content.name
            binding.textViewTime.text = content.playCount
        }
    }

}