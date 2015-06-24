package com.example.tools;

import java.util.List;

import com.example.timeline.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

/**
 * @author Codey 自定义数据适配器
 */
public class DataAdapter extends BaseAdapter {
	private Context mContext;
	private List<DataText> mList;

	public DataAdapter(Context context, List<DataText> list) {
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (mList == null) {
			return 0;
		}
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		if (mList == null) {
			return null;
		}
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		// 初始化各个控件
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.main_list, parent,false);
			holder.rv_text = (RelativeLayout) convertView
					.findViewById(R.id.rv_text);
			holder.content = (TextView) convertView
					.findViewById(R.id.tv_content);
			holder.date = (TextView) convertView.findViewById(R.id.text_date);
			holder.line = (View) convertView.findViewById(R.id.line_view);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		LayoutParams params = (LayoutParams) holder.line.getLayoutParams();// 用于设置细线位置
		if (position == 0) {
			holder.rv_text.setVisibility(View.VISIBLE);
			holder.date.setText(TimeFormat.format("hh:mm:ss",
					mList.get(position).getDate()));
			// holder.content.setText(mList.get(position).getText());公有的
			params.addRule(RelativeLayout.ALIGN_TOP, R.id.rv_text);
			params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.tv_content);
		} else {
			if (mList.get(position).getDate()
					.equals(mList.get(position - 1).getDate())) {
				holder.rv_text.setVisibility(View.GONE);
				params.addRule(RelativeLayout.ALIGN_TOP, R.id.tv_content);
				params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.tv_content);
			} else {
				holder.rv_text.setVisibility(View.VISIBLE);
				holder.date.setText(TimeFormat.format("hh:mm:ss",
						mList.get(position).getDate()));
				params.addRule(RelativeLayout.ALIGN_TOP, R.id.rv_text);
				params.addRule(RelativeLayout.ALIGN_BOTTOM, R.id.tv_content);
			}
		}
		holder.line.setLayoutParams(params);
		holder.content.setText(mList.get(position).getText());
		return convertView;
	}

	public static class ViewHolder {
		RelativeLayout rv_text;
		View line;
		TextView date;
		TextView content;
	}

}
