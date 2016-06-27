# ksb
1. 公司本身该项目代码的臃肿;
2. 后台代码框架保持了5年没重构, 有些代码和编码规范实在看不下去;
3. 说好使用 bootstrap3 作为前端框架, 甚至于我已经做好部分页面, 奈何种种原因没有使用, 心有不甘;
基于以上3各原因, 做完该项目后便萌生了使用 springMVC 框架重构该项目的想法. 

下面说下项目使用到的技术.
1. 后台框架使用 springMVC, spring 版本为4.1.2;
2. 数据库使用 mongodb, 版本3.2.7, 因为现在公司使用的就是 mongodb, 如果想用 mysql 数据库的, 可看另一个项目, 地址 https://github.com/nihaoxiaosong/ksb_mysql.git;
3. orm框架没有使用公司原有的 morphia, 原因是使用 morphia 后, 要跟配置 hibernate 一样写 实现一层 BaseDao , 而 spring-data-mongodb 中已经帮我们集成了对 mongodb 的操作, 只需注入 MongoTemplate 即可;
4. 前端使用 bootstrap ,版本3.3.5, 终于可以自己完成前台页面了, 页面问题再也不用求人;
5. 模板引擎使用 freemarker , 版本2.3.23;

2016-06-25 22:44:13
初始化项目, 基础代码提交. 经过一天的调试, 终于使项目能跑起来, 可实现基本的从数据库取数据展示在页面上, 并实现分页.

2016-06-26 22:16:32
角色信息可以新增了, 但是更改状态还是报错, 明天还得再看看.

2016-06-27 20:27:33
更改状态可以了,原因是少了 spring-data-mongodb-cross-store jar 包和 mongodb 的 java 驱动包.
完成新增删除角色,新增模块功能.
