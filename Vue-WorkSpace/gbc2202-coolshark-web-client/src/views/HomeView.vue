<template>
  <div class="home">
    <el-container>
      <!--页面Header部分-->
      <el-header class="layout-header">
        Header
      </el-header>
      <el-container class="layout-body">
        <!--左边导航栏-->
        <el-aside class="layout-side">
          <el-menu default-active="/user/userList" class="el-menu-vertical-demo" router>
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-user-solid"></i>
                <span>用户管理</span>
              </template>
              <el-menu-item index="/user/userList" i class="el-icon-s-order">用户列表</el-menu-item>
              <el-menu-item index="/user/userAddNew" i class="el-icon-plus">新增用户</el-menu-item>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">
                <i class="el-icon-user-solid"></i>
                <span>商品管理</span>
              </template>
              <el-menu-item index="/brand/brandList" i class="el-icon-s-order">商品列表</el-menu-item>
              <el-menu-item index="/brand/brandAddNew" i class="el-icon-plus">新增商品</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <!-- 主题页面 -由router-view标签具体实现 -->
        <el-main>
          <router-view/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style>
*{
  margin:0;
}
.layout-header{
  background-color:#42b983;
  color:#2c3e50;
}
.layout-side{
  background-color: aquamarine;
}
.layout-body{
  position: absolute;
  top:60px;
  right: 0;
  bottom:0;
  left: 0;
}
</style>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
