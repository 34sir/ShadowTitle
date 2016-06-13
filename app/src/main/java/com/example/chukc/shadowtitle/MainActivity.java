package com.example.chukc.shadowtitle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements ScrollViewListener {
    ObservableScrollView scroll;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
//	toolbar = new TitleUtil_ToolBar(this, "支付",null, new TitleUtil_ToolBar.RightClickListener() {
//	    @Override
//	    public void setClick(int id) {
//		// TODO Auto-generated method stub
//		switch (id) {
//		case R.id.action_edit:
//
//		    break;
//		case R.id.action_share:
//
//		    break;
//		case R.id.action_settings:
//		    Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_LONG).show();
//		    break;
//		default:
//		    break;
//		}
//	    }
//	}).show();
	scroll = (ObservableScrollView) findViewById(R.id.scroll);
	scroll.setScrollViewListener(this);
    }

    public int getStatusBarHeight() {
	int result = 0;
	int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
	if (resourceId > 0) {
	    result = getResources().getDimensionPixelSize(resourceId);
	}
	return result;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu_main, menu);
	menu.findItem(R.id.action_edit).setVisible(false);
	menu.findItem(R.id.action_share).setVisible(false);
	menu.findItem(R.id.action_settings).setVisible(true);
	menu.findItem(R.id.action_share).setIcon(R.mipmap.fanhui);
	return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();

	// noinspection SimplifiableIfStatement
	if (id == R.id.action_settings) {
	    return true;
	}

	return super.onOptionsItemSelected(item);
    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
	@Override
	public boolean onMenuItemClick(MenuItem menuItem) {
	    String msg = "";
	    switch (menuItem.getItemId()) {
	    case R.id.action_edit:
		msg += "Click edit";
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
		break;
	    case R.id.action_share:
		msg += "Click share";
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
		break;
	    case R.id.action_settings:
		msg += "Click setting";
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
		break;
	    }

	    if (!msg.equals("")) {
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
	    }
	    return true;
	}
    };

    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
	// TODO Auto-generated method stub
	int progress =  (int)(new Float(y) / new Float(800) * 200);// 255
	if(y>0){
	    toolbar.setVisibility(View.VISIBLE);
	    if(progress<=255)
		findViewById(R.id.title).getBackground().mutate().setAlpha(progress);
	}else{
	    findViewById(R.id.title).getBackground().mutate().setAlpha(0);
	    toolbar.setVisibility(View.GONE);
	}
    }
}