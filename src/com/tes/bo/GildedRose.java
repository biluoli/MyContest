package com.tes.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GildedRose {

	private List<GoodsBo> good_list;

	public GildedRose(List<GoodsBo> in_goods_list) {

		this.good_list = in_goods_list;
	}

	public List<GoodsBo> update_commodity_quality_information() {

		List<GoodsBo> ret_goods_list = new ArrayList<GoodsBo>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if (null == good_list || good_list.size() == 0) {

			System.out.println("ERROR����Ʒ��ϢΪ�գ�");
			return null;
		} else {

			for (GoodsBo goods : good_list) {
				GoodsBo ret_goods = new GoodsBo();
				ret_goods = goods;
				if (goods.isPass()) {
					Date date_now = new Date();
					int cnt;
					try {
						cnt = Utils.longOfTwoDate(format.parse(format.format(date_now)),format.parse(goods.getPassPlayTime()));
						if (cnt > Constants.PASS_QUALITY_RAISE_VALUE_BEUYOND_DAYS) {
							ret_goods.setQuality(goods.getQuality() + Constants.PASS_QUALITY_RAISE_VALUE_BEUYOND_10);
							ret_goods.setSellIn(goods.getSellIn() - Constants.DAY_LESS_SELLIN_VALUE);
						}
						if (cnt > Constants.PASS_QUALITY_RAISE_VALUE_BETWEEN_DAYS
								&& cnt <= Constants.PASS_QUALITY_RAISE_VALUE_BEUYOND_DAYS) {

							ret_goods.setQuality(
									goods.getQuality() + Constants.PASS_QUALITY_RAISE_VALUE_BETWEEN_10_AND_5);
							ret_goods.setSellIn(goods.getSellIn() - Constants.DAY_LESS_SELLIN_VALUE);
						}

						if (cnt <= Constants.PASS_QUALITY_RAISE_VALUE_BETWEEN_DAYS) {
							if (cnt <= 0) {
								ret_goods.setQuality(0);
								ret_goods.setSellIn(0);
							} else {
								ret_goods.setQuality(
										goods.getQuality() + Constants.PASS_QUALITY_RAISE_VALUE_LESS_THEN_5);
								ret_goods.setSellIn(goods.getSellIn() - Constants.DAY_LESS_SELLIN_VALUE);
							}
						}

						
						ret_goods_list.add(ret_goods);
						continue;
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (goods.isLegend()) {
					ret_goods_list.add(ret_goods);
					continue;
				} else if (goods.isBrie()) {

					if(goods.getSellIn() == 0) {
							ret_goods.setQuality(goods.getQuality() - Constants.REDUCE_VALUE_OF_BAD_QUALITY);
					}else {
						if (goods.getQuality() < 50 && goods.getQuality() > 0) {
							ret_goods.setSellIn(goods.getSellIn() - Constants.DAY_LESS_SELLIN_VALUE);
							ret_goods.setQuality(goods.getQuality() + Constants.AGED_BRIE_QUALITY_RAISE_VALUE);
						} else if (goods.getQuality() >= 50 ) {
							ret_goods.setSellIn(goods.getSellIn() - Constants.DAY_LESS_SELLIN_VALUE);
							//ret_goods.setQuality(goods.getQuality() );
						} 
						
					}
					ret_goods_list.add(ret_goods);
					continue;
				
				}else {
					
					
					if(goods.getSellIn()==0) {
						ret_goods.setQuality(goods.getQuality() - Constants.REDUCE_VALUE_OF_BAD_QUALITY);
					}else {
						ret_goods.setSellIn(goods.getSellIn() - Constants.DAY_LESS_SELLIN_VALUE);
						ret_goods.setQuality(goods.getQuality() - Constants.DAY_LESS_QUALITY_VALUE);
					}
					
					ret_goods_list.add(ret_goods);
					continue;
				}

			}

		}

		return ret_goods_list;

	}
	/*
	 * һ���������޹��ڣ�Ʒ��ֵ`Quality`��ÿ���2�� - ��Ʒ��Ʒ��`Quality`��Զ����Ϊ��ֵ�� -
	 * "Aged Brie"���������ң���Ʒ��`Quality`��ÿ����1�� - ��Ʒ��Ʒ��`Quality`��Զ���ᳬ��50�� -
	 * ������Ʒ"Sulfuras"����Ϸ�е�ħ�������ߣ��������ڣ�Ҳ���ή��Ʒ��`Quality`�� -
	 * "Backstage passes"���糡��̨ͨ��֤����aged brie���ƣ�
	 * ��Ʒ��`Quality`�ھ糡����ǰ10�����⣬ÿ����1�����뿪�ݲ���10�죨��10�죩ʱ��
	 * Ʒ��`Quality`ÿ����2�����뿪�ݲ���5�죨��5�죩ʱ��Ʒ��`Quality`ÿ����3����һ���ݳ�������Ʒ�ʾͻήΪ0��
	 */

	
	public static void main(String[] args) {
		
		
		List<GoodsBo> in_goods_list = new ArrayList<GoodsBo>();
		
		GoodsBo g1 = new GoodsBo();
		GoodsBo g2 = new GoodsBo();
		GoodsBo g3 = new GoodsBo();
		GoodsBo g4 = new GoodsBo();
		g1.setGoodsName("g1");
		g1.setSellIn(10);
		g1.setQuality(20);
		
		g2.setGoodsName("g2");
		g2.setLegend(true);
		g2.setSellIn(100);
		g2.setQuality(100);
		
		g3.setGoodsName("g3");
		g3.setPassPlayTime("2019-04-12");
		g3.setPass(true);
		g3.setSellIn(20);
		g3.setQuality(50);
		
		g4.setGoodsName("g4");
		g4.setBrie(true);
		g4.setSellIn(10);
		g4.setQuality(50);
		in_goods_list.add(g1);
		in_goods_list.add(g2);
		in_goods_list.add(g3);
		in_goods_list.add(g4);
		
		List<GoodsBo> ret_goods_list = new ArrayList<GoodsBo>();
		
		
		GildedRose gr=  new GildedRose(in_goods_list);
		ret_goods_list = gr.update_commodity_quality_information();
		
		for(GoodsBo goods : ret_goods_list) {
			System.out.println("��Ʒ���ƣ�"+goods.getGoodsName()+" �����ڣ� "+goods.getSellIn()+" Ʒ�ʣ� "+goods.getQuality());
		}
	}

}
