package sth.core;

public class Date {

    private int _currentDate;

    Date(int ctime) {
        _currentDate = ctime;
    }

    protected int getCurrentDate() {
        return _currentDate;
    }

    protected void advanceDays(int nDays) {
            _currentDate = +nDays;

    }
}