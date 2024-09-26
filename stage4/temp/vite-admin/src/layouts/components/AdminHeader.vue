<template>
  <!--AdminHeader-->
  <div class="admin-header">
    <div @click="toggleMenu" class="menu-toggle-btn">
      <div v-if="isCollapse">
        <el-icon><DArrowRight /></el-icon>
      </div>
      <div v-else>
        <el-icon><DArrowLeft /></el-icon>
      </div>
    </div>

    <div class="header-actions">
      <el-button link @click="showDialog">修改密码</el-button>
      <el-button link type="danger" @click="logout">退出</el-button>
    </div>

    <el-dialog v-model="dialogVisible" title="修改密码">
      <el-form :model="form" ref="formRef">
        <el-form-item label="旧密码" :rules="[{ required: true, message: '请输入旧密码' }]">
          <el-input type="password" v-model="form.oldPassword"></el-input>
        </el-form-item>
        <el-form-item label="新密码" :rules="[{ required: true, message: '请输入新密码' }]">
          <el-input type="password" v-model="form.newPassword"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" :rules="[{ required: true, message: '请确认密码' }]">
          <el-input type="password" v-model="form.confirmPassword"></el-input>
        </el-form-item>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script setup>
import { ref, computed, watch } from 'vue';
import { useMainStore } from '@/store/index.js';
import { ElIcon } from 'element-plus';
import { DArrowLeft, DArrowRight } from '@element-plus/icons-vue';

const store = useMainStore();
const dialogVisible = ref(false);
const form = ref({
  oldPassword: '',
  newPassword: '',
  confirmPassword: '',
});

const isCollapse = computed(() => !(store.menuWidth === '250px'));

const toggleMenu = () => {
  store.menuWidth = store.menuWidth === '250px' ? '60px' : '250px'; // 切换菜单宽度
};

const showDialog = () => {
  console.log("1111")
  dialogVisible.value = true;
};

const logout = () => {
  console.log('退出登录');
};

const submit = () => {
  if (form.value.newPassword !== form.value.confirmPassword) {
    console.error('新密码与确认密码不一致');
    return;
  }

  console.log('旧密码:', form.value.oldPassword);
  console.log('新密码:', form.value.newPassword);
  // 重置表单
  form.value.oldPassword = '';
  form.value.newPassword = '';
  form.value.confirmPassword = '';
  dialogVisible.value = false;
}

watch(() => store.menuWidth, () => {
  const mainContent = document.querySelector('.main-content');
  if(isCollapse){
    mainContent.style.marginLeft = '0';
  }else{
    mainContent.style.marginLeft = '250px';
  }

  mainContent.style.transition = 'margin-left 0.3s';
});

</script>

<style scoped>
.admin-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
  background-color: #001428;
  color: #fff;
  height: 64px;
}

.menu-toggle-btn {
  color: #fff;
}

.header-actions {
  display: flex;
  gap: 10px;
}
</style>
