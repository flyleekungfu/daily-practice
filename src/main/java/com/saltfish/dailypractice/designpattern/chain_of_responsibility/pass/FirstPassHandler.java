package com.saltfish.dailypractice.designpattern.chain_of_responsibility.pass;

public class FirstPassHandler extends AbstractHandler{

    private int play() {
        return  80;
    }

    @Override
    public int handler() {
        System.out.println("第一关-->FirstPassHandler");

        int score = play();
        if (score >= 80) {
            // 分数>=80 并且存在下一关才进入下一关
            if (next != null) {
                return this.next.handler();
            }
        }

        return score;
    }

}
