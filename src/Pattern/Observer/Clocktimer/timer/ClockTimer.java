package Pattern.Observer.Clocktimer.timer;

public interface ClockTimer {
    int getHour();
    int getMinute();
    int getSecond();
    void tick();
}