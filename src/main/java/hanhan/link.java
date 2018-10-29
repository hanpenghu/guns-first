package hanhan;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/11.
 */
@SuppressWarnings("unchecked")
public  class link<T>{

   private List<T> list=new LinkedList<T>();

    public static <T> link b(){
        return new link<T>();
    }

    public link<T> a(T t){
        list.add(t);
        return this;
    }

    public List g() {
        return list;
    }



//    public static void main(String[]args){
//        List<String> g = link.b().a("1").a("2").g();
//        System.out.println(g);
//
//    }



}
