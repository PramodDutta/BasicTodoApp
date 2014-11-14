package com.witmergers.basictodoapp;

import java.util.Date;

/**
 * Created by WP8Dev on 14-11-2014.
 */
public class NoteClass {

    public String id;
    public String Note;
    public Date date;

    public NoteClass() {
        //this.id = id;
    }

    public NoteClass(String id, String note, Date date) {
        this.id = id;
        Note = note;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
