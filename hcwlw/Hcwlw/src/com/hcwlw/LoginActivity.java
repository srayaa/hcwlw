package com.hcwlw;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.hcwlw.InputMethodRelativeLayout.OnSizeChangedListenner;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity  implements OnSizeChangedListenner{
	/**
	 * A dummy authentication store containing known user names and passwords.
	 * TODO: remove after connecting to a real authentication system.
	 */
	/*private static final String[] DUMMY_CREDENTIALS = new String[] {
			"admin@admin:admin", "wjh@:wjhh" };*/

	/**
	 * The default email to populate the email field with.
	 */
	public static final String EXTRA_EMAIL = "com.example.android.authenticatordemo.extra.EMAIL";

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private UserLoginTask mAuthTask = null;

	// Values for email and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;
	private String mUid;
	// UI references.
	private AutoCompleteTextView mEmailView;
	private EditText mPasswordView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;
	private CheckBox rem_pw, auto_login; 
	private SharedPreferences sp;
	private Button btn_main_settings;
	
	private InputMethodRelativeLayout layout;  
    private LinearLayout boot ;
    private LinearLayout login_logo_layout_h ;
    private LinearLayout login_logo_layout_v ;
	protected void goToIndex(){
		Intent viewindex = new Intent(this,MainTabActivity.class);
		Bundle bun = new Bundle();
		bun.putString("uname", mEmail);  
		bun.putString("uid", mUid);  
		viewindex.putExtras(bun);
		this.startActivity(viewindex);
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Toast.makeText(this, "test", Toast.LENGTH_LONG).show();
		setContentView(R.layout.activity_login);
		//取得InputMethodRelativeLayout组件
		layout = (InputMethodRelativeLayout) this.findViewById(R.id.loginpage) ;
		//设置监听事件
        layout.setOnSizeChangedListenner(this) ;
        //取得大LOGO布局
        login_logo_layout_v = (LinearLayout) this.findViewById(R.id.login_logo_layout_v) ;
        //取得小LOGO布局
        login_logo_layout_h = (LinearLayout) this.findViewById(R.id.login_logo_layout_h) ;
        
        //取得找回密码和新注册布局
        boot = (LinearLayout) this.findViewById(R.id.reg_and_forget_password_layout) ;
		//sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
		//GetProp.setKey("url", "test");
		// Set up the login form.
		mEmail = getIntent().getStringExtra(EXTRA_EMAIL);
		mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
		mEmailView.setText(mEmail);

		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordView
				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
					@Override
					public boolean onEditorAction(TextView textView, int id,
							KeyEvent keyEvent) {
						if (id == R.id.login || id == EditorInfo.IME_NULL) {
							attemptLogin();
							return true;
						}
						return false;
					}
				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.sign_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						
						attemptLogin();
					}
				});
		findViewById(R.id.reg_in_button).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						//Intent i = new Intent(LoginActivity.this,Registry.class);
						//startActivity(i);
						//finish();
					}
				});
		//－－－－－－－－－－－自动登录开始
		sp = this.getSharedPreferences("passwordFile", MODE_PRIVATE);
		rem_pw = (CheckBox) findViewById(R.id.cb_mima);
		rem_pw.setChecked(true);// 默认为记住密码
		mEmailView.setText(sp.getString("USER_NAME", ""));
		mPasswordView.setText(sp.getString("PASSWORD", "")); 
		auto_login = (CheckBox) findViewById(R.id.cb_auto);
		auto_login.setChecked(false);
		if(sp.getBoolean("AUTO_ISCHECK", false)){
			auto_login.setChecked(true);
			attemptLogin();
		}
		mEmailView.setThreshold(1);
		mEmailView.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				String[] allUserName = new String[sp.getAll().size()];
				allUserName = sp.getAll().keySet().toArray(new String[0]);

				ArrayAdapter<String> adapter = new ArrayAdapter<String>( 
                         LoginActivity.this, 
                         android.R.layout.simple_dropdown_item_1line, 
                         allUserName); 
				mEmailView.setAdapter(adapter);
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				mPasswordView.setText(sp.getString(mEmailView.getText().toString(),""));
			}
		});
		auto_login.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (auto_login.isChecked()) {
					sp.edit().putBoolean("AUTO_ISCHECK", true).commit();
					
				}else{
					sp.edit().putBoolean("AUTO_ISCHECK", false).commit();
				}
			}
		});
		//-----------------自动登录结束
		btn_main_settings = (Button) findViewById(R.id.btn_main_settings);
		btn_main_settings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LoginActivity.this,SettingsActivity.class);
				startActivity(i);
			}
		});
	}
	/**
	 * 在Activity中实现OnSizeChangedListener，原理是设置该布局的paddingTop属性来控制子View的偏移
	 */
	@Override
	public void onSizeChange(boolean flag,int w ,int h) {  
        if(flag){//键盘弹出时
            layout.setPadding(0, -10, 0, 0);   
            boot.setVisibility(View.GONE) ;
            login_logo_layout_v.setVisibility(View.GONE) ;
            login_logo_layout_h.setVisibility(View.VISIBLE) ;
        }else{ //键盘隐藏时
            layout.setPadding(0, 0, 0, 0); 
            boot.setVisibility(View.VISIBLE) ;
            login_logo_layout_v.setVisibility(View.VISIBLE) ;
            login_logo_layout_h.setVisibility(View.GONE) ;
        }
    }  
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	
	

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 4) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid phone address.
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,0-9]))\\d{8}$");
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!p.matcher(mEmail).matches()) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView.setText(R.string.login_progress_signing_in);
			showProgress(true);
			mAuthTask = new UserLoginTask();
			mAuthTask.execute((Void) null);
			
		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
		@Override
		protected Boolean doInBackground(Void... params) {
			// TODO: attempt authentication against a network service.

			try {
				// Simulate network access.
				
				return true;
				/*
				Map<String,String> m = new LinkedHashMap<String,String>();
				m.put("ckModel.ckCkxx.sjhm", mEmail);
				m.put("ckModel.ckCkxx.pwd", mPassword);
				JSONObject result=null;// = new JSONObject(NetHelper.postRequest("ytdz/ytdz/ck/0/plogin", m));
				if(Integer.valueOf(result.getString("status"))>0){
					mUid = result.getString("status");
					return true;
				}else{
					return false;
				}
				*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				runOnUiThread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						mPasswordView.setTag("neterror");
						Toast.makeText(LoginActivity.this, "服务器连接失败，请检查网络！", Toast.LENGTH_LONG).show();
					}
					
				});
				return false;
			}

/*			for (String credential : DUMMY_CREDENTIALS) {
				String[] pieces = credential.split(":");
				if (pieces[0].equals(mEmail)) {
					// Account exists, return true if the password matches.
					return pieces[1].equals(mPassword);
				}
			}
*/
			// TODO: register the new account here.
			
			
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			mAuthTask = null;
			showProgress(false);

			if (success) {
				if (rem_pw.isChecked()){
					sp.edit().putString(mEmail, mPassword).commit();
					
					sp.edit().putString("USER_NAME", mEmail).commit();
					sp.edit().putString("PASSWORD", mPassword).commit();
					sp.edit().putBoolean("AUTO_ISCHECK", auto_login.isChecked()).commit();
				}
				goToIndex();
				finish();
				
			} else {
				if(mPasswordView.getTag()==null&&!mPasswordView.getTag().toString().equals("neterror")){
					mPasswordView.setTag("");
				mPasswordView
						.setError(getString(R.string.error_incorrect_password));
				mPasswordView.requestFocus();
				}
			}
		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
}
