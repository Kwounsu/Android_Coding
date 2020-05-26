package com.example.androidcoding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter (context: Context, private val dataSource: ArrayList<User>): BaseAdapter() {
    private var layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val user = getItem(position)
        val viewHolder: ViewHolder
        val listItemRowView: View

        if (convertView == null) {
            listItemRowView = layoutInflater.inflate(R.layout.custom_listview, parent, false)
            viewHolder = ViewHolder()
            viewHolder.userFirstName = listItemRowView.findViewById(R.id.lv_txt_firstName)
            viewHolder.userLastName = listItemRowView.findViewById(R.id.lv_txt_lastName)
            viewHolder.userUserName = listItemRowView.findViewById(R.id.lv_txt_userName)
            listItemRowView.tag = viewHolder
        } else {
            listItemRowView = convertView
            viewHolder = listItemRowView.tag as ViewHolder
        }

        viewHolder.userFirstName.text = user.mFirstName
        viewHolder.userLastName.text = user.mLastName
        viewHolder.userUserName.text = user.mUserName

        return listItemRowView
    }

    override fun getItem(position: Int): User {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    class ViewHolder {
        lateinit var userFirstName:TextView
        lateinit var userLastName:TextView
        lateinit var userUserName:TextView
    }

}