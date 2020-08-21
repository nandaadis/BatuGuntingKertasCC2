package com.example.batuguntingkertas.DataProfile

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.batuguntingkertas.R
import com.example.batuguntingkertas.ROOM.DatabaseMemo
import com.example.batuguntingkertas.ROOM.EntityMemo
import kotlinx.android.synthetic.main.rv_memo.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MemoAdapter(val listMemo: List<EntityMemo>) : RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_memo, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.et_tanggal.setText(listMemo[position].Tanggal)
        holder.itemView.et_isimemo.setText(listMemo[position].IsiMemo)
//        holder.itemView.l_rv.setOnLongClickListener {
//            val mDb = DatabaseMemo.getInstance(holder.itemView.context)
//
//            GlobalScope.launch {
//                mDb?.DaoMemo()?.delete(listMemo[position])
//                (holder.itemView.context as DataProfileActivity).fetchData()
//            }
//            true
//        }
        holder.itemView.l_rv.setOnClickListener {
//            val dialogFragment = Dialog()
//            val bundle = Bundle()
//            bundle.putString("memo", listMemo[position])
//            dialogFragment.setArguments(bundle)
//            dialogFragment.show(this.getSupportFragmentManager(), "Image Dialog")

            val fm = (holder.itemView.context as DataProfileActivity).supportFragmentManager
            val MyFragment = DialogEditMemo()
            val bundle = Bundle()
            bundle.putString("tanggal", listMemo[position].Tanggal)
            bundle.putString("isimemo", listMemo[position].IsiMemo)
            bundle.putString("MEMO", listMemo[position].id.toString())
            MyFragment.setArguments(bundle)
            MyFragment.show(fm, "Fragment")

        }
    }

}
