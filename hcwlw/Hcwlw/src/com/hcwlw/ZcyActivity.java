package com.hcwlw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hcwlw.R.drawable;
import com.hcwlw.lib.Binds;

import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class ZcyActivity extends ListActivity  {

	private Spinner province_spinner;
	private Spinner city_spinner;
	private Spinner county_spinner;
	private Spinner province_spinner2;
	private Spinner city_spinner2;
	private Spinner county_spinner2;
	private Integer provinceId, cityId;
	private TextView display;
	private TextView display2;
	private TextView display3;
	private Spinner bh_spinner;
	private Spinner ck_spinner;
	private Spinner cx_spinner;
	private EditText hp_etx;
	private String strProvince, strCity, strCounty;
	
	private int[] city = {R.array.beijing_province_item, R.array.tianjin_province_item, R.array.heibei_province_item, R.array.shanxi1_province_item, R.array.neimenggu_province_item, R.array.liaoning_province_item, R.array.jilin_province_item, R.array.heilongjiang_province_item, R.array.shanghai_province_item, R.array.jiangsu_province_item, R.array.zhejiang_province_item, R.array.anhui_province_item, R.array.fujian_province_item, R.array.jiangxi_province_item, R.array.shandong_province_item, R.array.henan_province_item, R.array.hubei_province_item, R.array.hunan_province_item, R.array.guangdong_province_item,  R.array.guangxi_province_item, R.array.hainan_province_item, R.array.chongqing_province_item, R.array.sichuan_province_item, R.array.guizhou_province_item, R.array.yunnan_province_item, R.array.xizang_province_item, R.array.shanxi2_province_item, R.array.gansu_province_item, R.array.qinghai_province_item, R.array.linxia_province_item, R.array.xinjiang_province_item, R.array.hongkong_province_item, R.array.aomen_province_item, R.array.taiwan_province_item};
	private int[] countyOfBeiJing = {R.array.beijin_city_item};
	private int[] countyOfTianJing = {R.array.tianjin_city_item};
	private int[] countyOfHeBei = {R.array.shijiazhuang_city_item, R.array.tangshan_city_item, R.array.qinghuangdao_city_item, R.array.handan_city_item, R.array.xingtai_city_item, R.array.baoding_city_item, R.array.zhangjiakou_city_item, R.array.chengde_city_item, R.array.cangzhou_city_item, R.array.langfang_city_item, R.array.hengshui_city_item};
	private int[] countyOfShanXi1 = {R.array.taiyuan_city_item, R.array.datong_city_item, R.array.yangquan_city_item, R.array.changzhi_city_item, R.array.jincheng_city_item, R.array.shuozhou_city_item, R.array.jinzhong_city_item, R.array.yuncheng_city_item, R.array.xinzhou_city_item, R.array.linfen_city_item, R.array.lvliang_city_item};
	private int[] countyOfNeiMengGu = {R.array.huhehaote_city_item, R.array.baotou_city_item, R.array.wuhai_city_item, R.array.chifeng_city_item, R.array.tongliao_city_item, R.array.eerduosi_city_item, R.array.hulunbeier_city_item, R.array.bayannaoer_city_item, R.array.wulanchabu_city_item, R.array.xinganmeng_city_item, R.array.xilinguolemeng_city_item, R.array.alashanmeng_city_item};
	private int[] countyOfLiaoNing = {R.array.shenyang_city_item, R.array.dalian_city_item, R.array.anshan_city_item, R.array.wushun_city_item, R.array.benxi_city_item, R.array.dandong_city_item, R.array.liaoning_jinzhou_city_item, R.array.yingkou_city_item, R.array.fuxin_city_item, R.array.liaoyang_city_item, R.array.panjin_city_item, R.array.tieling_city_item, R.array.zhaoyang_city_item, R.array.huludao_city_item};
	private int[] countyOfJiLin = {R.array.changchun_city_item, R.array.jilin_city_item, R.array.siping_city_item, R.array.liaoyuan_city_item, R.array.tonghua_city_item, R.array.baishan_city_item, R.array.songyuan_city_item, R.array.baicheng_city_item, R.array.yanbian_city_item};
	private int[] countyOfHeiLongJiang = {R.array.haerbing_city_item, R.array.qiqihaer_city_item, R.array.jixi_city_item, R.array.hegang_city_item, R.array.shuangyashan_city_item, R.array.daqing_city_item, R.array.heilongjiang_yichun_city_item, R.array.jiamusi_city_item, R.array.qitaihe_city_item, R.array.mudanjiang_city_item, R.array.heihe_city_item, R.array.suihua_city_item, R.array.daxinganling_city_item};
	private int[] countyOfShangHai = {R.array.shanghai_city_item};
	
	private int[] countyOfJiangSu = {R.array.nanjing_city_item, R.array.wuxi_city_item, R.array.xuzhou_city_item, R.array.changzhou_city_item, R.array.nanjing_suzhou_city_item, R.array.nantong_city_item, R.array.lianyungang_city_item, R.array.huaian_city_item, R.array.yancheng_city_item, R.array.yangzhou_city_item, R.array.zhenjiang_city_item, R.array.jiangsu_taizhou_city_item, R.array.suqian_city_item};
	private int[] countyOfZheJiang = {R.array.hangzhou_city_item, R.array.ningbo_city_item, R.array.wenzhou_city_item, R.array.jiaxing_city_item, R.array.huzhou_city_item, R.array.shaoxing_city_item, R.array.jinhua_city_item, R.array.quzhou_city_item, R.array.zhoushan_city_item, R.array.zejiang_huzhou_city_item, R.array.lishui_city_item};
	private int[] countyOfAnHui = {R.array.hefei_city_item, R.array.wuhu_city_item, R.array.bengbu_city_item, R.array.huainan_city_item, R.array.maanshan_city_item, R.array.huaibei_city_item, R.array.tongling_city_item, R.array.anqing_city_item, R.array.huangshan_city_item, R.array.chuzhou_city_item, R.array.fuyang_city_item, R.array.anhui_suzhou_city_item, R.array.chaohu_city_item, R.array.luan_city_item, R.array.haozhou_city_item, R.array.chizhou_city_item, R.array.xuancheng_city_item};
	private int[] countyOfFuJian = {R.array.huzhou_city_item, R.array.xiamen_city_item, R.array.putian_city_item, R.array.sanming_city_item, R.array.quanzhou_city_item, R.array.zhangzhou_city_item, R.array.nanp_city_item, R.array.longyan_city_item, R.array.ningde_city_item};
	private int[] countyOfJiangXi = {R.array.nanchang_city_item, R.array.jingdezhen_city_item, R.array.pingxiang_city_item, R.array.jiujiang_city_item, R.array.xinyu_city_item, R.array.yingtan_city_item, R.array.ganzhou_city_item, R.array.jian_city_item, R.array.jiangxi_yichun_city_item, R.array.jiangxi_wuzhou_city_item, R.array.shangrao_city_item};
	private int[] countyOfShanDong = {R.array.jinan_city_item, R.array.qingdao_city_item, R.array.zaobo_city_item, R.array.zaozhuang_city_item, R.array.dongying_city_item, R.array.yantai_city_item, R.array.weifang_city_item, R.array.jining_city_item, R.array.taian_city_item, R.array.weihai_city_item, R.array.rizhao_city_item, R.array.laiwu_city_item, R.array.linxi_city_item, R.array.dezhou_city_item, R.array.liaocheng_city_item, R.array.shandong_bingzhou_city_item, R.array.heze_city_item};
	private int[] countyOfHeNan = {R.array.zhenshou_city_item, R.array.kaifang_city_item, R.array.luoyang_city_item, R.array.kaipingshan_city_item, R.array.anyang_city_item, R.array.hebi_city_item, R.array.xinxiang_city_item, R.array.jiaozuo_city_item, R.array.buyang_city_item, R.array.xuchang_city_item, R.array.leihe_city_item, R.array.sanmenxia_city_item, R.array.nanyang_city_item, R.array.shangqiu_city_item, R.array.xinyang_city_item, R.array.zhoukou_city_item, R.array.zhumadian_city_item};
	private int[] countyOfHuBei = {R.array.wuhan_city_item, R.array.huangshi_city_item, R.array.shiyan_city_item, R.array.yichang_city_item, R.array.xiangpan_city_item, R.array.erzhou_city_item, R.array.jinmen_city_item, R.array.xiaogan_city_item, R.array.hubei_jinzhou_city_item, R.array.huanggang_city_item, R.array.xianning_city_item, R.array.suizhou_city_item, R.array.enshi_city_item, R.array.shenglongjia_city_item};
	
	private int[] countyOfHuNan = {R.array.changsha_city_item, R.array.zhuzhou_city_item, R.array.xiangtan_city_item, R.array.hengyang_city_item, R.array.shaoyang_city_item, R.array.yueyang_city_item, R.array.changde_city_item, R.array.zhangjiajie_city_item, R.array.yiyang_city_item, R.array.hunan_bingzhou_city_item, R.array.yongzhou_city_item, R.array.huaihua_city_item, R.array.loudi_city_item, R.array.xiangxi_city_item};
	private int[] countyOfGuangDong = {R.array.guangzhou_city_item, R.array.shaoguan_city_item, R.array.shenzhen_city_item, R.array.zhuhai_city_item, R.array.shantou_city_item, R.array.foshan_city_item, R.array.jiangmen_city_item, R.array.zhangjiang_city_item, R.array.maoming_city_item, R.array.zhaoqing_city_item, R.array.huizhou_city_item, R.array.meizhou_city_item, R.array.shanwei_city_item, R.array.heyuan_city_item, R.array.yangjiang_city_item, R.array.qingyuan_city_item, R.array.dongguan_city_item, R.array.zhongshan_city_item, R.array.chaozhou_city_item, R.array.jiyang_city_item, R.array.yunfu_city_item};
	private int[] countyOfGuangXi = {R.array.nanning_city_item, R.array.liuzhou_city_item, R.array.guilin_city_item, R.array.guangxi_wuzhou_city_item, R.array.beihai_city_item, R.array.fangchenggang_city_item, R.array.qinzhou_city_item, R.array.guigang_city_item, R.array.yuelin_city_item, R.array.baise_city_item, R.array.hezhou_city_item, R.array.hechi_city_item, R.array.laibing_city_item, R.array.chuangzuo_city_item};
	private int[] countyOfHaiNan = {R.array.haikou_city_item, R.array.sanya_city_item};
	private int[] countyOfChongQing = {R.array.chongqing_city_item};
	private int[] countyOfSiChuan = {R.array.chengdu_city_item, R.array.zigong_city_item, R.array.panzhihua_city_item, R.array.luzhou_city_item, R.array.deyang_city_item, R.array.mianyang_city_item, R.array.guangyuan_city_item, R.array.suining_city_item, R.array.neijiang_city_item, R.array.leshan_city_item, R.array.nanchong_city_item, R.array.meishan_city_item, R.array.yibing_city_item, R.array.guangan_city_item, R.array.dazhou_city_item, R.array.yaan_city_item, R.array.bazhong_city_item, R.array.ziyang_city_item, R.array.abei_city_item, R.array.ganmu_city_item, R.array.liangshan_city_item};
	private int[] countyOfGuiZhou = {R.array.guiyang_city_item, R.array.lupanshui_city_item, R.array.zhunyi_city_item, R.array.anshun_city_item, R.array.tongren_city_item, R.array.qingxinan_city_item, R.array.biji_city_item, R.array.qingdongnan_city_item, R.array.qingnan_city_item};
	private int[] countyOfYunNan = {R.array.kunming_city_item, R.array.qujing_city_item, R.array.yuexi_city_item, R.array.baoshan_city_item, R.array.zhaotong_city_item, R.array.lijiang_city_item, R.array.simao_city_item, R.array.lingcang_city_item, R.array.chuxiong_city_item, R.array.honghe_city_item, R.array.wenshan_city_item, R.array.xishuangbanna_city_item, R.array.dali_city_item, R.array.dehuang_city_item, R.array.nujiang_city_item, R.array.diqing_city_item};
	private int[] countyOfXiZang = {R.array.lasa_city_item, R.array.changdu_city_item, R.array.shannan_city_item, R.array.rgeze_city_item, R.array.naqu_city_item, R.array.ali_city_item, R.array.linzhi_city_item};
	
	private int[] countyOfShanXi2 = {R.array.xian_city_item, R.array.tongchuan_city_item, R.array.baoji_city_item, R.array.xianyang_city_item, R.array.weinan_city_item, R.array.yanan_city_item, R.array.hanzhong_city_item, R.array.yulin_city_item, R.array.ankang_city_item, R.array.shangluo_city_item};
	private int[] countyOfGanSu = {R.array.lanzhou_city_item, R.array.jiayuguan_city_item, R.array.jinchang_city_item, R.array.baiyin_city_item, R.array.tianshui_city_item, R.array.wuwei_city_item, R.array.zhangyue_city_item, R.array.pingliang_city_item, R.array.jiuquan_city_item, R.array.qingyang_city_item, R.array.dingxi_city_item, R.array.longnan_city_item, R.array.linxia_city_item, R.array.gannan_city_item};
	private int[] countyOfQingHai = {R.array.xining_city_item, R.array.haidong_city_item, R.array.haibai_city_item, R.array.huangnan_city_item, R.array.hainan_city_item, R.array.guluo_city_item, R.array.yushu_city_item, R.array.haixi_city_item};
	private int[] countyOfNingXia = {R.array.yinchuan_city_item, R.array.shizuishan_city_item, R.array.wuzhong_city_item, R.array.guyuan_city_item, R.array.zhongwei_city_item};
	private int[] countyOfXinJiang = {R.array.wulumuqi_city_item, R.array.kelamayi_city_item, R.array.tulyfan_city_item, R.array.hami_city_item, R.array.changji_city_item, R.array.boertala_city_item, R.array.bayinguolen_city_item, R.array.akesu_city_item, R.array.kemuleisu_city_item, R.array.geshen_city_item, R.array.hetian_city_item, R.array.yili_city_item, R.array.tacheng_city_item, R.array.aleitai_city_item, R.array.shihezi_city_item, R.array.alaer_city_item, R.array.tumushihe_city_item, R.array.wujiaqu_city_item};
	private int[] countyOfHongKong = {R.array.hongkong_city_item};
	private int[] countyOfAoMen = {R.array.aomen_city_item};
	private int[] countyOfTaiWan = {R.array.taiwan_city_item};
	
	private ArrayAdapter<CharSequence> province_adapter;
	private ArrayAdapter<CharSequence> city_adapter;
	private ArrayAdapter<CharSequence> county_adapter;
	private ArrayAdapter<CharSequence> province_adapter2;
	private ArrayAdapter<CharSequence> city_adapter2;
	private ArrayAdapter<CharSequence> county_adapter2;
	
	private List<Map<String, Object>> mData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zcy);

		TextView title = (TextView) findViewById(R.id.txt_title);
		title.setText("中国物连网-找车源");
		loadSpinner(); //加载下拉框 
		loadSpinner2(); //加载下拉框 
		loadSpinner3(); //加载下拉框 
		final ImageButton t = (ImageButton)findViewById(R.id.btn_fromshow);
		final TableLayout tl = (TableLayout) findViewById(R.id.tableLayout1);
		t.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tl.getVisibility() == View.GONE){
					tl.setVisibility(View.VISIBLE);
					t.setImageResource(drawable.qz_icon_navbar_drop_up);
				}else{
					tl.setVisibility(View.GONE);
					t.setImageResource(drawable.qz_icon_navbar_drop_down);
				}
			}
		});
		Button t2 = (Button) findViewById(R.id.btn_from_sure);
		t2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tl.setVisibility(View.GONE);
				t.setImageResource(drawable.qz_icon_navbar_drop_down);
			}
		});
		final ImageButton tt = (ImageButton)findViewById(R.id.btn_fromshow2);
		final TableLayout ttl = (TableLayout) findViewById(R.id.tableLayout2);
		hp_etx = (EditText) findViewById(R.id.haopai); 
		tt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ttl.getVisibility() == View.GONE){
					ttl.setVisibility(View.VISIBLE);
					tt.setImageResource(drawable.qz_icon_navbar_drop_up);
				}else{
					ttl.setVisibility(View.GONE);
					tt.setImageResource(drawable.qz_icon_navbar_drop_down);
				}
			}
		});
		Button tt2 = (Button) findViewById(R.id.btn_from_sure2);
		tt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ttl.setVisibility(View.GONE);
				tt.setImageResource(drawable.qz_icon_navbar_drop_down);
			}
		});
		
		
		final ImageButton ttt = (ImageButton)findViewById(R.id.btn_fromshow3);
		final TableLayout tttl = (TableLayout) findViewById(R.id.tableLayout3);
		ttt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tttl.getVisibility() == View.GONE){
					tttl.setVisibility(View.VISIBLE);
					ttt.setImageResource(drawable.qz_icon_navbar_drop_up);
				}else{
					tttl.setVisibility(View.GONE);
					ttt.setImageResource(drawable.qz_icon_navbar_drop_down);
					display3.setText(bh_spinner.getSelectedItem().toString()+","+ck_spinner.getSelectedItem().toString()+","+cx_spinner.getSelectedItem().toString()+"  "+hp_etx.getText().toString());
				}
			}
		});
		Button ttt2 = (Button) findViewById(R.id.btn_from_sure3);
		ttt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tttl.setVisibility(View.GONE);
				ttt.setImageResource(drawable.qz_icon_navbar_drop_down);
				display3.setText((bh_spinner.getSelectedItem().toString().equals("不限")?"":(bh_spinner.getSelectedItem().toString()+","))+"车况："+ck_spinner.getSelectedItem().toString()+","+cx_spinner.getSelectedItem().toString()+"  号牌为："+(hp_etx.getText().toString().equals("")?"不限":hp_etx.getText().toString()));
			}
		});
		
		final ImageButton btn_fromshowall = (ImageButton) findViewById(R.id.btn_fromshowall);
		final LinearLayout ll = (LinearLayout) findViewById(R.id.main_container);
		btn_fromshowall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(ll.getVisibility() == View.GONE){
					ll.setVisibility(View.VISIBLE);
					btn_fromshowall.setImageResource(drawable.qz_icon_navbar_drop_up);
				}else{
					ll.setVisibility(View.GONE);
					btn_fromshowall.setImageResource(drawable.qz_icon_navbar_drop_down);
				}
			}
		});
		
