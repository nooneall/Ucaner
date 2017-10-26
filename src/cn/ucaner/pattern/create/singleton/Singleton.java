/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.pattern.create.singleton;

/**
 * @author PhxNirvana 2017/3/14 0014.
 * 双重锁的单例
 */

public class Singleton {
    //防止外部创建实例
    private Singleton() {

    }
    //唯一实例
    private static volatile Singleton mInstance;

    public static Singleton getInstance() {
        //第一个锁，如果没有实例
        if (mInstance == null) {
            synchronized (Singleton.class) {
                //第二个锁，如果没有任何线程创建Singleton实例
                if (mInstance == null) {
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }
}
