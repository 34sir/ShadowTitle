package com.example.chukc.shadowtitle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class TitleUtil_ToolBar {
    private AppCompatActivity activity;
    private String title;
    private RightClickListener listener;
    private View view;

    public TitleUtil_ToolBar(AppCompatActivity activity,View view, String title, RightClickListener listener) {
	// TODO Auto-generated constructor stub
	this.activity = activity;
	this.title = title;
	this.listener = listener;
	this.view=view;
    }

    public interface RightClickListener {
	public void setClick(int id);
    };

    public Toolbar show() {
	Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
	toolbar.setTitle(title);
	activity.setSupportActionBar(toolbar);
	toolbar.setOnMenuItemClickListener(onMenuItemClick);
	toolbar.setNavigationIcon(R.mipmap.fanhui);
	toolbar.getBackground().mutate().setAlpha(0);
	toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
	LinearLayout.LayoutParams param = (LinearLayout.LayoutParams) toolbar.getLayoutParams();
	param.setMargins(0, 0, 0, 0);
	toolbar.setLayoutParams(param);
	return toolbar;
    }

    public int getStatusBarHeight() {
  	int result = 0;
  	int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
  	if (resourceId > 0) {
  	    result = activity.getResources().getDimensionPixelSize(resourceId);
  	}
  	return result;
      }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
	@Override
	public boolean onMenuItemClick(MenuItem menuItem) {
	    switch (menuItem.getItemId()) {
	    case R.id.action_edit:
		listener.setClick(R.id.action_edit);
		break;
	    case R.id.action_share:
		listener.setClick(R.id.action_share);
		break;
	    case R.id.action_settings:
		listener.setClick(R.id.action_settings);
		break;
	    }
	    return true;
	}
    };
}
