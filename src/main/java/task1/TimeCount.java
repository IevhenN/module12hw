package task1;

public class TimeCount {
    private final int intervalNotification;
    private long startTime;
    private long currentTime;
    private long currentTimeSec;
    private boolean isChangeSec;
    private boolean needsNotification;

    public TimeCount(long startTime, int intervalNotification) {
        this.startTime = startTime;
        this.intervalNotification = intervalNotification;
    }
    public TimeCount(long startTime) {
        this(startTime,5);
    }

    public void setTime(long newTime){
        currentTime = newTime;

        long newTimeSec = getCurrentTimeSec();

        if (newTimeSec!=currentTimeSec) {
            isChangeSec=true;
            if (newTimeSec%intervalNotification == 0){
                needsNotification = true;
            }
        }
        currentTimeSec = newTimeSec;
    }

    private long getCurrentTimeSec() {
        return (currentTime-startTime)/1000;
    }


    public void showNextTime() {
        if (isChangeSec) {
            isChangeSec = false;
            System.out.println(toString());
        }
    }

    public void showNextNotification(){
        if (needsNotification&&!isChangeSec){
            needsNotification = false;

            System.out.println("Минуло "+intervalNotification+" секунд");
        }
    }

    @Override
    public String toString() {
        return currentTimeSec/3600+":"+currentTimeSec/60%60+":"+currentTimeSec%60;
    }
}
