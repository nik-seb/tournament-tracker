<template>
  <div id="invite-body">
      <h1>Invite Form</h1>
      <invite-form />
  </div>
</template>

<script>
import InviteForm from "@/components/InviteForm.vue";
export default {
name: "Invite",
    components: {
        InviteForm
    }
}
</script>

<style scoped>

h1{
    display: flex;
    flex-direction: row;
    justify-content: center;
    background-color: goldenrod;
    border: thick, dotted;
 position: relative;
  z-index: 1;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  background:goldenrod;
  max-width: 360px;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24); 
  color: black;
}


</style>