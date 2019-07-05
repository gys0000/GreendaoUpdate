package com.gystry.greendaoupdate

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gystry.greendaoupdate.bean.Student
import com.gystry.greendaoupdate.bean.StudentFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var i: Int = 0
    lateinit var str: StringBuffer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        str = StringBuffer()
        btn_add.setOnClickListener {
            i++
            Log.e("MainActivity", "i:$i")
            val student = Student()
            Log.e("MainActivity", "i:" + (0..10000).random().toLong())
            student.studentNo = ((0..10000).random()).toLong()
            student.age = 23 + i
            student.grade = "$i 年级"
            student.name = "haha$i"
            student.sex = "男"
            student.height = "183cm"
            StudentFactory.instance.insert(student)
        }
        btn_load.setOnClickListener {
            str.setLength(0)
            var studentList = StudentFactory.instance.loadAll()
            Log.e("MainActivity", "" + studentList?.size)

            if (studentList != null) {
                for (bean in studentList) {
                    Log.e("MainActivity", "bean.studentNo" + bean.studentNo)
                    str.append(bean.name).append(":").append(bean.id).append(":").append(bean.studentNo).append(":")
                        .append(bean.grade).append(":").append(bean.sex).append(bean.height)
                    str.append("\n")
                }
            }
            Log.e("MainActivity", "" + str.toString())
            tv_content.text = str.toString()
        }
    }
}
