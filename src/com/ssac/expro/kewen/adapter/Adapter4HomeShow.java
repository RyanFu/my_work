package com.ssac.expro.kewen.adapter;

import java.util.List;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ssac.expro.kewen.ExproApplication;
import com.ssac.expro.kewen.R;
import com.ssac.expro.kewen.bean.ShowInfo;
import com.ssac.expro.kewen.service.MainService;
import com.ssac.expro.kewen.util.ImageCacheUtil;

public class Adapter4HomeShow extends BaseAdapter {

	private LayoutInflater lin;
	private List<ShowInfo> list;
	private Context c;

	public Adapter4HomeShow(Context mContext) {
		c = mContext;
		lin = LayoutInflater.from(c);
		this.list = MainService.showList;
	}

	public void addNewData() {

		this.notifyDataSetChanged();

	}

	public int getCount() {
		return list.size();
	}

	public Object getItem(int paramInt) {
		return list.get(paramInt);
	}

	public long getItemId(int paramInt) {
		return list.indexOf(getItem(paramInt));// >getCount()?paramInt%getCount():paramInt;
	}

	public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
		if (paramView != null && paramView.findViewById(R.id.imgOfHomeShowItem) != null) {
			Log.d("getview-----saved", "doGetView-------get TextView-----------" + paramInt);
		} else {
			Log.d("getview", "doGetView-------new TextView-----------" + paramInt);
			// 把xml布局文件变成View对象
			paramView = lin.inflate(R.layout.item_home_show, null);
		}
		final ViewHolder vh = new ViewHolder();
		vh.image = (ImageView) paramView.findViewById(R.id.imgOfHomeShowItem);
		vh.image.setScaleType(ImageView.ScaleType.FIT_XY);
		vh.title = (TextView) paramView.findViewById(R.id.tvOfHomeShowItem);
		// 设置数据
		ShowInfo Ninfo = list.get(paramInt);
		// 取图片
		String imageUrl = Ninfo.getTitleImage();
		ImageCacheUtil ic = new ImageCacheUtil();
		ic.loadImageList(ExproApplication.imageLoader, vh.image, imageUrl);
		vh.title.setText(Ninfo.getDramaName());

		return paramView;
	}

	private static class ViewHolder {
		ImageView image;
		TextView title;
	}
}
