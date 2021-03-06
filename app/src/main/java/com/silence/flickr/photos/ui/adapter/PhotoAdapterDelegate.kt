package com.silence.flickr.photos.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.silence.flickr.R
import com.silence.flickr.common.extension.inflate
import com.silence.flickr.common.extension.url
import com.silence.flickr.photos.domain.entity.Photo
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapterDelegate(private val onPhotoClickListener: (Photo) -> Unit) : AdapterDelegate<MutableList<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PhotoViewHolder(parent.inflate(R.layout.item_photo))
    }

    override fun isForViewType(items: MutableList<Any>, position: Int): Boolean {
        return items[position] is Photo
    }

    override fun onBindViewHolder(
        items: MutableList<Any>,
        position: Int,
        holder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ) {
        (holder as PhotoViewHolder).bind(items[position] as Photo)
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(photo: Photo) {
            itemView.imgPhoto.setImageURI(photo.url())
            itemView.setOnClickListener { onPhotoClickListener.invoke(photo) }
        }
    }
}