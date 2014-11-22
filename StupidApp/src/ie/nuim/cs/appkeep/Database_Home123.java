package ie.nuim.cs.appkeep;

import android.support.v7.app.ActionBarActivity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Database_Home123 extends ActionBarActivity {
	
	//Defining buttons for the DATABASE HOMEPAGE
	
		Button create, edit, lastDate, dueDate, reminder;
		
		EditText sqlSerialNum, sqlName, sqlLocation;
		//Toast t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database__home123);
		
		//setting up the connection between xml and java files for editText view and button views
		 sqlSerialNum = (EditText) findViewById(R.id.et_db_serial_num);
		 sqlName = (EditText) findViewById(R.id.et_db_equip_name);
		 sqlLocation = (EditText) findViewById(R.id.et_db_eqip_location);
		
		 create = (Button) findViewById(R.id.bn_db_input);
		 edit = (Button) findViewById(R.id.bn_db_edit);
		 lastDate = (Button) findViewById(R.id.bn_db_date_last_service);
		 dueDate = (Button) findViewById(R.id.bn_db_date_due);
		 reminder = (Button) findViewById(R.id.bn_db_set_reminder);
		 
	
	     //setting up an onClickListener for the create button
		 /*When you hit update, it gets the text and assigns the text to a string variable
		  * We create an instance of the Equipment123 class, pass in the context of 'this'
		  * This gets passed into the constructor for the Equipment123 class in Equipment123.java file
		  * The context that gets created in this constructor class gets used in the database open() method where
		  * the database helper class (dbHelper) gets instantiated.
		  * 
		  * From there, the dbHelper will create the database using the super class SQLiteOpenHelper and the onCreate() method
		  * where an SQLiteDatabase object is passed in and the attributes or 'columns' of the database are set up with SQL code
		  * 
		  * If a database has already been created, the program goes to the onUpgrade() method in the same class, drops the existing
		  * database and re-creates it using the createEntry() method in the same, Equipment123 class. Here, the strings from the 
		  * Database_Home123.java file are passed in.
		  * 
		  * Database is created using more SQL code and then the database is closed with the .close() method
		  * 
		  */
	        create.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					
					//catch exception to make sure that the createEntry into the database works
					boolean entryCheck = true;
					
					try{
					//strings to take the input from our user in the database homescreen
					String serialNum = sqlSerialNum.getText().toString();
					String name = sqlName.getText().toString();
					String location = sqlLocation.getText().toString();
					
					//new instance of the Equipment123 class to deal with our entry
					Equipment123 input = new Equipment123(Database_Home123.this);
					
					//open database
					input.open();
					
					//create the entry
					input.createEntry(serialNum, name, location);
					
					//close database
					input.close();
					}catch (Exception e){
						//if the thing doesn't work, we want to show a dialogue
						entryCheck = false;
						//set up a dialog to show the user the entry was unsuccessful
						Dialog d = new Dialog(Database_Home123.this);
						
						d.setTitle("Update");
						TextView tv = new TextView(Database_Home123.this);
						tv.setText("Unsuccessful");
						d.setContentView(tv);
						d.show();
					}finally{
						//print this if it works ok
						if(entryCheck){
							/*//set up a dialog to show the user the entry was successful
							Dialog d = new Dialog(Database_Home123.this);
							d.setTitle("Update");
							TextView tv = new TextView(Database_Home123.this);
							tv.setText("Successfully added");
							d.setContentView(tv);
							d.show();*/
						}
						
					}
					
					
					//add a toast to say updated
					Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
					
				}
			});
	     
	      //setting up an onClickListener for the edit button
	        edit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//intention to open up the SQL activity where we can view the full database
					Intent i = new Intent("ie.nuim.cs.appkeep.DATABASE_VIEW123");
					startActivity(i);
					
				}
			});
	        
	      //setting up an onClickListener for the date_of_last-service button
	        lastDate.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			}); 
	      
	        //setting up an onClickListener for the due-date-for-service button
	        dueDate.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			}); 
	        

	        //setting up an onClickListener for the set reminder button
	        reminder.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			}); 
	        
	        
	        //setting up an onClickListener for the set reminder button
	       // edit.setOnClickListener(new View.OnClickListener() {
				
				//@Override
				//public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
			//	}
			//});
		 
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database__home123, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
