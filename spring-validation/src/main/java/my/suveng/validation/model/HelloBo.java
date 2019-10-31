package my.suveng.validation.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 *
 * @author suwenguang
 * @version 1.0.0
 **/
@Data
public class HelloBo {

	@NotNull
	private String c;

	private String d;
}
