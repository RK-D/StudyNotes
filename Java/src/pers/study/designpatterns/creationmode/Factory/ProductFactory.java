package pers.study.designpatterns.creationmode.Factory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/5/23 18:21
 */
public class ProductFactory {
    private static final Map<String,Product> prMap = new HashMap();
    public static synchronized Product createProduct(String type) throws Exception{
        Product product = null;
        //如果Map中已经有这个对象
        if (prMap.containsKey(type)) {
            product = prMap.get(type);
        }else {
            if (type.equals("product1")){
                product = new ConcreteProduct();
            }
            prMap.put(type,product);
        }
        return product;
    }
}
