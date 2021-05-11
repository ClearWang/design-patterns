package pattern.structure.proxy;

import service.OrderService;
import service.impl.OrderServiceImpl;
import service.impl.OutSideOrderServiceImpl;

/**
 * 模拟用户客户端
 *     假设用户处于中国 现在想购买一个马来西亚的猫山王榴莲 那么用户有两种订单服务方式：
 *     1.直接调用本地订单服务-OrderServiceImpl(需要用户自己去马来西亚)   saveOrderByLocal
 *     2.通过代理完成订单服务-OutSideOrderServiceImpl(通过代理去完成)   saveOrderByProxy
 * @author clewill
 * @create 2021:05:11 14:34
 **/
public class UserClient {
  public static void main(String[] args){
    System.out.println("订单前逻辑...");
    saveOrderByLocal();
    saveOrderByProxy();
    System.out.println("订单后逻辑...");
  }

  private static void saveOrderByLocal() {
    OrderService orderService = new OrderServiceImpl();
    orderService.saveOrders();
  }

  private static void saveOrderByProxy() {
    OrderService orderService = new ProxyOrderClient();
    orderService.saveOrders();
  }
}
