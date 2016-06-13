package com.example.chukc.shadowtitle;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class FragmentOne extends BaseFragment  implements ScrollViewListener{
    Toolbar toolbar;
    View view;
    ObservableScrollView scroll;
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu, inflater);
	menu.clear();
	inflater.inflate(R.menu.menu_main, menu);
	MenuItem menuItem_edit=menu.findItem(R.id.action_edit);
	MenuItem menuItem_share=menu.findItem(R.id.action_share);
	MenuItem menuItem_settings=menu.findItem(R.id.action_settings);
	menuItem_edit.setVisible(false);
	menuItem_share.setVisible(true);
	menuItem_settings.setVisible(false);
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
	// TODO Auto-generated method stub
	super.onPrepareOptionsMenu(menu);
//	getActivity().getMenuInflater().inflate(R.menu.menu_main, menu);
//	MenuItem menuItem_edit=menu.findItem(R.id.action_edit);
//	MenuItem menuItem_share=menu.findItem(R.id.action_share);
//	MenuItem menuItem_settings=menu.findItem(R.id.action_settings);
//	menuItem_edit.setVisible(false);
//	menuItem_share.setVisible(false);
//	menuItem_settings.setVisible(true);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	// TODO Auto-generated method stub
        view=inflater.inflate(R.layout.activity_main, container, false);
        toolbar = new TitleUtil_ToolBar((AppCompatActivity)getActivity(),view, "支付", new TitleUtil_ToolBar.RightClickListener() {
	    @Override
	    public void setClick(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case R.id.action_edit:

		    break;
		case R.id.action_share:

		    break;
		case R.id.action_settings:
		    break;
		default:
		    break;
		}
	    }
	}).show();
	scroll = (ObservableScrollView) view.findViewById(R.id.scroll);
	scroll.setScrollViewListener(this);
	return view;
    }

    @SuppressLint("UseValueOf")
    @Override
    public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
	// TODO Auto-generated method stub
	int progress =  (int)(new Float(y) / new Float(800) * 200);// 255
	if(y>0){
	    toolbar.setVisibility(View.VISIBLE);
	    if(progress<=255)
		view.findViewById(R.id.title).getBackground().mutate().setAlpha(progress);
	}else{
	    view.findViewById(R.id.title).getBackground().mutate().setAlpha(0);
	    toolbar.setVisibility(View.GONE);
	}
    }
}
