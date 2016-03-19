package szu.yu.lucky;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;

/**
 * Created by Administrator on 2016/3/19.
 */
public class LockManager {
    /**
     * 电源管理器，用来唤醒屏幕
     */
    private PowerManager pm;
    private PowerManager.WakeLock pw;

    /**
     *
     *
     */
    private KeyguardManager km;
    private KeyguardManager.KeyguardLock kl;


    public void wakeAndUnLock (Context context){
        pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        pw = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP|PowerManager.SCREEN_BRIGHT_WAKE_LOCK,"yu");
        pw.acquire();

        km = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        kl = km.newKeyguardLock("yu");

        kl.disableKeyguard();
    }



}
