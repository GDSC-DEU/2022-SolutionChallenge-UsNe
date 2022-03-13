import { createRouter, createWebHistory } from 'vue-router';
import Home from '../pages';
import Login from '../pages/login';
import SignUp from '../pages/signup';
import AccountBook from '../pages/accountbook';
import Data from '../pages/data';
import Community from '../pages/community';
import Preferences from '../pages/preferences';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/login',
      name: 'LogIn',
      component: Login
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/accountbook',
      name: 'AccountBook',
      component: AccountBook
    },
    {
      path: '/data',
      name: 'Data',
      component: Data
    },
    {
      path: '/community',
      name: 'Community',
      component: Community
    },
    {
      path: '/preferences',
      name: 'Preferences',
      component: Preferences
    },
  ]
});

export default router;