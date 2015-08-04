package com.example.drawabletest;

import java.util.ArrayList;


import com.zebra.sdk.comm.BluetoothConnection;
import com.zebra.sdk.comm.Connection;
import com.zebra.sdk.comm.ConnectionException;
import com.zebra.sdk.graphics.internal.ZebraImageAndroid;
import com.zebra.sdk.printer.ZebraPrinter;
import com.zebra.sdk.printer.ZebraPrinterFactory;
import com.zebra.sdk.printer.ZebraPrinterLanguageUnknownException;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;



public class MainActivity extends Activity {

	ArrayList<String> PS_list = new ArrayList<String>();
	private int mHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		final ImageView imgView =(ImageView)findViewById(R.id.imageView1);
		Button btnTest = (Button)findViewById(R.id.button1);

		btnTest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				new initializePrintFile().execute("00:03:7A:6C:52:78");
				Bitmap image = DrawBox();
				//Bitmap image = DrawBox();
				imgView.setImageBitmap(image);
			}
		});

	}

	private Bitmap DrawBox() {
		try{
			Paint paint = new Paint();
			Paint paint2 = new Paint();

			//paint.setAlpha(0x80);
			paint.setTextSize(80);
			//paint.
			paint.setColor(Color.WHITE); 
			paint.setStyle(Style.FILL); 
			paint.setTextAlign(Paint.Align.LEFT);
//			int width =  730;
			int width = 1460;
			
//			int width = 985;
			//			int width = (int) (paint.measureText("_________________________________") + 0.5f); // round
			float baseline = (int) (-paint.ascent()-3); // ascent() is negative
			
			mHeight = (int) (baseline * (20 + 4) + paint.descent() + 2.5f);
			Bitmap image = Bitmap.createBitmap(width, mHeight, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(image);
			canvas.drawPaint(paint);

			paint.setColor(Color.BLACK);
			paint.setTextSize(20);

			Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/bbb.ttf");
			paint.setTypeface(font);
			
			//ไม่บีบ Width 730
//			paint.setTextSize(20);
//			canvas.drawText("20 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກ ຮຫິສລຼກຕ້າ ຮຫິສລຼ", 10, baseline, paint);
//			paint.setTextSize(30);
//			canvas.drawText("30 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສ ຮຫິສລຼກ ຮຫິ", 10, (baseline * 2), paint);
//			paint.setTextSize(40);			
//			canvas.drawText("40 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກ", 10, (baseline * 3), paint);
//			paint.setTextSize(50);
//			canvas.drawText("50 ອລຼກຕ້າ ຮາຍໍ່ອລຼກຕ້າຕ້ ", 10, (baseline * 4) + 1.5f, paint);
			
			
//			paint.setTextSize(20);
//			canvas.drawText("20 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກ ຮຫິສລຼກຕ້າ ຮຫິສລຼ", 10, baseline, paint);
//			paint.setTextSize(30);
//			canvas.drawText("30 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສ ຮຫິສລຼກ ຮຫິ", 10, (baseline * 2), paint);
			paint.setTextSize(60);			
			canvas.drawText("                    ຊື່ການຄ້າ                   ", 10, (float) (baseline * 1.5), paint);
			canvas.drawText("ໂທລະສັບ.044-344344-3 (ພາສີອາກອນ ລວມ)", 10, (float) (baseline * 2.5), paint);
			canvas.drawText("ພາສີ ສະບັບເລກທີ 0105535134278", 10, (float) (baseline * 3.5), paint);
			canvas.drawText("ປີ້ ບໍ່ມີ ຂາຍ", 10,(float)  (baseline * 4.5), paint);
			canvas.drawText("29.07.2015 16:32	ຈໍານວນ ໃບແລ້ວ 013 - 076936", 10, (float) (baseline * 5.5), paint);			
			canvas.drawText("1 Pie ໄກ່ ເຜັດ                          45.00", 10, (float) (baseline * 7), paint);
			canvas.drawText("1 ຂ້າມ ຊີ້ນຫມູຕົ້ມ                     55.00", 10,(float)  (baseline * 8), paint);
			canvas.drawText("1 ນ້ໍາຕານ                               5.00", 10, (float) (baseline * 9), paint);
			canvas.drawText("-------------", 10, (float) (baseline * 10), paint);
			canvas.drawText("ທັງຫມົດ                 LAK        24,150.00", 10, (float) (baseline * 11), paint);
			canvas.drawText("ທັງຫມົດ                 BHT           105.00", 10, (float) (baseline * 12), paint);
			canvas.drawText("                     ຂໍຂອບໃຈ                ", 10, (float) (baseline * 13.5), paint);
			canvas.drawText("                     ຂໍຂອບໃຈ                ", 10, (float) (baseline * 14.5), paint);
			canvas.drawText("                     ຂໍຂອບໃຈ                ", 10, (float) (baseline * 15.5), paint);
			canvas.drawText("                     ຂໍຂອບໃຈ                ", 10, (float) (baseline * 16.5), paint);
			canvas.drawText("                     ຂໍຂອບໃຈ                ", 10, (float) (baseline * 17.5), paint);
			canvas.drawText("ທັງຫມົດ                 LAK        24,150.00", 10, (float) (baseline * 18.5), paint);
			canvas.drawText("ທັງຫມົດ                 BHT           105.00", 10, (float) (baseline * 19.5), paint);
			canvas.drawText("ທັງຫມົດ                 LAK        24,150.00", 10, (float) (baseline * 20.5), paint);
			canvas.drawText("ທັງຫມົດ                 BHT           105.00", 10, (float) (baseline * 21.5), paint);
			canvas.drawText("ທັງຫມົດ                 LAK        24,150.00", 10, (float) (baseline * 22.5), paint);
			canvas.drawText("ທັງຫມົດ                 BHT           105.00", 10, (float) (baseline * 23.5), paint);
//			canvas.drawText("40 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສ", 10, (baseline * 3), paint);
//			canvas.drawText("40 ສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສ", 10, (baseline * 3), paint);
			
//			paint.setTextSize(50);
//			canvas.drawText("50 ອລຼກຕ້າ ຮາຍໍ່ອລຼກຕ້າຕ້ ", 10, (baseline * 4) + 1.5f, paint);



//			paint2.setTextSize(50);
//			paint2.setTypeface(font);
//			paint2.setTextAlign(Paint.Align.CENTER); 
//
//			String pageTitle="TEXT";
//
//			Rect areaRect = new Rect(10, (int) ((baseline * 4)  +1.5f),  (int) ((baseline * 4) + 100), (int) ((baseline * 4) + 150));
//
//			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(10);        
//			paint.setStyle(Paint.Style.STROKE);   
//
//			canvas.drawRect(areaRect, paint);
//			paint.setStyle(Paint.Style.FILL); 
//			RectF bounds = new RectF(areaRect);			
//			bounds.right = paint.measureText(pageTitle, 0, pageTitle.length());			
//			// measure text height
//			bounds.bottom = paint.descent() - paint.ascent();
//			bounds.left += (areaRect.width() - bounds.right) / 2.0f;
//			bounds.top += (areaRect.height() - bounds.bottom) / 2.0f;
//
//			canvas.drawText(pageTitle, bounds.left/bounds.left, bounds.top - paint.ascent(), paint);

			//			canvas.drawRect(10, (baseline * 4)  +1.5f, (baseline * 4) + 100, (baseline * 4) + 150, paint);			
			//			canvas.drawText("TEXT-TEST", 15, (baseline * 5)  +3, paint2);


			return image;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;

	}

	private class initializePrintFile extends AsyncTask<String , Void, Void>  {  

		protected Void doInBackground(String... params)   {

			Bitmap image = DrawBox();
			try {
				Connection conn = new BluetoothConnection(params[0]);
				conn.open();
				ZebraPrinter printer = ZebraPrinterFactory.getInstance(conn);
				printer.printImage(new ZebraImageAndroid(image), 0, 0, 550, (int) (mHeight/2.5), false);
//				printer.printImage(new ZebraImageAndroid(image), 0, 0, 550, (int) (mHeight/2.5), false);
//				printer.printImage(new ZebraImageAndroid(image), 0, 0, 550, 412, false);
				conn.close();				

			} catch (ConnectionException e) {
				Log.d("= ISS Printing =", e.getMessage());
			} catch (ZebraPrinterLanguageUnknownException e) {
				Log.d("= ISS Printing =", e.getMessage());
			}  finally {
				image.recycle();
			}
			return null;  
		}  

	}

	private Bitmap GenBitmap()
	{
		try{
			
			PS_list.add("ProdCode");
			PS_list.add("ProdName");
			
			Paint paint = new Paint();
			//paint.setAlpha(0x80);
			paint.setTextSize(80);
			//paint.
			paint.setColor(Color.WHITE); 
			paint.setStyle(Style.FILL); 
			paint.setTextAlign(Paint.Align.LEFT);
			int width = 1460;
			//			int width = (int) (paint.measureText("_________________________________") + 0.5f); // round
			float baseline = (int) (-paint.ascent() + 1.5f); // ascent() is negative
			//int height = (int) (baseline * (2 + 4) + paint.descent() + 2.5f);
			int height = (int) ((baseline * ((PS_list.size() * 2) + 4)) + paint.descent() + 2.5f);
			
			Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(image);
			canvas.drawPaint(paint);

			paint.setColor(Color.BLACK);
			paint.setTextSize(50);

			Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/bbb.ttf");
			paint.setTypeface(font);

			canvas.drawText("ັຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ ຮຫິສລຼກຕ້າ", 0, baseline, paint);
			paint.setTextSize(70);
			canvas.drawText("ຮາຍໍ່ອລຼກຕ້າ ຮາຍໍ່ອລຼກຕ້າ ", 0, (baseline * 2) + 1.5f, paint);
			paint.setTextSize(100);
			canvas.drawText("ຮາຍໍ່ອລຼກຕ້າ ຮາຍໍ່ອລຼກຕ້າ ", 0, (baseline * 4) + 1.5f, paint);			
//			canvas.drawText("_____________________________", 0, (baseline * 4) + 1.5f, paint);




			
			String no = "no";
			String ProductCode = "ProdCode";

			String ProductDesc = "ProdName";

			String Quan = "Quantity";

			String Status = "Status";

			String totaldiscount = "DC";

			String total = "TT";
			int j = 4;
			
			//Begin set header
			paint.setTextSize(50);
			Rect areaRect = new Rect(10, (int) ((baseline * j)), 70, (int) ((baseline * j) + 50));

			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect, paint);
			paint.setStyle(Paint.Style.FILL); 
			RectF bounds = new RectF(areaRect);	
			//Set header
			bounds.right = paint.measureText(no, 0, no.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(no, bounds.left, bounds.top - paint.ascent(), paint);
			
			//Set Product Status
			Rect areaRect2 = new Rect(70, (int) ((baseline * j)),  280, (int) ((baseline * j) + 50));

			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect2, paint);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(areaRect2);	
			//Set header
			bounds.right = paint.measureText(Status, 0,Status.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect2.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect2.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(Status, bounds.left, bounds.top - paint.ascent(), paint);
		
			//Set Product Code
			
			Rect areaRect3 = new Rect(280, (int) ((baseline * j)),  500, (int) ((baseline * j) + 50));

			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect3, paint);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(areaRect3);	
			//Set header
			bounds.right = paint.measureText(ProductCode, 0,ProductCode.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect3.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect3.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(ProductCode, bounds.left, bounds.top - paint.ascent(), paint);
			
			//Product Quantity
			Rect areaRect4 = new Rect(500, (int) ((baseline * j)),  700, (int) ((baseline * j) + 50));

			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect4, paint);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(areaRect4);	
			//Set header
			bounds.right = paint.measureText(Quan, 0,Quan.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect4.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect4.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(Quan, bounds.left, bounds.top - paint.ascent(), paint);
			
			//Set Discount
			Rect areaRect5 = new Rect(700, (int) ((baseline * j)),  850, (int) ((baseline * j) + 50));

			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(100);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect5, paint);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(areaRect5);	
			//Set header
			bounds.right = paint.measureText(totaldiscount, 0,totaldiscount.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect5.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect5.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(totaldiscount, bounds.left, bounds.top - paint.ascent(), paint);
			
			
			//Set Total
			Rect areaRect6 = new Rect(850, (int) ((baseline * j)),  950, (int) ((baseline * j) + 50));

			paint.setColor(Color.BLACK);
//			paint.setStrokeWidth(10);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect6, paint);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(areaRect6);	
			//Set header
			bounds.right = paint.measureText(total, 0,total.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect6.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect6.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(total, bounds.left, bounds.top - paint.ascent(), paint);



			paint.setTextSize(50);
			
//			
////			
////			
////			
////			
////			
////			
////			
////			
////			
			
			//TEST BILL VIEW
			
			 no = "1";
			 ProductCode = "1234";

			 ProductDesc = "PodName";

			 Quan = "20";

			 Status = "TEST";

			 totaldiscount = "300";

			 total = "3000";
			 
				j++;
			
			Rect inareaRect = new Rect(10, (int) ((baseline * j)), 70, (int) ((baseline * j) + 50));

			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   
			canvas.drawRect(inareaRect, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect);	
			//Set header
			bounds.right = paint.measureText(no, 0, no.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(no, bounds.left, bounds.top - paint.ascent(), paint);
			
			//Set Product Status
			Rect inareaRect2 = new Rect(70, (int) ((baseline * j)),  280, (int) ((baseline * j) + 50));

			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(inareaRect2, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect2);	
			//Set header
			bounds.right = paint.measureText(Status, 0,Status.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect2.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect2.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(Status, bounds.left, bounds.top - paint.ascent(), paint);
		
			//Set Product Code
			
			Rect inareaRect3 = new Rect(280, (int) ((baseline * j)),  500, (int) ((baseline * j) + 50));


			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(inareaRect3, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect3);	
			//Set header
			bounds.right = paint.measureText(ProductCode, 0,ProductCode.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect3.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect3.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(ProductCode, 280, bounds.top - paint.ascent(), paint);
			
			//Product Quantity
			Rect inareaRect4 = new Rect(500, (int) ((baseline * j)),  700, (int) ((baseline * j) + 50));


			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(inareaRect4, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect4);	
			//Set header
			bounds.right = paint.measureText(Quan, 0,Quan.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect4.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect4.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(Quan, 700-bounds.right, bounds.top - paint.ascent(), paint);
			
			//Set Discount
			Rect inareaRect5 = new Rect(700, (int) ((baseline * j)),  850, (int) ((baseline * j) + 50));


			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(100);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(inareaRect5, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect5);	
			//Set header
			bounds.right = paint.measureText(totaldiscount, 0,totaldiscount.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect5.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect5.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(totaldiscount, 850-bounds.right, bounds.top - paint.ascent(), paint);
			
			
			//Set Total
			Rect inareaRect6 = new Rect(850, (int) ((baseline * j)),  950, (int) ((baseline * j) + 50));


			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(10);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(inareaRect6, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect6);	
			//Set header
			bounds.right = paint.measureText(total, 0,total.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect6.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect6.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(total, 950-bounds.right, bounds.top - paint.ascent(), paint);
			
			j++;
			
			Rect inareaRect7 = new Rect(10, (int) ((baseline * j)), 70, (int) ((baseline * j) + 50));
			


			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   
			canvas.drawRect(inareaRect7, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(inareaRect7);	
			//Set header
			bounds.right = paint.measureText(ProductDesc, 0, ProductDesc.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (inareaRect7.width() - bounds.right) / 2.0f;
			bounds.top += (inareaRect7.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(ProductDesc, bounds.left, bounds.top - paint.ascent(), paint);
			
			Rect areaRect8 = new Rect(90, (int) ((baseline * j)),  500, (int) ((baseline * j) + 50));
			String name = "Kubota RT100";

			paint.setColor(Color.TRANSPARENT);
//			paint.setStrokeWidth(0);        
			paint.setStyle(Paint.Style.STROKE);   

			canvas.drawRect(areaRect8, paint);
			paint.setColor(Color.BLACK);
			paint.setStyle(Paint.Style.FILL); 
			bounds = new RectF(areaRect8);	
			//Set header
			bounds.right = paint.measureText(name, 0,name.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (areaRect8.width() - bounds.right) / 2.0f;
			bounds.top += (areaRect8.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(name, 90, bounds.top - paint.ascent(), paint);

			for(int i = 0; i < PS_list.size(); i++)
			{

//				Rect areaRect = new Rect(10, (int) ((baseline * j)), 70, (int) ((baseline * j) + 50));
//
//				paint.setColor(Color.BLACK);
//				paint.setStrokeWidth(10);        
//				paint.setStyle(Paint.Style.STROKE);   
//
//				canvas.drawRect(areaRect, paint);
//				paint.setStyle(Paint.Style.FILL); 
//				RectF bounds = new RectF(areaRect);	
//				//Set header
//				bounds.right = paint.measureText(no, 0, no.length());			
//				bounds.bottom = paint.descent() - paint.ascent();
//				bounds.left += (areaRect.width() - bounds.right) / 2.0f;
//				bounds.top += (areaRect.height() - bounds.bottom) / 2.0f;					
//				canvas.drawText(no, bounds.left, bounds.top - paint.ascent(), paint);
//				
//				//Set Product Status
//				Rect areaRect2 = new Rect(70, (int) ((baseline * j)),  280, (int) ((baseline * j) + 50));
//
//				paint.setColor(Color.BLACK);
//				paint.setStrokeWidth(10);        
//				paint.setStyle(Paint.Style.STROKE);   
//
//				canvas.drawRect(areaRect2, paint);
//				paint.setStyle(Paint.Style.FILL); 
//				bounds = new RectF(areaRect2);	
//				//Set header
//				bounds.right = paint.measureText(Status, 0,Status.length());			
//				bounds.bottom = paint.descent() - paint.ascent();
//				bounds.left += (areaRect2.width() - bounds.right) / 2.0f;
//				bounds.top += (areaRect2.height() - bounds.bottom) / 2.0f;					
//				canvas.drawText(Status, bounds.left, bounds.top - paint.ascent(), paint);
//			
//				//Set Product Code
//				
//				Rect areaRect3 = new Rect(280, (int) ((baseline * j)),  500, (int) ((baseline * j) + 50));
//
//				paint.setColor(Color.BLACK);
//				paint.setStrokeWidth(10);        
//				paint.setStyle(Paint.Style.STROKE);   
//
//				canvas.drawRect(areaRect3, paint);
//				paint.setStyle(Paint.Style.FILL); 
//				bounds = new RectF(areaRect3);	
//				//Set header
//				bounds.right = paint.measureText(ProductCode, 0,ProductCode.length());			
//				bounds.bottom = paint.descent() - paint.ascent();
//				bounds.left += (areaRect3.width() - bounds.right) / 2.0f;
//				bounds.top += (areaRect3.height() - bounds.bottom) / 2.0f;					
//				canvas.drawText(ProductCode, bounds.left, bounds.top - paint.ascent(), paint);
//				
//				//Product Quantity
//				Rect areaRect4 = new Rect(500, (int) ((baseline * j)),  700, (int) ((baseline * j) + 50));
//
//				paint.setColor(Color.BLACK);
//				paint.setStrokeWidth(10);        
//				paint.setStyle(Paint.Style.STROKE);   
//
//				canvas.drawRect(areaRect4, paint);
//				paint.setStyle(Paint.Style.FILL); 
//				bounds = new RectF(areaRect4);	
//				//Set header
//				bounds.right = paint.measureText(Quan, 0,Quan.length());			
//				bounds.bottom = paint.descent() - paint.ascent();
//				bounds.left += (areaRect4.width() - bounds.right) / 2.0f;
//				bounds.top += (areaRect4.height() - bounds.bottom) / 2.0f;					
//				canvas.drawText(Quan, bounds.left, bounds.top - paint.ascent(), paint);
//				
//				//Set Discount
//				Rect areaRect5 = new Rect(700, (int) ((baseline * j)),  850, (int) ((baseline * j) + 50));
//
//				paint.setColor(Color.BLACK);
//				paint.setStrokeWidth(10);        
//				paint.setStyle(Paint.Style.STROKE);   
//
//				canvas.drawRect(areaRect5, paint);
//				paint.setStyle(Paint.Style.FILL); 
//				bounds = new RectF(areaRect5);	
//				//Set header
//				bounds.right = paint.measureText(totaldiscount, 0,totaldiscount.length());			
//				bounds.bottom = paint.descent() - paint.ascent();
//				bounds.left += (areaRect5.width() - bounds.right) / 2.0f;
//				bounds.top += (areaRect5.height() - bounds.bottom) / 2.0f;					
//				canvas.drawText(totaldiscount, bounds.left, bounds.top - paint.ascent(), paint);
//				
//				
//				//Set Total
//				Rect areaRect6 = new Rect(850, (int) ((baseline * j)),  950, (int) ((baseline * j) + 50));
//
//				paint.setColor(Color.BLACK);
//				paint.setStrokeWidth(10);        
//				paint.setStyle(Paint.Style.STROKE);   
//
//				canvas.drawRect(areaRect6, paint);
//				paint.setStyle(Paint.Style.FILL); 
//				bounds = new RectF(areaRect6);	
//				//Set header
//				bounds.right = paint.measureText(total, 0,total.length());			
//				bounds.bottom = paint.descent() - paint.ascent();
//				bounds.left += (areaRect6.width() - bounds.right) / 2.0f;
//				bounds.top += (areaRect6.height() - bounds.bottom) / 2.0f;					
//				canvas.drawText(total, bounds.left, bounds.top - paint.ascent(), paint);



//				String text = ("No.") + "     " + Status  + "     " +
//						ProductCode + "     " +
//						Quan + "     " +
//						totaldiscount + "     " + 
//						total;
//				canvas.drawText(text, 0, (baseline * j) + 1.5f, paint);
//			j++;
//				canvas.drawText(ProductDesc, 0, (baseline * j) + 1.5f, paint);
//				j++;
			}

			return image;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	private Canvas GenTextCenter(String header,Rect area){

		try{

			Paint paint = new Paint();

			paint.setColor(Color.WHITE); 
			paint.setStyle(Style.FILL); 
			paint.setTextAlign(Paint.Align.LEFT);
			int width = 1460;
			//			int width = (int) (paint.measureText("_________________________________") + 0.5f); // round
			float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
			int height = (int) (baseline * (2 + 4) + paint.descent() + 2.5f);
			Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(image);

			canvas.drawRect(area, paint);
			paint.setStyle(Paint.Style.FILL); 
			RectF bounds = new RectF(area);	
			//Set header
			bounds.right = paint.measureText(header, 0, header.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (area.width() - bounds.right) / 2.0f;
			bounds.top += (area.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(header, bounds.left, bounds.top - paint.ascent(), paint);

			return canvas;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	private Canvas GenTextRight(String header,Rect area){

		try{

			Paint paint = new Paint();

			paint.setColor(Color.WHITE); 
			paint.setStyle(Style.FILL); 
			paint.setTextAlign(Paint.Align.LEFT);
			int width = 1460;
			//			int width = (int) (paint.measureText("_________________________________") + 0.5f); // round
			float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
			int height = (int) (baseline * (2 + 4) + paint.descent() + 2.5f);
			Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(image);

			canvas.drawRect(area, paint);
			paint.setStyle(Paint.Style.FILL); 
			RectF bounds = new RectF(area);	
			//Set header
			bounds.right = paint.measureText(header, 0, header.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (area.width() - bounds.right) / 2.0f;
			bounds.top += (area.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(header, bounds.left+bounds.left, bounds.top - paint.ascent(), paint);

			return canvas;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	private Canvas GenTextLeft(String header,Rect area){

		try{

			Paint paint = new Paint();

			paint.setColor(Color.WHITE); 
			paint.setStyle(Style.FILL); 
			paint.setTextAlign(Paint.Align.LEFT);
			int width = 1460;
			//			int width = (int) (paint.measureText("_________________________________") + 0.5f); // round
			float baseline = (int) (-paint.ascent() + 0.5f); // ascent() is negative
			int height = (int) (baseline * (2 + 4) + paint.descent() + 2.5f);
			Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
			Canvas canvas = new Canvas(image);

			canvas.drawRect(area, paint);
			paint.setStyle(Paint.Style.FILL); 
			RectF bounds = new RectF(area);	
			//Set header
			bounds.right = paint.measureText(header, 0, header.length());			
			bounds.bottom = paint.descent() - paint.ascent();
			bounds.left += (area.width() - bounds.right) / 2.0f;
			bounds.top += (area.height() - bounds.bottom) / 2.0f;					
			canvas.drawText(header, bounds.left/bounds.left, bounds.top - paint.ascent(), paint);

			return canvas;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}




}
