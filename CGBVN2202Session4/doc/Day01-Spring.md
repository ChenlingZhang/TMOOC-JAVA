# Day01 Spring 
## 创建项目以及配置 
- Server URL：
  > https://start.spring.io / https://start.springboot.io
- Name: Definded By yourself, no effect on project structure
- Java Version: '8'
- Spring Version: '2.5.9'

## Spring 框架的作用
- 主要解决了创建对象和管理对象的问题，是Spring MVC，SpringBoot，Spring Cloud的基础框架
- 在使用Spring框架后，当需有某个对象时，直接通过Spring获取此对象即可
- Spring 可以保证类的对象的唯一性，使得各组件出现依赖关系时，不会创建多个对象 
- 由于Spring会创建很多个对象并管理起来，开发者需要时直接获取即可，所以，Spring也通常被称之为"Spring"容器

## Spring 组件扫描 
1. 添加组件注解（Spring框架作用范围：以下四个注解是等效的）
   - @Component（通用注解）
   - @Controller（控制器注解）
   - @Service（业务注解）
   - @Repository（存储注解）
2. 必须在"组件扫描"包下 
   - Spring 框架会执行"组件扫描"，会在某个包下查找所有的类，类上添加了组件注解，就会创建此类的对象 
   - SpringBoot 项目默认执行了组件扫描，且扫描包就是创建项目已生成的包（"根包"）
   - 组件类放在此根包下的个各个层级子孙包中也是有效的

## 如何选择创建并管理对象 
- 仅自定义的类型可以使用组件扫描的方式 
- 非自定义的类型不可以使用组件扫描的方式，只能使用 '@Bean'方法的做法