package my.suveng.statmachine.demo.own.impl;

import my.suveng.statmachine.demo.own.IStat;

/**
 *
 * @author suwenguang
 **/
public class ReadyStatImpl implements IStat {

	@Override
	public void doBefore() {
		System.out.println("ready before");
	}

	@Override
	public void doAction() {
		System.out.println("ready doing");
	}

	@Override
	public void doAfter() {
		System.out.println("ready after");
	}
}
