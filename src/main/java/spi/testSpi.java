package spi;

import java.util.Iterator;
import java.util.ServiceLoader;
import org.junit.Test;
import sun.misc.Service;

/**
 * test jdk spi
 * 1.它通过在ClassPath路径下的META-INF/services文件夹查找文件，自动加载文件里所定义的类。
 * 2.这一机制为很多框架扩展提供了可能，比如在Dubbo、JDBC中都使用到了SPI机制。
 * 3.META-INF/services文件夹下面 文件名字是接口的全限定类名，内容是实现类的全限定类名，多个实现类用换行符分隔
 *
 * jdk spi优点：将业务代码和具体实现类解耦，方便扩展。如需增加新逻辑，无需修改主流程，直接在PI配置文件增加实现类的全限定名即可。
 * jdk spi缺点：颗粒度不够细，无法准确定位某一个实现类。要执行就执行所有的实现类。
 * 针对jdk spi的缺点,dubbo中做出了优化,使用了key-value的配置格式,方便精准定位一个实现类
 *
 * test result:
   * SpiServiceAImpl test...
   * SpiServiceBImpl test...
   * ====================================分割线====================================
   * SpiServiceAImpl test...
   * SpiServiceBImpl test...
 *
 * @author clewill
 * @create 2021:06:11 21:31
 **/
public class testSpi {
  @Test
  public void test1(){
    //方式1
    Iterator<ISpiService> providers = Service.providers(ISpiService.class);
    while(providers.hasNext()){
      providers.next().test();
    }
    System.out.println(
        "====================================分割线====================================");
    //方式2
    ServiceLoader<ISpiService> load = ServiceLoader.load(ISpiService.class);
    for (ISpiService iSpiService : load) {
      iSpiService.test();
    }
  }
}
