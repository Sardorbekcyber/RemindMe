package com.turbosoft.remindme.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity (tableName = "tasks_table")
data class Task(
    @PrimaryKey (autoGenerate = true)
    val id : Int = 0,
    val name: String,
    val isImportant: Boolean = false,
    val isCompleted: Boolean = false,
    val timeCreated : Long = System.currentTimeMillis()
) : Parcelable{
    val createdDataFormat : String
        get() = DateFormat.getDateTimeInstance().format(timeCreated)

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readLong()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeByte(if (isImportant) 1 else 0)
        parcel.writeByte(if (isCompleted) 1 else 0)
        parcel.writeLong(timeCreated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Task> {
        override fun createFromParcel(parcel: Parcel): Task {
            return Task(parcel)
        }

        override fun newArray(size: Int): Array<Task?> {
            return arrayOfNulls(size)
        }
    }
}
