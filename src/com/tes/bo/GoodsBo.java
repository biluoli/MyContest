package com.tes.bo;

public class GoodsBo {

	/*
	 * һ���������޹��ڣ�Ʒ��ֵ`Quality`��ÿ���2�� - ��Ʒ��Ʒ��`Quality`��Զ����Ϊ��ֵ�� -
	 * "Aged Brie"���������ң���Ʒ��`Quality`��ÿ����1�� - ��Ʒ��Ʒ��`Quality`��Զ���ᳬ��50�� -
	 * ������Ʒ"Sulfuras"����Ϸ�е�ħ�������ߣ��������ڣ�Ҳ���ή��Ʒ��`Quality`�� -
	 * "Backstage passes"���糡��̨ͨ��֤����aged brie���ƣ�
	 * ��Ʒ��`Quality`�ھ糡����ǰ10�����⣬ÿ����1�����뿪�ݲ���10�죨��10�죩ʱ��
	 * Ʒ��`Quality`ÿ����2�����뿪�ݲ���5�죨��5�죩ʱ��Ʒ��`Quality`ÿ����3����һ���ݳ�������Ʒ�ʾͻήΪ0��
	 */	
	
	
	
	private int quality;
	private int sellIn;
	private String goodsName;
	private boolean isLegend;
	private boolean isPass;
	private boolean isBrie;
	private String passPlayTime;
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		if(quality<=0) {
			quality=0;
		}
		this.quality = quality;
	}
	
	public int getSellIn() {
		return sellIn;
	}
	public void setSellIn(int sellIn) {
		if(sellIn<=0) {
			sellIn=0;
		}
		this.sellIn = sellIn;
	}
	
	
	public boolean isBrie() {
		return isBrie;
	}
	public void setBrie(boolean isBrie) {
		this.isBrie = isBrie;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public boolean isLegend() {
		return isLegend;
	}
	public void setLegend(boolean isLegend) {
		this.isLegend = isLegend;
	}
	public boolean isPass() {
		return isPass;
	}
	public void setPass(boolean isPass) {
		this.isPass = isPass;
	}
	public String getPassPlayTime() {
		return passPlayTime;
	}
	public void setPassPlayTime(String passPlayTime) {
		this.passPlayTime = passPlayTime;
	}
	
	
	
}
