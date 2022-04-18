<template>
  <div>
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

<style>
h1{
    display: flex;
    flex-direction: row;
    justify-content: center;
}
</style>