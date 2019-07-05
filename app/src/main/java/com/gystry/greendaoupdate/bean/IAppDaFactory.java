package com.gystry.greendaoupdate.bean;


import android.database.Cursor;

import java.util.List;

public interface IAppDaFactory {
    void insert(Student bean);
    void insertOrReplace(Student bean);
    void delete(Student bean);
    void deleteForId(String packageName);
    void deleteAll();
    void updataData(Student bean);
    List<Student> loadAll();
    List<Student> loadAllSort();
    Student loadForId(String name);
}
