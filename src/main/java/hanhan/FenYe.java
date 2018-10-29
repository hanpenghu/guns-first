package hanhan;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *首先set  dangQianYe---前端穿过来
 *
 * 再set  meiYeXianShiShu-----前端穿过来,不传默认写死10
 *
 * 再set   zongJiLuShu-------查数据库的总记录数
 *
 *
 *
 * 再set   zongYeShu------这一步是为了自动计算zongYeShu,
 * 但是这个set可以不用,因为我在上一步set调
 * 了这个set
 *
 *在sql中的时候
 * mysql最后跟上
 * limit  (dangQianYe-1)*meiYeXianShiShu, meiYeXianShiShu
 *
 * sqlServer
 *
 *select top (meiYeXianShiShu) from table where id not in(
 * 		 select top(   (meiYeXianShiShu)*(dangQianYe-1)   )id from PRDT_SAMP
 * )
 *
 * */
public class FenYe {
	private Integer dangQianYe;//当前页的页面传过来
	private Integer meiYeXianShiShu=10;
	private Integer zongYeShu;
	private Integer zongJiLuShu;
	//装一些实体数据
	private List<?extends Object> datas=new LinkedList<Object>();


	public static FenYe g(){
		return new FenYe();

	}





	public List<? extends Object> getDatas() {
		return datas;
	}







	public void setDatas(List<? extends Object> datas) {
		this.datas = datas;
	}

	public FenYe setZongYeShu(Integer zongYeShu) {
		this.zongYeShu = zongYeShu;
		return this;
	}

	public Integer getDangQianYe() {
		return dangQianYe;
	}
	public FenYe setDangQianYe(Integer dangQianYe) {
		this.dangQianYe = dangQianYe;
		return this;
	}
	public Integer getMeiYeXianShiShu() {
		if(empty(meiYeXianShiShu)||meiYeXianShiShu==0){
			meiYeXianShiShu=10;
		}
		return meiYeXianShiShu;
	}
	public FenYe setMeiYeXianShiShu(Integer meiYeXianShiShu) {
		if(empty(meiYeXianShiShu)||meiYeXianShiShu==0){
			meiYeXianShiShu=10;
		}
		this.meiYeXianShiShu = meiYeXianShiShu;
		return this;
	}
	public Integer getZongYeShu() {
		this.setZongYeShu();
		return this.zongYeShu;
	}
	
	public FenYe setZongYeShu() {
		this.meiYeXianShiShu=this.getMeiYeXianShiShu();
		if(this.zongJiLuShu%this.meiYeXianShiShu==0){
			this.zongYeShu=this.zongJiLuShu/this.meiYeXianShiShu;
		}else{
			this.zongYeShu=this.zongJiLuShu/this.meiYeXianShiShu+1;
		}
		return this;
	}
	
	public Integer getZongJiLuShu() {
		return zongJiLuShu;
	}
	public FenYe setZongJiLuShu(Integer zongJiLuShu) {
		this.zongJiLuShu = zongJiLuShu;
		//顺便把总页数也设置一下
		this.setZongYeShu();
		return this;
	}







	/**
	 *以下是空判断和非空判断以及所有非空判断和所有空的判断,如果是包含空的
	 * 判断请用   !allNotEmpty
	 * */

	public static boolean empty(Object ob){

		if(notEmpty(ob)){
			return false;
		}else{
			return true;
		}

	}




	public static boolean notEmpty(Object ob){
		if(ob==null){
			return false;
		}else{
			if(ob instanceof String){
				if("".equals(ob)){return false;}else{return true;}
			}else if(ob instanceof Collection){
				if(((Collection) ob).size()>0){return true;}else{return false;}
			}else if(ob instanceof Map){
				if(((Map) ob).size()>0){return true;}else{return false;}
			}/*else if(ob instanceof JSONObject){
                if(((JSONObject) ob).isEmpty()){return false;}else{
                    if(((JSONObject) ob).size()==0){return false;}else{return true;}
                }
            }else if(ob instanceof JSONArray){
                if(((JSONArray) ob).isEmpty()){return false;}else{
                    if(((JSONArray) ob).size()==0){return false;}else{return true;}
                }
            }*/else{return true;}
		}
	}






}