/*		Binds binds = new Binds();
		binds.bindfooter(this, this);*/
		((Button) findViewById(R.id.btn_from_suresub)).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				initList();
			}
		});
	}

	private void initList(){
		
		/*
		 * 初始化List
		 */
		
		
		mData = getData();
		
		TextView tv =  (TextView) findViewById(R.id.nullresult);
		if(mData.size()>0){
			tv.setVisibility(View.GONE);
			this.getListView().setVisibility(View.VISIBLE);
		}else{
			tv.setText("暂无合适车源，建议您更换查询条件");
		}
		MyAdapter adapter = new MyAdapter(this);
		setListAdapter(adapter);
	}
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("carFrom", "从：河南省-鹤壁市-浚　县");
		map.put("carTo", "至：江苏省-无锡市-南长区");
		map.put("carNum", "车牌：豫F53969");
		map.put("carOwner", "联系人：赵海军");
		map.put("pubDate", "发布时间：2013-11-29 10:51");
		map.put("carLength", "车长：13米");
		map.put("carWeight", "载重：40吨");
		map.put("carPrice", "报价：面议");
		map.put("phone", "15839278627");
		map.put("img", R.drawable.ic_launcher);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("carFrom", "从：河南省-鹤壁市-浚　县");
		map.put("carTo", "至：上海市-上海市-卢湾区");
		map.put("carNum", "车牌：豫EX6868");
		map.put("carOwner", "联系人：杜先生");
		map.put("pubDate", "发布时间：2013-11-28 15:25");
		map.put("carLength", "车长：13米");
		map.put("carWeight", "载重：40吨");
		map.put("carPrice", "报价：面议");
		map.put("phone", "15839278627");
		map.put("img", R.drawable.ic_launcher2);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("carFrom", "从：河南省-鹤壁市-浚　县");
		map.put("carTo", "至：山东省-济南市-市辖区");
		map.put("carNum", "车牌：豫F53759");
		map.put("carOwner", "联系人：王庆军");
		map.put("pubDate", "发布时间：2013-04-12 15:55");
		map.put("carLength", "车长：10米");
		map.put("carWeight", "载重：20吨");
		map.put("carPrice", "报价：面议");
		map.put("phone", "15839278627");
		map.put("img", R.drawable.ic_launcher3);
		list.add(map);
		
		return list;
	}
	// ListView 中某项被选中后的逻辑
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		
		Log.v("MyListView4-click", (String)mData.get(position).get("title"));
	}
	
	/**
	 * listview中点击按键弹出对话框
	 */
