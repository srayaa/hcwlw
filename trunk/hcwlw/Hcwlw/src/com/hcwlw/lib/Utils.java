package com.hcwlw.lib;

import com.hcwlw.R;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;

public class Utils {
	/**
	 * 为程序创建桌面快捷方式
	 */
	public void addShortcut(Application app,Activity activity){
		Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		//快捷方式的名称
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, activity.getString(R.string.app_name));
		shortcut.putExtra("duplicate", false); //不允许重复创建
			
		//指定当前的Activity为快捷方式启动的对象: 如 com.everest.video.VideoPlayer
		//注意: ComponentName的第二个参数必须加上点号(.)，否则快捷方式无法启动相应程序
		ComponentName comp = new ComponentName(app.getPackageName(), "."+activity.getLocalClassName());
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

		//快捷方式的图标
		ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(app, R.drawable.ic_launcher);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			
		activity.sendBroadcast(shortcut);
	}
}
