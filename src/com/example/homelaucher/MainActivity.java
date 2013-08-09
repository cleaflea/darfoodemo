package com.example.homelaucher;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.MediaController;

public class MainActivity extends Activity {

	public static final int WIDGETNUM = 7;
	
	private GridView homeScreenGridView = null;
	
	private int widgetIconWidth;
	private int widgetIconHeight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		System.out.println("it's start");
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		System.out.println("px width===> " + displayMetrics.widthPixels);
		System.out.println("px height===> " + displayMetrics.heightPixels);
		System.out.println("density===> " + displayMetrics.density);
		System.out.println("densitydpi===> " + displayMetrics.densityDpi);
		
		this.widgetIconWidth = (int) (displayMetrics.widthPixels/displayMetrics.density);

		this.homeScreenGridView = (GridView)this.findViewById(R.id.mainGridView);
		this.homeScreenGridView.setAdapter(new GridViewAdapter());
		
		this.homeScreenGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				switch (arg2) {
				case 0:	
					intent.setClass(MainActivity.this, CallActivity.class);
					startActivity(intent);
					break;
					
				case 2:
					intent.setClass(MainActivity.this, SMSActivity.class);
					startActivity(intent);
					break;

				default:
					break;
				}
			}
		});
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	class GridViewAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return WIDGETNUM;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
			View gridItemView = layoutInflater.inflate(R.layout.gridview_item, null);
			ImageView widgetIcon = (ImageView)gridItemView.findViewById(R.id.gvitem_iconview);	
						
			switch (position) {
			case 0:	
				widgetIcon.setImageResource(R.drawable.call);
				break;
				
			case 1:
				widgetIcon.setImageResource(R.drawable.contacts);
				break;
				
			case 2:
				widgetIcon.setImageResource(R.drawable.sms);
				break;
				
			case 3:
				widgetIcon.setImageResource(R.drawable.camera);
				break;
				
			case 4:
				widgetIcon.setImageResource(R.drawable.vedio);
				break;
				
			case 5:
				widgetIcon.setImageResource(R.drawable.photo);
				break;
				
			case 6:
				widgetIcon.setImageResource(R.drawable.calendar);
				break;
				
			default:
				break;
			}
			
			return gridItemView;
		}
		
	}

}
