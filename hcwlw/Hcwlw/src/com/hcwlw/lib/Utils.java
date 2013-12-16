package com.hcwlw.lib;

import com.hcwlw.R;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;

public class Utils {
	/**
	 * Ϊ���򴴽������ݷ�ʽ
	 */
	public void addShortcut(Application app,Activity activity){
		Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		//��ݷ�ʽ������
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, activity.getString(R.string.app_name));
		shortcut.putExtra("duplicate", false); //�������ظ�����
			
		//ָ����ǰ��ActivityΪ��ݷ�ʽ�����Ķ���: �� com.everest.video.VideoPlayer
		//ע��: ComponentName�ĵڶ�������������ϵ��(.)�������ݷ�ʽ�޷�������Ӧ����
		ComponentName comp = new ComponentName(app.getPackageName(), "."+activity.getLocalClassName());
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(Intent.ACTION_MAIN).setComponent(comp));

		//��ݷ�ʽ��ͼ��
		ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(app, R.drawable.ic_launcher);
		shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
			
		activity.sendBroadcast(shortcut);
	}
}
