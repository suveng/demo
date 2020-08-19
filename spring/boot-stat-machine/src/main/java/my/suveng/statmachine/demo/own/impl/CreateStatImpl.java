package my.suveng.statmachine.demo.own.impl;

import my.suveng.statmachine.demo.own.IStat;

/**
 *
 * @author suwenguang
 **/
public class CreateStatImpl implements IStat {

    @Override
    public void doBefore() {
        System.out.println("craete before");
    }

    @Override
    public void doAction() {
        System.out.println("create doing");
    }

    @Override
    public void doAfter() {
        System.out.println("create after");
    }
}
