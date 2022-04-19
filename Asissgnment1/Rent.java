package Session11.Asissgnment1;

import java.sql.Date;

public class Rent {
    public int StudentID;
    public int 	bookID;
    public Integer Qty;
    public Date StartDate;
    public Date EndDate;
    public Date UpdateDate;
    public Integer Status;
    public String Note;

    public Rent(int studentID, int bookID, Integer qty, Date startDate, Date endDate, Date updateDate, Integer status, String note) {
        StudentID = studentID;
        this.bookID = bookID;
        Qty = qty;
        StartDate = startDate;
        EndDate = endDate;
        UpdateDate = updateDate;
        Status = status;
        Note = note;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public Date getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(Date updateDate) {
        UpdateDate = updateDate;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
