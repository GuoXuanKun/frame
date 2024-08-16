<script setup>

</script>

<template>

<!--  相当于 a标签 点击跳转  -->
<RouterLink to="home">首页</RouterLink>
<RouterLink to="news">新闻</RouterLink>|
<RouterLink to="about">关于</RouterLink>

<RouterView></RouterView>
<!--   <!—点击 RouterLink  会在  RouterView 显示 对应的组件 -->

</template>

<style scoped>


</style>
