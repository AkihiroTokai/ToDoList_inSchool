package com.intechschool.oji.todolist;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by 1 on 15/11/22.
 */

@Table(name = "todo_table")
public class ToDoDB extends Model{
    
    @Column(name = "todo")
    public String todo;

    @Override
    public String toString() {
        return todo;
    }
}
