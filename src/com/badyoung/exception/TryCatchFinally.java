package com.badyoung.exception;

/**
 *  * program: javaBase
 *  * Description: 测试 try catch finally中的代码执行顺序
 *  * User: BadYoung
 *  * Date:2022-05-15 09
 *  * Time:58
 *  
 */
public class TryCatchFinally {



    /**
     * 不管有没有异常，finally块中代码都会执行
     * 当try和catch中有return时，finally仍然会执行。
     * finally是在return语句执行之后，返回之前执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，不管finally中的代码怎么样，返回的值都不会改变，仍然是之前保存的值），所以函数返回值是在finally执行前就已经确定了。
     * finally中如果包含return，那么程序将在这里返回，而不是try或catch中的return返回，返回值就不是try或catch中保存的返回值了。
     * @param args
     */


    public static void main(String[] args) {

    }

    /**
     * try里面有return，catch和finally里面吗没有return
     *
     * 1，先执行try块中语句（包括return语句中的表达式运算），但不返回；
     * 2，执行finally语句中全部代码
     * 3，最后执行try中return 返回
     *
     * @param i
     * @return
     */
    public static int tryTest(int i){
        try {
            System.out.println("try里面的语句执行了！");
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("final执行了");
        }
        return 0;
    }

    /**
     * try和finally里面包含return，catch里面不包含return
     *
     * 1，先执行try块中语句（包括return语句中的表达式运算），但不返回；
     * 2，执行finally块
     * 3，执行finally块，有return，从这里返回
     *
     * @param i
     * @return
     */
    public static int tryTest1(int i){
        try {
            System.out.println("try里面的语句执行了！");
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("final执行了");
            return i + 1;
        }
    }


    /**
     * try,catch里面包含return，finally里面不包含return，存在异常
     *
     1，先执行try块中语句，出现异常，catch捕获到异常；
     2，执行catch块中语句（包括return语句中的表达式运算），但不返回
     3，执行finally语句中全部代码
     4，最后执行catch中return 返回
     *
     * @param i
     * @return
     */
    public static int tryTest2(int i){
        try {
            System.out.println("try里面的语句执行了！");
            int number = 8 / 0;
            return i;
        }catch (Exception e){
            System.out.println("catch里面的语句执行了！");
            return i + 1;
        }finally {
            System.out.println("final执行了");
        }
    }

    /**
     * try,catch,finally里面都包含return，存在异常
     *
     * 1，先执行try块中语句，出现异常，catch捕获到异常；
     * 2，执行catch块中语句（包括return语句中的表达式运算），但不返回
     * 3，再执行finally块，
     * 4，执行finally块，有return，从这里返回。
     *
     * @param i
     * @return
     */
    public static int tryTest3(int i){
        try {
            System.out.println("try里面的语句执行了！");
            int number = 8 / 0;
            return i;
        }catch (Exception e){
            System.out.println("catch里面的语句执行了！");
            return i + 1;
        }finally {
            System.out.println("final执行了");
            return i + 2;
        }
    }


    /**
     * 对try语句块中return的基本类型变量，在finally语句块中把该变量值发生改变
     *
     try里面的语句执行了！
     final执行了
     0
     * 可以看出基本数据类型变量并不会改变返回的内容
     * @param i
     * @return
     */
    public static int tryTest4(int i){
        int result = 0;
        try {
            System.out.println("try里面的语句执行了！");
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("final执行了");
            result = i;
        }
        return -1;
    }


    /**
     * 对try语句块中return的引用类型变量，在finally语句块中把该变量值发生改变
     *
     * try里面的语句执行了！
     * final执行了
     * 8
     *可以看出引用类型变量也不会改变返回的内容
     * @param i
     * @return
     */
    public static int tryTest5(int i){
        Integer obj = i;
        try {
            System.out.println("try里面的语句执行了！");
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("final执行了");
            obj = null;
        }
        return -1;
    }


}
