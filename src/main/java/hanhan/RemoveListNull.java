package hanhan;

import java.util.List;

//@SuppressWarnings("unchecked")
public class RemoveListNull {
    public static void remove(List list){
        while (list.contains(null)){
            list.remove(null);
        }


    }

//    public static void main(String[]args){
//        List g = new linklistT<String>().a(null).a("1").a("2").a(null).g();
//        p.p("-------------------------------------------------------");
//        p.p(g);//[1, 2, null]
//        p.p("-------------------------------------------------------");
//        RemoveListNull.remove(g);
//        p.p("-------------------------------------------------------");
//        p.p(g);//[1, 2]
//        p.p("-------------------------------------------------------");
//
//    }
}
