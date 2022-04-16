import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import ViewTournament from '../views/ViewTournament'
import Create from '../views/Create'
import Account from '../views/Account'
import BrowseTournaments from '../views/BrowseTournaments'
import JoinTournamentForm from '../components/JoinTournamentForm'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {

        requiresAuth: false

      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/tournaments/:id",
      name: "view-tournament",
      component: ViewTournament,
      meta: {
        requiresAuth: false
      },
      children: [
        {
          path: 'join',
          name: 'join-tournament',
          component: JoinTournamentForm,
          meta: {
            requiresAuth: true
          }
        }
      ]
    },
    {
      path: "/create",
      name: "create-tournament",
      component: Create,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/account/:id",
      name: "account-details",
      component: Account,
      meta:{
        requiresAuth: true
      }
    },
    {
      path: "/browse/tournaments",
      name: "browse-tournaments",
      component: BrowseTournaments,
      meta: {
        requiresAuth: false
      }
    },
    // {
    //   path: "/invitations",
    //   name: "create-invite",
    //   component: Invite,
    //   meta: {
    //     requiresAuth: true
    //   }
    // }  
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
