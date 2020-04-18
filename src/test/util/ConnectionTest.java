package util;

import com.hxp.utils.ConnectionTestUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

/**
 * Created by huang on 2020/4/17.
 */
public class ConnectionTest {
    @Test
    public void testConnnection(){
        Boolean result =ConnectionTestUtil.connectionTest("jdbc:mysql://localhost:3306/dw?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root","root");
        System.out.print(result);
    }
}
