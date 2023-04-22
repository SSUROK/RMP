package ru.surok.myfirstapplication.Data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {

    @PrimaryKey
    private int uid;

    @ColumnInfo(name="first_name")
    private String name;

    @ColumnInfo(name="last_name")
    private String lastname;

    @ColumnInfo(name="login")
    private String login;
}
