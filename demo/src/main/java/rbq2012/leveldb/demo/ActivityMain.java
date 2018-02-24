package rbq2012.leveldb.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import rbq2012.leveldb.DB;
import rbq2012.leveldb.Iterator;

import java.io.File;

public class ActivityMain extends Activity {

	private File testFile;

	public void btn0(View view){
		DB db = null;
		Iterator iter = null;
		try {
			db = new DB(testFile);
			db.open();
			iter = db.iterator();
			int count = 0;
			for (iter.seekToFirst(); iter.isValid(); iter.next()) {
				count++;
			}
			Toast.makeText(this, "len: " + count, Toast.LENGTH_SHORT).show();
		}catch(Exception e) {
			e.printStackTrace();
			toast("failed.");
		}finally{
			if(iter!=null) iter.close();
			if(db!=null) db.close();
		}
	}

	public void btn1(View view) {
		DB db=null;
		try{
			db= new DB(testFile);
			db.open();
			db.put("Fuck who?".getBytes(),"Fuck me!".getBytes());
			toast("done.");
		}catch(Exception e){
			e.printStackTrace();
			toast("failed.");
		}finally {
			if(db!=null)db.close();
		}
	}

	public void btn2(View view) {
		DB db=null;
		try{
			db= new DB(testFile);
			db.open();
			toast(new String(db.get("Fuck who?".getBytes())));
		}catch(Exception e){
			e.printStackTrace();
			toast("failed.");
		}finally {
			if(db!=null)db.close();
		}
	}

	private void toast(String text){
		Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		testFile=new File("/sdcard/#aaa8/test");
	}
}
