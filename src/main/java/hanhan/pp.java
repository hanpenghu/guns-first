package hanhan;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *用于测试封装外部jar包的工具
 * */
public class pp {

private org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(this.getClass());

    /**
     *封装apahce包的sha1加密
     * */
    public static String sha1(String s){



        return DigestUtils.shaHex(s);
    }


    /**
     *根据编码来读取文本
     * 参数  luJing
     * 可以是全路径
     * springboot的如果是跟jar包同一级路径的文件,只要写文件名就好了
     * */

    public static String usCodeReadTxt(String luJing,String bianMa)  {
        try {
            return IOUtils.toString(new FileInputStream(luJing),bianMa);
        } catch (IOException e) {
            return "";
        }
    }

    public static String usCodeReadTxt(File file,String bianMa) {
        try {
            return IOUtils.toString(new FileInputStream(file),bianMa);
        } catch (IOException e) {
            return "";
        }
    }

    /**
     *直接返回给浏览器一个打不开只能下载的file
     * */

    public static ResponseEntity<byte[]> returnBrowserFileToDownLoad(File file) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", new String(file.getName().getBytes("UTF-8"), "iso-8859-1"));
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);

    }


}
