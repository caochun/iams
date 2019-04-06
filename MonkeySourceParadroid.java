/*
Customize Monkey Source for ParaDroid
*/

package com.android.commands.monkey;

import android.content.ComponentName;
import android.os.SystemClock;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.WindowManagerImpl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * monkey event queue
 */
public class MonkeySourceParadroid implements MonkeyEventSource {
    /**
     * Customize the operation when an activity is starting.
     */
    public Boolean onActivityStart(Intent intent, String pkg){
        //Return true or false according to the strategy
        return true;
    }

    /**
     * Customize the operation when an activity is going to finish.
     */
    public Boolean onActivityFinish(String pkg){
        //Return true or false according to the strategy
        return true;
    }

    /**
     * Customize the operation when the app crashes.
     */
    public void onCrash(String shortMsg, String longMsg){

    }

    /**
     * Generate events under a particular exploration algorithm.
     */
    private void generateEvents() {
        MonkeyEvent e = getNextEventFromAlgorithm();
        mQ.addLast(e);
    }

    /**
     * if the queue is empty, we generate events first
     * @return the first event in the queue
     */
    public MonkeyEvent getNextEvent() {
        if (mQ.isEmpty()) {
                generateEvents();
        }
        mEventCount++;
        MonkeyEvent e = mQ.getFirst();
        mQ.removeFirst();
        return e;
    }
}
