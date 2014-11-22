package ie.nuim.cs.appkeep;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

//dealing with all database implementation

public class Equipment123 {
	
	//setting up database variables (final as they will not be changing)
	public static final String KEY_SERIAL_NUM = "_id";
	public static final String KEY_EQUIP_NAME = "equipment_name";
	public static final String KEY_LOCATION = "location";
	public static final String KEY_LAST_DATE = "service_last_date";
	public static final String KEY_DUE_DATE = "service_due_date";
	
	//Setting up the Database name
	
	private static final String DATABASE_NAME = "equipment";
	private static final String DATABASE_TABLE = "full_list";
	private static final int DATABASE_VERSION = 1;
	
	
	
	//creating a database helper reference variable
	private DbHelper appKeepHelper;
	//context for this class
	private final Context appKeepContext;
	// SQLiteDatabase reference variable
	private SQLiteDatabase appKeepDatabase;
	
	//setting up the database helper
	
	private static class DbHelper extends SQLiteOpenHelper{

		
		
		
		//A helper class to manage database creation and version management
		public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		
		
		//onCreate method will be called the first time the database is created
		//It creates our database
		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			//Creating our database according to our column headings, ie. input variables
			//Serial number is the primary key and we are saying that we want all fields to have an input, ie. not null
			db.execSQL("CREATETABLE "+ DATABASE_TABLE + " (" +
					KEY_SERIAL_NUM + " TEXT PRIMARY KEY, " +
					KEY_EQUIP_NAME + " TEXT NOT NULL, " +
					KEY_LOCATION + " TEXT NOT NULL, " +
					KEY_LAST_DATE + " TEXT NOT NULL, " +
					KEY_DUE_DATE + " TEXT NOT NULL);"
					
		    );
			
		}
		
		//ever after it calls the onUpgrade method
		//if the table is already created, then the upgrade method is called
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
			//drop the table and create the new updated database
			db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
			onCreate(db);
			
		}
	
	
	}
	
	//setting up a constructor for the Equipment123 class and passing in the context of our class
	public Equipment123(Context c){
		appKeepContext = c;
	}
	
	//method to open the database through the dbHelper
	public Equipment123 open(){
		//Creating an instance of the dbHelper. Class constructor takes in a Context
		appKeepHelper = new DbHelper(appKeepContext);
		//Creating an instance of the SQLiteDatabase
		appKeepDatabase = appKeepHelper.getWritableDatabase();
		return this;
			
	}
	//method to close the database
	public void close(){
		
		appKeepHelper.close();
	}

	public void createEntry(String serialNum, String name, String location) {
		// TODO Auto-generated method stub
		
	}

}
