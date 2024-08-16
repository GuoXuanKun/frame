// 引入 需要 函数  createRouter 创建路由对象  createWebHistory
import { createRouter, createWebHistory } from "vue-router";
import Home from '../components/Home.vue';



const router = createRouter({
        routes:[{
            path:"/home",
            name:"Home",
            component:Home
        },{
            path:"/news",
            name:"News",
            component:News ,
            children:[
                    {
                        path:"/content",
                        name:"Content",
                        component:Content
                    }   
                ]
        },{
            path:"/about",
            name:"About",
            component:About
        },],
        history:createWebHistory() 
        
    });

// 把router 返回出去，共别人 引入
export default router;