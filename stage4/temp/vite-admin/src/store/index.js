import { defineStore } from 'pinia';

export const useMainStore = defineStore('main', {
    state: () => ({
        menuWidth: '250px',
    }),
});
