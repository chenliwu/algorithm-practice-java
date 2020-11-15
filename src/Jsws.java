/**
 * @author chenlw
 * @date 2020/03/11
 */
public class Jsws {

    private static Jsws jsws = new Jsws();

    private String name = "chenlw";
    private String sex = "Man";

    public static Jsws getInstance(){
        return jsws;
    }

    private Jsws(){ }

    public void start(){
//        WorkThread workThread = new WorkThread();
//        LiveThread liveThread = new LiveThread();
//        LearingThread learingThread = new LearingThread();
//        TravelThread travelThread = new TravelThread();
//        SportThread sportThread = new SportThread();
//        workThread.start();
//        liveThread.start();
//        learingThread.start();
//        travelThread.start();
//        sportThread.start();
    }

    public void destroy(){

    }

    public static void main(String[] args) {
        System.out.println("12345678".substring(0,8));
    }

}
