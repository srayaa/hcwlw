package com.hcwlw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hcwlw.bak.MainActivitybak;
import com.hcwlw.bak.MainActivitybak.GridViewItemOnClick;
import com.hcwlw.lib.Binds;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ToolboxActivity extends Activity {

	private GridView mGridView;   //MyGridView
    //����ͼ������
	private int[] imageRes = { R.drawable.lcb, R.drawable.tq,
								R.drawable.fj, R.drawable.gps, R.drawable.lcyj};
   //�����������
	private String[] itemName = { "�����", "������ѯ", "��������", "GPS����", "����˼�" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toolbox);
		
		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("�й�������-������");
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
		mGridView = (GridView) findViewById(R.id.GridView);
		List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        int length = itemName.length;
        for (int i = 0; i < length; i++) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("ItemImageView", imageRes[i]);
                map.put("ItemTextView", itemName[i]);
                data.add(map);
        }
        //Ϊitme.xml���������
       SimpleAdapter simpleAdapter = new SimpleAdapter(ToolboxActivity.this,
        data, R.layout.item, new String[] { "ItemImageView","ItemTextView" }, new int[] { R.id.ItemImage,R.id.ItemText });
        mGridView.setAdapter(simpleAdapter);
        //ΪmGridView��ӵ���¼�������
       mGridView.setOnItemClickListener(new GridViewItemOnClick());
	}
	public class GridViewItemOnClick implements OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int position,long arg3) {
               Toast.makeText(getApplicationContext(), position + "",
               Toast.LENGTH_SHORT).show();
        }
     }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.toolbox, menu);
		return true;
	}

}
