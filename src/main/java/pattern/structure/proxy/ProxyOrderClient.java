package pattern.structure.proxy;

import service.OrderService;
import service.impl.OutSideOrderServiceImpl;

/**
 * 订单代理类
 * @author clewill
 * @create 2021:05:11 14:18
 **/
public class ProxyOrderClient implements OrderService {

  /**
   * 真正的订单服务
   */
  private final OrderService orderService = new OutSideOrderServiceImpl();
  @Override
  public void saveOrders() {
    orderService.saveOrders();
  }
}
