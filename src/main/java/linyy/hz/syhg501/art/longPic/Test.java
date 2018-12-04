package linyy.hz.syhg501.art.longPic;

public class Test {
    public static void main(String[] args) {
        int n = 100;
        O[] objects = new O[n];
        O last = new O();// 上一个
        O cur = new O();// 当前
        O oTemp = new O(); // 临时
        for (int i = 0; i < n; i++) {
            objects[i] = new O();
        }
        // 初始化前n-1个数据
        for (int i = 0; i < n - 1; i++) {
            objects[i].index = i;
            objects[i].o = objects[i + 1];
        }
        // 初始化最后一个
        objects[n - 1].index = n - 1;
        objects[n - 1].o = objects[0];
        // 当链表中只有自己时结束
        cur = objects[0];
        last = objects[n - 1];
        int if3 = 1;
        while (cur != cur.o) {
            if (if3 == 3) {
                // 删除节点
                last.o = cur.o;
                if3 = 1;
                cur = cur.o;
            } else {
                if3++;
                oTemp = cur;
                cur = cur.o;
                last = oTemp;
            }
        }
        System.out.println("最后剩下的是:" + cur.index);
    }
}

class O {
    public int index;

    public O o;
}
