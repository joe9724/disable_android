package com.bitekun.helper.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.bitekun.helper.HelpPeopleActvitity;
import com.bitekun.helper.R;
import com.bitekun.helper.UploadActivity;
import com.bitekun.helper.bean.GridItem;

public class AdapterGV extends ArrayAdapter<GridItem> {

	private Context mContext;
	private int layoutResourceId;
	private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();

	public AdapterGV(Context context, int resource, ArrayList<GridItem> objects) {
		super(context, resource, objects);
		this.mContext = context;
		this.layoutResourceId = resource;
		this.mGridData = objects;
	}

	public void setGridData(ArrayList<GridItem> mGridData) {
		this.mGridData = mGridData;
		notifyDataSetChanged();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.txt_item);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		GridItem item = mGridData.get(position);
		holder.textView.setText(item.getTitle());
		convertView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				switch (position) {
				case 0:
					mContext.startActivity(new Intent(mContext,
							HelpPeopleActvitity.class));
					break;
				case 1:
					mContext.startActivity(new Intent(mContext,
							UploadActivity.class));
					break;
				case 2:

					break;
				case 3:

					break;
				case 4:

					break;
				case 5:

					break;
				}

			}
		});

		return convertView;
	}

	private class ViewHolder {
		TextView textView;
		ImageView imageView;
	}

}
