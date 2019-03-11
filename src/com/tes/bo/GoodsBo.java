package com.tes.bo;

public class GoodsBo {

	/*
	 * 一旦销售期限过期，品质值`Quality`会每天减2； - 商品的品质`Quality`永远不会为负值； -
	 * "Aged Brie"（法国干酪）的品质`Quality`会每天增1； - 商品的品质`Quality`永远不会超过50； -
	 * 传奇商品"Sulfuras"（游戏中的魔法锤道具）永不到期，也不会降低品质`Quality`； -
	 * "Backstage passes"（剧场后台通行证）与aged brie类似，
	 * 其品质`Quality`在剧场开演前10天以外，每天增1；当离开演不足10天（含10天）时，
	 * 品质`Quality`每天增2；当离开演不足5天（含5天）时，品质`Quality`每天增3；但一旦演出结束，品质就会降为0。
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
