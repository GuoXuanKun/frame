import { createRouter, createWebHashHistory } from "vue-router";
import Layout from '@/layouts/admin.vue'

const routes = [
    {
        path: '/',
        component: Layout, // 使用箭头函数按需加载组件
        children: [
            {
                path: '/dashboard',
                name: 'dashboard',
                meta: {
                    title: '仪表盘',
                    icon:'home'
                },
                component: () => import('@/views/dashboard/Index.vue') // 同样使用箭头函数进行懒加载
            },
            {
                path: '/employee',
                name: 'employee',
                component: () => import('@/views/employee/Index.vue')
                ,meta:{
                    title:'员工管理',
                    icon:'people'
                }
            }
        ]
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('@/views/login/Login.vue')
    }
];

const router = createRouter({
    history: createWebHashHistory(), // 创建哈希历史记录模式
    routes // 指定路由配置
});

export default router; // 导出路由实例
