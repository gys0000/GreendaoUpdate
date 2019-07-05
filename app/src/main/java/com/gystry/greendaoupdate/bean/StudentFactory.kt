package com.gystry.greendaoupdate.bean

import com.gystry.greendaoupdate.MyApp
import com.gystry.greendaoupdate.database.greenDao.db.StudentDao

class StudentFactory : IAppDaFactory {
    var studentDao: StudentDao? = MyApp.instance?.getDaoSession()?.studentDao


    override fun insert(bean: Student) {
        studentDao?.insert(bean)
    }

    override fun insertOrReplace(bean: Student) {
        studentDao?.insertOrReplace(bean)
    }

    override fun delete(bean: Student) {
        studentDao?.delete(bean)
    }

    override fun deleteForId(packageName: String) {
        studentDao?.delete(loadForId(packageName))
    }

    override fun deleteAll() {
        studentDao?.deleteAll()
    }

    override fun updataData(bean: Student) {
        studentDao?.update(bean)
    }

    override fun loadAll(): List<Student>? {
        return studentDao?.loadAll()
    }

    override fun loadAllSort(): List<Student>? {
        var daoSession = MyApp.instance?.getDaoSession()
        var queryBuilder = daoSession?.queryBuilder(Student::class.java)
        var orderAsc = queryBuilder?.orderAsc(StudentDao.Properties.Age)
        var list: MutableList<Student> = orderAsc?.list() as MutableList<Student>
        return if (list.size > 0) {
            list
        } else {
            null
        }
    }

    override fun loadForId(name: String): Student? {
        var daoSession = MyApp.instance?.getDaoSession()
        var queryBuilder = daoSession?.queryBuilder(Student::class.java)
        var builder = queryBuilder?.where(StudentDao.Properties.Name.eq(name))?.orderAsc(StudentDao.Properties.Name)
        var list: MutableList<Student> = builder?.list() as MutableList<Student>
        return if (list.size > 0) {
            list[0]
        } else {
            null
        }
    }

    private object AppHolder {
        val appExerFactory = StudentFactory()
    }

    companion object {
        val instance: StudentFactory
            get() = StudentFactory.AppHolder.appExerFactory
    }

}
