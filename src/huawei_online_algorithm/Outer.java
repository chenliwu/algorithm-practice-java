package huawei_online_algorithm;

/**
 * @author chenlw
 * @date 2020/03/02
 */
public class Outer {

    public void someOuterMethod()
    {
        // Line 3
        new Inner(); // At line 3
    }
    public class Inner {}
    public static void main( String[]argv )
    {
        Outer o = new Outer();
        // Line 8
    }

}
