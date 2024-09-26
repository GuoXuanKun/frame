<!--admin.vue-->
<template>
  <el-container>
    <el-aside width="200px" :style="{ width: store.menuWidth }">
      <AdminMenu></AdminMenu>
    </el-aside>

    <el-container>
      <el-header>
        <AdminHeader></AdminHeader>
      </el-header>

      <el-main>
        <div class="main-content">
          <router-view v-slot="{ Component }">
            <Transition name="fade">
              <keep-alive :max="10">
                <component :is="Component"></component>
              </keep-alive>
            </Transition>
          </router-view>
        </div>
      </el-main>

      <el-footer>
        <AdminFooter></AdminFooter>
      </el-footer>
    </el-container>
  </el-container>
</template>

<script setup>
import AdminHeader from "./components/AdminHeader.vue";
import AdminMenu from "./components/AdminMenu.vue";
import AdminFooter from "./components/AdminFooter.vue";
import { useMainStore } from '@/store/index.js';

const store = useMainStore();
</script>

<style scoped>
/* 父容器 */
.el-container {
  height: 100vh; /* 设置容器高度为视口高度 */
  display: flex; /* 使用flex布局 */
}

/* 左侧菜单栏 */
.el-aside {
  height: 100%; /* 设置高度为100%，填充整个父容器 */
}

/* 内部容器 */
.el-container.el-container {
  flex: 1; /* 自动伸缩，填充剩余空间 */
  height: 100%; /* 设置高度为100%，填充整个父容器 */
}

/* 头部 */
.el-header {
  height: 64px; /* 根据实际需求设置头部高度 */
  padding: 0;
}

/* 主体内容 */
.main-content {
  height: calc(100% - 64px); /* 减去头部高度 */
  display: flex; /* 使用flex布局 */
  flex-direction: column; /* 垂直排列子元素 */
}

/* 主体内容容器 */
.el-main {
  flex-grow: 1; /* 自动伸缩，填充剩余空间 */
  margin-left: calc(var(--el-aside-width) + 16px); /* 根据左侧菜单宽度调整 */
}

/* 底部 */
.el-footer {
  height: 60px; /* 根据实际需求设置底部高度 */
  padding: 0 !important;
}

/* 其他过渡效果 */
.fade-enter-from,
.fade-leave-to {
  opacity: 0;
}

.fade-enter-to,
.fade-leave-from {
  opacity: 1;
}

.fade-enter-active,
.fade-leave-active {
  transition: all 0.3s;
}
.fade-enter-active {
  transition-delay: 0.3s;
}
</style>

