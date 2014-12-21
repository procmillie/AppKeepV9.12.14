package ie.nuim.cs.appkeep;

//import ie.nuim.cs.appkeep.aboutpage;

//import ie.nuim.cs.appkeep.databasepage;
//import ie.nuim.cs.appkeep.notificationpage;
//import ie.nuim.cs.appkeep.timelinepage;  //all need to be changed when the rest are in place.


import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Homepage extends Activity implements OnClickListener {
    
    
   Button databaseButton; //button that links to the database, button1 in homepage.xml
   Button aboutButton;    //button that links to the about page, button2 in homepage.xml
   Button timelineButton; //button that links to the timeline page, button3 in homepage.xml
   Button notificationButton; //button that links to the notification page, button4 in homepage.xml
    
    
   @Override
   protected void onCreate(Bundle savedInstanceState) { 
       super.onCreate(savedInstanceState);
       setContentView(R.layout.homepage);
       
       aboutButton = (Button) findViewById(R.id.button2); //links each button to the corresponding button ID in the homepage layout
       aboutButton.setOnClickListener(this); //uses OnClickListener to allow the user to press the button to go to a new Activity
       
       databaseButton = (Button) findViewById(R.id.button1);
       databaseButton.setOnClickListener(this);
       
       timelineButton = (Button) findViewById(R.id.button3);
       timelineButton.setOnClickListener(this);
       
       notificationButton = (Button) findViewById(R.id.button4);
       notificationButton.setOnClickListener(this);
       
   }

   @Override
   public void onClick(View v) { //the onClick method that controls what the onClickListener associated with the above buttons will do
        
        switch(v.getId()) {
         
        	case R.id.button1:
        	//Intent databaseIntent=new Intent(getApplicationContext(), Database_Home123.class); 
            //  startActivity(databaseIntent);
        		Intent i = new Intent("ie.nuim.cs.appkeep.DATABASE_HOME123"); //an intent to bring the user to the Databse homepage when button1 is pressed
        		startActivity(i); //starts the intent above when the button is presed
           
        		break;
        
        case R.id.button2:
        	 Intent aboutIntent=new Intent(getApplicationContext(), About.class); 
             startActivity(aboutIntent);
              
              
             break;
         
         case R.id.button3:
        	 
             Intent timelineIntent=new Intent(getApplicationContext(), Database_Home123.class); 
             startActivity(timelineIntent);
              
             break;
         
         case R.id.button4:
        	 //Intent notificationIntent=new Intent(getApplicationContext(), Database_Home123.class); 
             //startActivity(notificationIntent);
             Intent d = new Intent("ie.nuim.cs.appkeep.ALARMACTIVITY");
     		startActivity(d);
              
             break;
          
   
      
   }
}




	
	

}
