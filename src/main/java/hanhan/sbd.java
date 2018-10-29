package hanhan;

/**
 *使用StringBuilder添加成一个字符串
 * */
public class sbd {


//    public static void main(String[]args){
//        String g = sbd.b().a("我").a("你").g();
//        p.p(g);
//    }

    private StringBuilder s=null;
    //构造函数
    public sbd(){
        s=new StringBuilder();
    }

    //建造者
    public static sbd b(){
        return new sbd();
    }

    //添加者//s是要相加的字符串
    public sbd a(String str){
        s.append(str);
        return this;
    }

    //收获者

    public String g(){
        return s.toString();
    }



}
