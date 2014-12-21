package ie.nuim.cs.appkeep;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {  //initializes the Splash Activity and sets the content according to the splash layout file
        
        super.onCreate(savedInstanceState);
         
        setContentView(R.layout.splash);
        Thread timer = new Thread() //A time to make the splash screen disappear after a set time interval
        {
             
            public void run()
            {
                 
                try{
                     
                    sleep(3000); //timer is currently set to 3 seconds (3000 milliseconds)
                     
                } catch(InterruptedException e){  //allows the timer Thread to stop after the interval set in try
                     
                    e.printStackTrace();  
                     
                } finally{ //once the timer Thread has stopped, an intent (launchmain) launches the Homepage Activity
                     
                    Intent launchMain = new Intent("ie.nuim.cs.appkeep.HOMEPAGE");
                     
                    startActivity(launchMain);
                     
                }
                 
            }
             
        };
         
        timer.start();
         
    }
     

}
