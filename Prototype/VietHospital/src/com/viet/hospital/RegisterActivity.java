package com.viet.hospital;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends Activity {

	// GUI widget
	Button btnJoin, btnCancel;
	EditText etFirstName, etLastName, etDOB, etAddress, etLicense, etEmail,
			etPassword, etConfirmPassword, etPhoneNumber;
	RadioButton rbMale, rbFemale;
	
	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		getWidgetFromView();
		addWidgetListener();
	}

	private void getWidgetFromView() {
		btnJoin = (Button) findViewById(R.id.btnJoin);
		btnCancel = (Button) findViewById(R.id.btnCancel);

		etFirstName = (EditText) findViewById(R.id.etFirstName);
		etLastName = (EditText) findViewById(R.id.etLastName);
		etDOB = (EditText) findViewById(R.id.etDOB);
		etAddress = (EditText) findViewById(R.id.etAddress);
		etLicense = (EditText) findViewById(R.id.etLicense);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etPassword = (EditText) findViewById(R.id.etPassword);
		etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
		etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);

		rbMale = (RadioButton) findViewById(R.id.rbMale);
		rbFemale = (RadioButton) findViewById(R.id.rbFemale);
	}

	private void addWidgetListener() {
		// etDOB listener
		etDOB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showDialog(DATE_DIALOG_ID);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
			// Get current day
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
	        int month = c.get(Calendar.MONTH);
	        int day = c.get(Calendar.DAY_OF_MONTH);
	        
			// set date picker as current date
			return new DatePickerDialog(this, datePickerListener, year, month, day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			int year = selectedYear;
			int month = selectedMonth;
			int day = selectedDay;
			
			// set selected date into text view
			etDOB.setText(new StringBuilder().append(month + 1).append("-")
					.append(day).append("-").append(year).append(" "));
		}
	};

}
