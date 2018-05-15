SpringMVC集成MongoDB
       1.安装MongoDB
            a.下载mongodb安装包
            b.安装完成后在安装目录下创建三个文件夹
                  data:存放数据，log:存放日志，cfg:存放配置文件
            c.配置服务器
                   安装完成后不会自动配置服务器，需要手动配置
            d.启动mongodb服务器
                以管理员的身份启动   net start mongodb
       2.在idea中安装Mongodb插件
            a.通过idea的搜索工具搜索plugins
            b.在plugins窗体中搜索mongodb，并安装
            c.安装完成后，通过view菜单栏打开
       3.创建测试项目
            1.导入MOngoDB依赖jar包
                      <!-- https://mvnrepository.com/artifact/org.springframework.data/spring-data-mongodb -->
                      <dependency>
                        <groupId>org.springframework.data</groupId>
                        <artifactId>spring-data-mongodb</artifactId>
                        <version>2.0.5.RELEASE</version>
                      </dependency>
                      <!-- https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver -->
                      <dependency>
                        <groupId>org.mongodb</groupId>
                        <artifactId>mongo-java-driver</artifactId>
                        <version>3.6.3</version>
                      </dependency>    
            
            2.搭建springmvc
            
            3.启用MongoDB
                a.方式一，创建两个bean
                    @Bean
                    public MongoClientFactoryBean mongo(){
                        MongoClientFactoryBean mongo=new MongoClientFactoryBean();
                        mongo.setHost("localhost");
                        return mongo;
                    }
                
                    _@Bean
                    public MongoOperations mongoTemplate(MongoClient mongo){
                        return new MongoTemplate(mongo,"OrdersDB");
                    }
                    
                b.方式二，继承AbstractMongoConfiguration
                      @Override
                         public MongoClient mongoClient() {
                             return new MongoClient();
                         }
                     
                         @Override
                         protected String getDatabaseName() {
                             return "OrdersDB";
                         }
            3.创建model类
                1.通过@document注解指定model类
                2.通过@field注解指定属性
                
            4.编写MongoDB Repository
                    与Spring Data Repository方式类似_