/*	public void showInfo(){
		new AlertDialog.Builder(this)
		.setTitle("我的listview")
		.setMessage("介绍...")
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		})
		.show();
		
	}*/
	public final class ViewHolder{
		public ImageView img;
		public TextView carFrom;
		public TextView carTo;
		public TextView carNum;
		public TextView carOwner;
		public TextView pubDate;
		public TextView carLength;
		public TextView carWeight;
		public TextView carPrice;
		public Button viewBtn;
	}

	public class MyAdapter extends BaseAdapter{

		private LayoutInflater mInflater;
		
		
		public MyAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder = null;
			if (convertView == null) {
				
				holder=new ViewHolder();  
				
				convertView = mInflater.inflate(R.layout.diylist, null);
				holder.img = (ImageView)convertView.findViewById(R.id.img);
				holder.carFrom = (TextView)convertView.findViewById(R.id.carFrom);
				holder.carTo = (TextView)convertView.findViewById(R.id.carTo);
				holder.carNum = (TextView)convertView.findViewById(R.id.carNum);
				holder.carOwner = (TextView)convertView.findViewById(R.id.carOwner);
				holder.pubDate = (TextView)convertView.findViewById(R.id.pubDate);
				holder.carLength = (TextView)convertView.findViewById(R.id.carLength);
				holder.carWeight = (TextView)convertView.findViewById(R.id.carWeight);
				holder.carPrice = (TextView)convertView.findViewById(R.id.carPrice);
				holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
				convertView.setTag(holder);
				
			}else {
				
				holder = (ViewHolder)convertView.getTag();
			}
			
			
			holder.img.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.carFrom.setText((String)mData.get(position).get("carFrom"));
			holder.carTo.setText((String)mData.get(position).get("carTo"));
			holder.carNum.setText((String)mData.get(position).get("carNum"));
			holder.carOwner.setText((String)mData.get(position).get("carOwner"));
			holder.pubDate.setText((String)mData.get(position).get("pubDate"));
			holder.carLength.setText((String)mData.get(position).get("carLength"));
			holder.carWeight.setText((String)mData.get(position).get("carWeight"));
			holder.carPrice.setText((String)mData.get(position).get("carPrice"));
			
			holder.viewBtn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent phoneIntent = new Intent("android.intent.action.CALL",Uri.parse("tel:"+(String)mData.get(position).get("phone")));
					//启动
					startActivity(phoneIntent);				
				}
			});
			
			
			return convertView;
		}
		
	}

	
	
	private void loadSpinner3() {
		// TODO Auto-generated method stub
		  display3 = (TextView) findViewById(R.id.etx_from3);
		  bh_spinner = (Spinner) findViewById(R.id.benhui);
		  ck_spinner = (Spinner) findViewById(R.id.chekuang);
		  cx_spinner = (Spinner) findViewById(R.id.chexing);
		  bh_spinner.setPrompt("选择是否回程");
		  ck_spinner.setPrompt("选择车况");
		  cx_spinner.setPrompt("选择车型");
		  ArrayAdapter<CharSequence> bh = ArrayAdapter.createFromResource(this, R.array.bh_item,  android.R.layout.simple_spinner_item);
		  bh.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  bh_spinner.setAdapter(bh);
		  ArrayAdapter<CharSequence> ck = ArrayAdapter.createFromResource(this, R.array.ck_item,  android.R.layout.simple_spinner_item);
		  ck.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  ck_spinner.setAdapter(ck);
		  ArrayAdapter<CharSequence> cx = ArrayAdapter.createFromResource(this, R.array.cx_item,  android.R.layout.simple_spinner_item);
		  cx.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		  cx_spinner.setAdapter(cx);
/*		  bh_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				display3.setText(bh_spinner.getSelectedItem().toString()+","+ck_spinner.getSelectedItem().toString()+","+cx_spinner.getSelectedItem().toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			  
		});
		  ck_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			  
			  @Override
			  public void onItemSelected(AdapterView<?> arg0, View arg1,
					  int arg2, long arg3) {
				  // TODO Auto-generated method stub
				  display3.setText(bh_spinner.getSelectedItem().toString()+","+ck_spinner.getSelectedItem().toString()+","+cx_spinner.getSelectedItem().toString());
			  }
			  
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) {
				  // TODO Auto-generated method stub
				  
			  }
			  
		  });
		  cx_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			  
			  @Override
			  public void onItemSelected(AdapterView<?> arg0, View arg1,
					  int arg2, long arg3) {
				  // TODO Auto-generated method stub
				  display3.setText(bh_spinner.getSelectedItem().toString()+","+ck_spinner.getSelectedItem().toString()+","+cx_spinner.getSelectedItem().toString());
			  }
			  
			  @Override
			  public void onNothingSelected(AdapterView<?> arg0) {
				  // TODO Auto-generated method stub
				  
			  }
			  
		  });*/
		  //bh_spinner.setAdapter()
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zcy, menu);
		return true;
	}
	private void loadSpinner()
	{
		display = (TextView) findViewById(R.id.etx_from);
		province_spinner = (Spinner) findViewById(R.id.province_spinner);
		province_spinner.setPrompt("请选择省份");
		province_adapter = ArrayAdapter.createFromResource(this, R.array.province_item, android.R.layout.simple_spinner_item);
		province_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	province_spinner.setAdapter(province_adapter);
    	//select(province_spinner, province_adapter, R.array.province_item);
    	province_spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
    	{	
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) 
			{					
				provinceId = province_spinner.getSelectedItemPosition();
				strProvince = province_spinner.getSelectedItem().toString();
				city_spinner = (Spinner) findViewById(R.id.city_spinner);
				if(true)
				{	
					Log.v("test", "province: "+province_spinner.getSelectedItem().toString()+provinceId.toString());
					county_spinner = (Spinner) findViewById(R.id.county_spinner);
					city_spinner = (Spinner) findViewById(R.id.city_spinner);
					city_spinner.setPrompt("请选择城市");
					select(city_spinner, city_adapter, city[provinceId]);
					city_spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
					{


						@Override
						public void onItemSelected(AdapterView<?> arg0,
								View arg1, int arg2, long arg3) {
							cityId = city_spinner.getSelectedItemPosition();
							strCity = city_spinner.getSelectedItem().toString();
							Log.v("test", "city: "+city_spinner.getSelectedItem().toString()+cityId.toString());
							if(true)
							{
								county_spinner = (Spinner) findViewById(R.id.county_spinner);
								county_spinner.setPrompt("请选择县区");
								switch (provinceId) {
								case 0:
									select(county_spinner, county_adapter, countyOfBeiJing[cityId]);
									break;
								case 1:
									select(county_spinner, county_adapter, countyOfTianJing[cityId]);
									break;
								case 2:
									select(county_spinner, county_adapter, countyOfHeBei[cityId]);
									break;
								case 3:
									select(county_spinner, county_adapter, countyOfShanXi1[cityId]);
									break;
								case 4:
									select(county_spinner, county_adapter, countyOfNeiMengGu[cityId]);
									break;
								case 5:
									select(county_spinner, county_adapter, countyOfLiaoNing[cityId]);
									break;
								case 6:
									select(county_spinner, county_adapter, countyOfJiLin[cityId]);
									break;
								case 7:
									select(county_spinner, county_adapter, countyOfHeiLongJiang[cityId]);
									break;
								case 8:
									select(county_spinner, county_adapter, countyOfShangHai[cityId]);
									break;
								case 9:
									select(county_spinner, county_adapter, countyOfJiangSu[cityId]);
									break;
								case 10:
									select(county_spinner, county_adapter, countyOfZheJiang[cityId]);
									break;
								case 11:
									select(county_spinner, county_adapter, countyOfAnHui[cityId]);
									break;
								case 12:
									select(county_spinner, county_adapter, countyOfFuJian[cityId]);
									break;
								case 13:
									select(county_spinner, county_adapter, countyOfJiangXi[cityId]);
									break;
								case 14:
									select(county_spinner, county_adapter, countyOfShanDong[cityId]);
									break;
								case 15:
									select(county_spinner, county_adapter, countyOfHeNan[cityId]);
									break;
								case 16:
									select(county_spinner, county_adapter, countyOfHuBei[cityId]);
									break;
								case 17:
									select(county_spinner, county_adapter, countyOfHuNan[cityId]);
									break;
								case 18:
									select(county_spinner, county_adapter, countyOfGuangDong[cityId]);
									break;
								case 19:
									select(county_spinner, county_adapter, countyOfGuangXi[cityId]);
									break;
								case 20:
									select(county_spinner, county_adapter, countyOfHaiNan[cityId]);
									break;
								case 21:
									select(county_spinner, county_adapter, countyOfChongQing[cityId]);
									break;
								case 22:
									select(county_spinner, county_adapter, countyOfSiChuan[cityId]);
									break;
								case 23:
									select(county_spinner, county_adapter, countyOfGuiZhou[cityId]);
									break;
								case 24:
									select(county_spinner, county_adapter, countyOfYunNan[cityId]);
									break;
								case 25:
									select(county_spinner, county_adapter, countyOfXiZang[cityId]);
									break;
								case 26:
									select(county_spinner, county_adapter, countyOfShanXi2[cityId]);
									break;
								case 27:
									select(county_spinner, county_adapter, countyOfGanSu[cityId]);
									break;
								case 28:
									select(county_spinner, county_adapter, countyOfQingHai[cityId]);
									break;
								case 29:
									select(county_spinner, county_adapter, countyOfNingXia[cityId]);
									break;
								case 30:
									select(county_spinner, county_adapter, countyOfXinJiang[cityId]);
									break;
								case 31:
									select(county_spinner, county_adapter, countyOfHongKong[cityId]);
									break;
								case 32:
									select(county_spinner, county_adapter, countyOfAoMen[cityId]);
									break;
								case 33:
									select(county_spinner, county_adapter, countyOfTaiWan[cityId]);
									break;
				
								default:
									break;
								}
								
								county_spinner.setOnItemSelectedListener(new OnItemSelectedListener() 
								{


									@Override
									public void onItemSelected(
											AdapterView<?> arg0, View arg1,
											int arg2, long arg3) {
										strCounty = county_spinner.getSelectedItem().toString();
										display.setText(""+strProvince+"-"+strCity+"-"+strCounty);
									}


									@Override
									public void onNothingSelected(
											AdapterView<?> arg0) {
										
										
									}
								});
							}
						}


						@Override
						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub
							
						}


					});							
				}
			}


			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		
	}
		
	private void loadSpinner2()
	{
		display2 = (TextView) findViewById(R.id.etx_from2);
		province_spinner2 = (Spinner) findViewById(R.id.province_spinner2);
		province_spinner2.setPrompt("请选择省份");
		province_adapter2 = ArrayAdapter.createFromResource(this, R.array.province_item, android.R.layout.simple_spinner_item);
		province_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		province_spinner2.setAdapter(province_adapter2);
		//select(province_spinner, province_adapter, R.array.province_item);
		province_spinner2.setOnItemSelectedListener(new OnItemSelectedListener() 
		{	
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) 
			{					
				provinceId = province_spinner2.getSelectedItemPosition();
				strProvince = province_spinner2.getSelectedItem().toString();
				city_spinner2 = (Spinner) findViewById(R.id.city_spinner2);
				if(true)
				{	
					Log.v("test", "province: "+province_spinner2.getSelectedItem().toString()+provinceId.toString());
					county_spinner2 = (Spinner) findViewById(R.id.county_spinner2);
					city_spinner2 = (Spinner) findViewById(R.id.city_spinner2);
					city_spinner2.setPrompt("请选择城市");
					select(city_spinner2, city_adapter2, city[provinceId]);
					city_spinner2.setOnItemSelectedListener(new OnItemSelectedListener() 
					{
						
						
						@Override
						public void onItemSelected(AdapterView<?> arg0,
								View arg1, int arg2, long arg3) {
							cityId = city_spinner2.getSelectedItemPosition();
							strCity = city_spinner2.getSelectedItem().toString();
							Log.v("test", "city: "+city_spinner2.getSelectedItem().toString()+cityId.toString());
							if(true)
							{
								county_spinner2 = (Spinner) findViewById(R.id.county_spinner2);
								county_spinner2.setPrompt("请选择县区");
								switch (provinceId) {
								case 0:
									select(county_spinner2, county_adapter2, countyOfBeiJing[cityId]);
									break;
								case 1:
									select(county_spinner2, county_adapter2, countyOfTianJing[cityId]);
									break;
								case 2:
									select(county_spinner2, county_adapter2, countyOfHeBei[cityId]);
									break;
								case 3:
									select(county_spinner2, county_adapter2, countyOfShanXi1[cityId]);
									break;
								case 4:
									select(county_spinner2, county_adapter2, countyOfNeiMengGu[cityId]);
									break;
								case 5:
									select(county_spinner2, county_adapter2, countyOfLiaoNing[cityId]);
									break;
								case 6:
									select(county_spinner2, county_adapter2, countyOfJiLin[cityId]);
									break;
								case 7:
									select(county_spinner2, county_adapter2, countyOfHeiLongJiang[cityId]);
									break;
								case 8:
									select(county_spinner2, county_adapter2, countyOfShangHai[cityId]);
									break;
								case 9:
									select(county_spinner2, county_adapter2, countyOfJiangSu[cityId]);
									break;
								case 10:
									select(county_spinner2, county_adapter2, countyOfZheJiang[cityId]);
									break;
								case 11:
									select(county_spinner2, county_adapter2, countyOfAnHui[cityId]);
									break;
								case 12:
									select(county_spinner2, county_adapter2, countyOfFuJian[cityId]);
									break;
								case 13:
									select(county_spinner2, county_adapter2, countyOfJiangXi[cityId]);
									break;
								case 14:
									select(county_spinner2, county_adapter2, countyOfShanDong[cityId]);
									break;
								case 15:
									select(county_spinner2, county_adapter2, countyOfHeNan[cityId]);
									break;
								case 16:
									select(county_spinner2, county_adapter2, countyOfHuBei[cityId]);
									break;
								case 17:
									select(county_spinner2, county_adapter2, countyOfHuNan[cityId]);
									break;
								case 18:
									select(county_spinner2, county_adapter2, countyOfGuangDong[cityId]);
									break;
								case 19:
									select(county_spinner2, county_adapter2, countyOfGuangXi[cityId]);
									break;
								case 20:
									select(county_spinner2, county_adapter2, countyOfHaiNan[cityId]);
									break;
								case 21:
									select(county_spinner2, county_adapter2, countyOfChongQing[cityId]);
									break;
								case 22:
									select(county_spinner2, county_adapter2, countyOfSiChuan[cityId]);
									break;
								case 23:
									select(county_spinner2, county_adapter2, countyOfGuiZhou[cityId]);
									break;
								case 24:
									select(county_spinner2, county_adapter2, countyOfYunNan[cityId]);
									break;
								case 25:
									select(county_spinner2, county_adapter2, countyOfXiZang[cityId]);
									break;
								case 26:
									select(county_spinner2, county_adapter2, countyOfShanXi2[cityId]);
									break;
								case 27:
									select(county_spinner2, county_adapter2, countyOfGanSu[cityId]);
									break;
								case 28:
									select(county_spinner2, county_adapter2, countyOfQingHai[cityId]);
									break;
								case 29:
									select(county_spinner2, county_adapter2, countyOfNingXia[cityId]);
									break;
								case 30:
									select(county_spinner2, county_adapter2, countyOfXinJiang[cityId]);
									break;
								case 31:
									select(county_spinner2, county_adapter2, countyOfHongKong[cityId]);
									break;
								case 32:
									select(county_spinner2, county_adapter2, countyOfAoMen[cityId]);
									break;
								case 33:
									select(county_spinner2, county_adapter2, countyOfTaiWan[cityId]);
									break;
									
								default:
									break;
								}
								
								county_spinner2.setOnItemSelectedListener(new OnItemSelectedListener() 
								{
									
									
									@Override
									public void onItemSelected(
											AdapterView<?> arg0, View arg1,
											int arg2, long arg3) {
										strCounty = county_spinner2.getSelectedItem().toString();
										display2.setText(""+strProvince+"-"+strCity+"-"+strCounty);
									}
									
									
									@Override
									public void onNothingSelected(
											AdapterView<?> arg0) {
										
										
									}
								});
							}
						}
						
						
						@Override
						public void onNothingSelected(AdapterView<?> arg0) {
							// TODO Auto-generated method stub
							
						}
						
						
					});							
				}
			}
			
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		
	}
	
	private void select(Spinner spin, ArrayAdapter<CharSequence> adapter, int arry)
	{
		adapter = ArrayAdapter.createFromResource(this, arry, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adapter);
		//spin.setSelection(0,true);
	}
}
