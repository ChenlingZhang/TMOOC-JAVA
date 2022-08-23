import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)
// 用于配置路由
const routes = [
  {
    path: '/user',
    name: 'home',
    component: HomeView,
    redirect:'/user/userList',
    children:[ {
                  path: "userList",
                  name: "UserListView",
                  component: ()=> import("../views/user/UserListView"),
                  meta:{
                      title:"酷鲨商城运营管理平台--用户列表"
                  }
                },
                {
                  path: "userAddNew",
                  name:"UserAddNewView",
                  component: ()=>import("../views/user/UserAddNewView"),
                  meta: {
                      title: "酷鲨商城运营管理平台--新增用户"
                    }
                },
                {
                    path: "/brand/brandList",
                    name:"brandListView",
                    component: ()=>import("../views/brand/BrandListView"),
                    // meta: {
                    //     title: "酷鲨商城运营管理平台--商品列表"
                    // }
                },
                {
                    path:"/brand/brandAddNew",
                    name:"brandAddNew",
                    component:()=>import("../views/brand/BrandAddNewView"),
                    meta: {
                        title: "酷鲨商城运营管理平台--新增商品"
                    }
                }]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: "/",
    name: "Login",
    component: ()=> import('../views/LoginView.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to,from,next)=>{
    document.title = to.meta.title ==null?"酷鲨商城运营管理平台":to.meta.title;
    next(); // 继续前进
})
export default router
