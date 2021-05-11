package pattern.structure.proxy;

import service.impl.OrderServiceImpl;

/**
 * 模拟用户客户端
 *
 * @author clewill
 * @create 2021:05:11 14:34
 **/
public class UserClient {
  public static void main(String[] args){
    System.out.println("订单前逻辑...");
    saveOrder();
    System.out.println("订单后逻辑...");
  }

  private static void saveOrder() {

  }
}
