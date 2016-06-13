package com.example.chukc.shadowtitle;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

public class BaseFragment extends Fragment{
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	// TODO Auto-generated method stub
	super.onCreateOptionsMenu(menu, inflater);
	inflater.inflate(R.menu.menu_main, menu);
//	menu.findItem(R.id.action_edit).setVisible(false);
//	menu.findItem(R.id.action_share).setVisible(false);
//	menu.findItem(R.id.action_settings).setVisible(false);
    }

}
