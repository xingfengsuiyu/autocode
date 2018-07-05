# autocode
自动生成数据库表  

项目说明：  

    这是一个根据创建的实体类生成数据库表的工具，由于时间原因目前只支持MySql。后续会增加Oracle支持。也会增加自动生成CURD等基本业务逻辑  
    
如何运行：  

    创建你的数据库，配置数据库连接，启动AutogenerationApplication类即会自动生成你的表结构。  
    
    有新增表，新增字段，修改字段，删除字段等功能。 
    
包名说明  

    annotatiion:注解名，表注解，ID注解，索引注解，字段注解
    
    conf:配置包，获取application.properties注解
    
    controller:暂时无用
    
    entity:基础实体包，包含公用字段等
    
    enump:枚举包，数据库枚举类，字段枚举类
    
    exception:异常类，暂时未详细使用
    
    mapper:dao层
    
    service:service层
    
    table:获取注解的类
    
    util:工具包
    
    example:例子
    
 每个类中的注释已经很详细，
 
 我是一个开发3年多的JAVA，目前为快捷开发做的一个工具，还请多多指教代码。
 
 如果有问题请联系我，xingfengsuiyu@hotmail.com
 
