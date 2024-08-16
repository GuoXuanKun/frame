import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router  from './router'  // 刚刚写的index.js文件 因为router文件夹下有且仅有一个 index.js 可以简写

createApp(App).mount('#app')
