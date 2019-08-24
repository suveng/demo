package my.suveng.campus.common.outermessage.robotdingtalk.model.enums;

/**
 * description:
 * @author suwenguang
 * @date 2019-08-11
 * @version 1.0.0
 **/
public enum  DingTalkResultEnums {
	SUCCESS(0L,"ok"),
	;

	DingTalkResultEnums() {
	}

	DingTalkResultEnums(Long errcode, String errmsg) {
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	private Long errcode;
	private String errmsg;

	public Long getErrcode() {
		return errcode;
	}

	public void setErrcode(Long errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}}
