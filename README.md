# iams-monkey
We newly implement the activity-insulated approach based on `Activity Manager Service (AMS)`.

We modify the `Monkey` source code and use the event injection method of Monkey. 

To manage activity transitions, we implement a listener based on `IActivityController` and set it to AMS.

The interface of IActivityController is showed here:
```
interface IActivityController
{
    /**
     * The system is trying to start an activity.  Return true to allow
     * it to be started as normal, or false to cancel/reject this activity.
     */
    boolean activityStarting(in Intent intent, String pkg);
    
    /**
     * The system is trying to return to an activity.  Return true to allow
     * it to be resumed as normal, or false to cancel/reject this activity.
     */
    boolean activityResuming(String pkg);
    
    /**
     * An application process has crashed (in Java).  Return true for the
     * normal error recovery (app crash dialog) to occur, false to kill
     * it immediately.
     */
    boolean appCrashed(String processName, int pid,
            String shortMsg, String longMsg,
            long timeMillis, String stackTrace);
}
```
