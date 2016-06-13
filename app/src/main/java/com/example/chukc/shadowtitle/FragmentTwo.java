package com.example.chukc.shadowtitle;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo extends BaseFragment{

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu, inflater);
	inflater.inflate(R.menu.menu_main, menu);
	menu.findItem(R.id.action_edit).setVisible(false);
	menu.findItem(R.id.action_share).setVisible(false);
	menu.findItem(R.id.action_settings).setVisible(true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	return inflater.inflate(R.layout.activity_main, container, false);
    }

}
