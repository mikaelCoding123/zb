package com.demo.web.demo.bo;

import java.io.Serializable;
import java.util.List;

public class DkfpzfBo extends WebBo implements Serializable{
	private final static long serialVersionUID = 1L;
	private String uuidxh = ""; // UUID
	private String djxh = ""; //
	private String nsrmc ="";
	private String nsrsbh ="";
	private String lxruuid = "";//联系人id
	private List swws_flzl;//附件
	private String cxmc_type = "";//查询类型名称

	private String zzsfpuuid = "";//增值税发票UUID
	private String dksquuid = "";//代开申请UUID
	private String fpdm = "";//发票代码
	private String fphm = "";//发票号码
	private String kjrq = "";//开具日期
	private String sjq = "";
	private String sjz = "";
	private String by1 = "";//备用1-10
	private String by2 = "";
	private String by3 = "";
	private String by4 = "";
	private String by5 = "";
	private String by6 = "";
	private String by7 = "";
	private String by8 = "";
	private String by9 = "";
	private String by10 = "";

	private List<DkfpzfMxBo> mx; // 明细

	public String getUuidxh() {
		return uuidxh;
	}

	public void setUuidxh(String uuidxh) {
		this.uuidxh = uuidxh;
	}

	public String getDjxh() {
		return djxh;
	}

	public void setDjxh(String djxh) {
		this.djxh = djxh;
	}

	public String getNsrmc() {
		return nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getLxruuid() {
		return lxruuid;
	}

	public void setLxruuid(String lxruuid) {
		this.lxruuid = lxruuid;
	}

	public List getSwws_flzl() {
		return swws_flzl;
	}

	public void setSwws_flzl(List swws_flzl) {
		this.swws_flzl = swws_flzl;
	}

	public String getCxmc_type() {
		return cxmc_type;
	}

	public void setCxmc_type(String cxmc_type) {
		this.cxmc_type = cxmc_type;
	}

	public String getZzsfpuuid() {
		return zzsfpuuid;
	}

	public void setZzsfpuuid(String zzsfpuuid) {
		this.zzsfpuuid = zzsfpuuid;
	}

	public String getDksquuid() {
		return dksquuid;
	}

	public void setDksquuid(String dksquuid) {
		this.dksquuid = dksquuid;
	}

	public String getFpdm() {
		return fpdm;
	}

	public void setFpdm(String fpdm) {
		this.fpdm = fpdm;
	}

	public String getFphm() {
		return fphm;
	}

	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	public String getKjrq() {
		return kjrq;
	}

	public void setKjrq(String kjrq) {
		this.kjrq = kjrq;
	}

	public String getSjq() {
		return sjq;
	}

	public void setSjq(String sjq) {
		this.sjq = sjq;
	}

	public String getSjz() {
		return sjz;
	}

	public void setSjz(String sjz) {
		this.sjz = sjz;
	}

	public String getBy1() {
		return by1;
	}

	public void setBy1(String by1) {
		this.by1 = by1;
	}

	public String getBy2() {
		return by2;
	}

	public void setBy2(String by2) {
		this.by2 = by2;
	}

	public String getBy3() {
		return by3;
	}

	public void setBy3(String by3) {
		this.by3 = by3;
	}

	public String getBy4() {
		return by4;
	}

	public void setBy4(String by4) {
		this.by4 = by4;
	}

	public String getBy5() {
		return by5;
	}

	public void setBy5(String by5) {
		this.by5 = by5;
	}

	public String getBy6() {
		return by6;
	}

	public void setBy6(String by6) {
		this.by6 = by6;
	}

	public String getBy7() {
		return by7;
	}

	public void setBy7(String by7) {
		this.by7 = by7;
	}

	public String getBy8() {
		return by8;
	}

	public void setBy8(String by8) {
		this.by8 = by8;
	}

	public String getBy9() {
		return by9;
	}

	public void setBy9(String by9) {
		this.by9 = by9;
	}

	public String getBy10() {
		return by10;
	}

	public void setBy10(String by10) {
		this.by10 = by10;
	}

	public List<DkfpzfMxBo> getMx() {
		return mx;
	}

	public void setMx(List<DkfpzfMxBo> mx) {
		this.mx = mx;
	}
}
