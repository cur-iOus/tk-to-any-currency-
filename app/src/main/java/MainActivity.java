package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.text.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	EditText userEditText;
	TextView resultView, UserCoin;
	double resultUsd, usd, finalResult, AustralianDollar = 62;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);			
		
		userEditText=(EditText) findViewById(R.id.userEditTextID);
		resultView=(TextView) findViewById(R.id.resultViewID);
		UserCoin=(TextView) findViewById(R.id.userCoinID);
		
		userCoinChange();
		changeListener(84);
		Toast.makeText(MainActivity.this, "Auto Selected US Dollar", Toast.LENGTH_LONG).show();
    }
	
	public void userCoinChange(){

		UserCoin.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					PopupMenu popup = new PopupMenu(MainActivity.this, UserCoin);
					popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

					popup.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener(){

							@Override
							public boolean onMenuItemClick(MenuItem item)
							{
								String coin = item.getTitle().toString();
								UserCoin.setText(item.getTitle());
								Toast.makeText(MainActivity.this, "Selected: "+item.getTitle(), Toast.LENGTH_SHORT).show();
								switch(coin){
									case "Australian Dollar":
										changeListener(62);
										notifyDataSetChanged();
										break;
									case "Argentine Peso":
										changeListener(1.15);
										break;
									case "Afghan Afghani":
										changeListener(1.10);
										break;
									case "Brazilian Real":
										changeListener(16);
										break;
									case "Bahraini Dinar":
										changeListener(225.28);
										break;
									case "Canadian Dollar":
										changeListener(64.81);
										break;
									case "Chilean Peso":
										changeListener(0.11);
										break;
									case "Cuban Peso":
										changeListener(81);
										break;
									case "Croatian Kuna":
										changeListener(13.33);
										break;
									case "Colombian Peso":
										changeListener(0.023);
										break;
									case "CAcfa Franc":
										changeListener(0.15);
										break;
									case "Danish Krone":
										changeListener(13.51);
										break;
									case "EURO":
										changeListener(100);
										break;
									case "Egyptian Pound":
										changeListener(5.38);
										break;
									case "Fijian Dollar":
										changeListener(40.39);
										break;
									case "Gambian Dalasi":
										changeListener(1.64);
										break;
									case "Hong Kong Dollar":
										changeListener(10.96);
										break;
									case "Hungarian Forint":
										changeListener(0.28);
										break;
									case "Indian Rupee":
										changeListener(1.15);
										break;
									case "Iranian Rial":
										changeListener(0.0020);
										break;
									case "Iraqi Dinar":
										changeListener(0.071);
										break;
									case "Israeli New Shekel":
										changeListener(25.12);
										break;
									case "Japanese Yen":
										changeListener(0.80);
										break;
									case "Kuwaiti Dinar":
										changeListener(277.77);
										break;
									case "Kenyan Shilling":
										changeListener(0.78);
										break;
									case "Lebanese Pound":
										changeListener(0.056);
										break;
									case "Libyan Dinar":
										changeListener(63);
										break;
									case "Maldivian Rufiyaa":
										changeListener(5.51);
										break;
									case "Malayasian Ringgit":
										changeListener(20);
										break;
									case "Mexican Peso":
										changeListener(3.91);
										break;
									case "Myanmar Kyat":
										changeListener(0.064);
										break;
									case "Netherlands Antillean Guilder":
										changeListener(47.30);
										break;
									case "New Zealan Dollar":
										changeListener(56.94);
										break;
									case "Norwegian Dollar":
										changeListener(9.50);
										break;
									case "Nepalese Rupee":
										changeListener(0.72);
										break;
									case "Omani Rial":
										changeListener(220);
										break;
									case "Pakistani Rupee":
										changeListener(0.51);
										break;
									case "Pound Sterling":
										changeListener(111.7);
										break;
									case "Panamanian Bolboa":
										changeListener(84.89);
										break;
									case "Paraguayan Guarani":
										changeListener(0.012);
										break;
									case "Poland Złoty":
										changeListener(22.55);
										break;
									case "Qatari Rial":
										changeListener(23);
										break;
									case "Russian Ruble":
										changeListener(1.12);
										break;
									case "SouthAfrican Rand":
										changeListener(5);
										break;
									case "Saudi Riyal":
										changeListener(22);
										break;
									case "Singapore Dollar":
										changeListener(62.13);
										break;
									case "South Korean Won":
										changeListener(0.071);
										break;
									case "Swedish Krona":
										changeListener(9.71);
										break;
									case "Serbian Dinar":
										changeListener(0.86);
										break;
									case "Somali Shilling":
										changeListener(0.15);
										break;
									case "Sri Lankan Rupee":
										changeListener(0.46);
										break;
									case "Swiss Franc":
										changeListener(93.06);
										break;
									case "Tunisian Dinar":
										changeListener(31);
										break;
									case "Turkish Lira":
										changeListener(11.39);
										break;
									case "US Dollar":
										changeListener(84);
										break;
									case "UAE Dirham":
										changeListener(20);
										break;
									case "Ugandan Shilling":
										changeListener(0.023);
										break;
									case "Vietnamese Dong":
										changeListener(0.0037);
										break;
									default:
								}
								 
								return true;
							}

							private void notifyDataSetChanged()
							{
								// TODO: Implement this method
							}
							
						});
					popup.show();
				}
			});
	}
	
	public double changeListener(final double DiffValue){
		
		userEditText.addTextChangedListener(new TextWatcher(){

				@Override
				public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					String beforeChange = userEditText.getText().toString();
				}

				@Override
				public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
				{
					String beforeChange = userEditText.getText().toString();
				}

				@Override
				public void afterTextChanged(Editable p1)
				{
					String afterChange = p1.toString();
					if(!afterChange.equals("")){
						finalResult = Double.parseDouble(afterChange)*DiffValue;
						resultView.setText("≈"+finalResult);
					}
					else{
						resultView.setText("");
					}
				}
		});
		
		return finalResult;
	}
}
