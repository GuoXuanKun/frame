<template>
  <!--AdminMenu.vue-->
  <div class="menu" :style="{ width: store.menuWidth }">
    <div class="logo">
      <img v-if="store.menuWidth === '250px'" src="@/assets/weblog-logo.png" class="h-[60px]">
      <img v-else src="@/assets/weblog-logo-mini.png" class="h-[60px]">
    </div>
    <div class="menu-content">
      <el-menu :collapse="isCollapse" class="admin-el-menu"
               :default-active="defaultActive"
               :collapse-transition="false"
               unique-opened
               @select="handleSelect">
        <template v-for="(item, index) in menus" :key="index">
          <el-menu-item :index="item.path" class="admin-el-menu-item">
            <el-icon>
              <component :is="item.icon"></component>
            </el-icon>
            <span>{{ item.title }}</span>
          </el-menu-item>
        </template>
      </el-menu>
    </div>
  </div>
</template>

<script setup>
import {useRouter, useRoute} from 'vue-router';
import {computed, ref} from 'vue';
import {useMainStore} from '@/store/index.js';

const router = useRouter();
const route = useRoute();
const store = useMainStore();

const defaultActive = ref(route.path);

const isCollapse = computed(() => !(store.menuWidth === '250px'));

const menus = computed(() => {
  return router.options.routes.flatMap(route => {
    if (route.children) {
      return route.children.filter(child => child.meta && child.meta.title).map(child => ({
        path: child.path,
        title: child.meta.title,
        icon: child.meta.icon
      }));
    }
    return [];
  });
});

const handleSelect = (path) => {
  router.push(path);
};
</script>

<style scoped>
.menu {
  transition: all 0.3s;
  height: 100vh; /* 设置高度为视口高度 */
  position: fixed; /* 固定位置 */
  top: 0;
  left: 0;
  overflow-y: auto;
  overflow-x: hidden;
  background-color: #001428 !important;
}

.logo {
  height: 64px;
  background-color: #001428;
  color: #fff;
  @apply flex justify-center items-center text-xl font-thin;
}

.menu-content {
  height: calc(100% - 64px); /* 减去顶部 logo 的高度 */
  overflow-y: auto;
}

.admin-el-menu {
  background-color: #001428 !important;
  border-right: none;
}

.admin-el-menu-item {
  color: #c0c4cc !important;
  background-color: #001428 !important;
}

.el-menu-item.is-active {
  background-color: #ffffff10 !important;
}

.el-menu-item.is-active:before {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 2px;
  height: 100%;
  background-color: var(--el-color-primary);
}

.el-menu-item:hover {
  background-color: #ffffff10;
}
</style>
