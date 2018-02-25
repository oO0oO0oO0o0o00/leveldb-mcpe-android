package rbq2012.leveldb.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import rbq2012.leveldb.DB;
import rbq2012.leveldb.Iterator;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ActivityMain extends Activity {

	private EditText etDir;
	private TextView tvLog;
	private StringBuilder sbLog;

	public void btn0(View view){
		DB db = null;
		Iterator iter = null;
		try {
			db = new DB(getDbDir());
			db.open();
			iter = db.iterator();
			int count = 0;
			for (iter.seekToFirst(); iter.isValid(); iter.next()) {
				count++;
			}
			log("found "+count+" items.");
		}catch(Exception e) {
			log("iterator failed.");
			log(e);
		}finally{
			if(iter!=null) iter.close();
			if(db!=null) db.close();
		}
	}

	public void btn1(View view) {
		DB db=null;
		try{
			db = new DB(getDbDir());
			db.open();
			db.put("testkey".getBytes(),"testval".getBytes());
			log("db.put done.");
		}catch(Exception e){
			log("db.put failed.");
			log(e);
		}finally {
			if(db!=null)db.close();
		}
	}

	public void btn2(View view) {
		DB db=null;
		try{
			db = new DB(getDbDir());
			db.open();
			log("db.get: "+new String(db.get("testkey".getBytes())));
		}catch(Exception e){
			log("db.get failed.");
			log(e);
		}finally {
			if(db!=null)db.close();
		}
	}

	//Log text to a textview on the app.
	private void log(String text){
		sbLog.append(">>> ");
		sbLog.append(text);
		sbLog.append("\n");
		tvLog.setText(sbLog.toString());
	}

	//Log exception to a textview on the app.
	private void log(Exception e){
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		e.printStackTrace(pw);
		pw.flush();
		log(sw.toString());
		pw.close();
	}

	//Get the user spicified directory containing the leveldb database.
	private File getDbDir(){
		return new File(etDir.getText().toString());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etDir = (EditText) findViewById(R.id.editText);
		tvLog = (TextView) findViewById(R.id.textView);
		sbLog = new StringBuilder(">>> logcat\n");
	}
}
