<script setup>

import {ref} from 'vue'

var msg = ref("gxk");

function changeMsg(){
    msg.value="666";
}

</script>

<template>

test02:{{msg}}
<button v-on:click="changeMsg">点一下</button>

</template>

<style>

</style>
