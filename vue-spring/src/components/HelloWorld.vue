<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <table class="table">
      <thead>
        <th>name</th>
        <th>job</th>
        <th>home</th>
      </thead>
      <tbody v-for="(member, index) in members" :key="index">
        <td>
          {{ member.name }}
        </td>
        <td>
          {{ member.job }}
        </td>
        <td>
          {{ member.home }}
        </td>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from "axios";
axios.defaults.baseURL = "/api";
// axios.defaults.headers.post["Content-Type"] = "application/json;charset=utf-8";
// axios.defaults.headers.post["Access-Control-Allow-Origin"] = "*";
import { onMounted, ref } from "vue";

export default {
  name: "HelloWorld",
  props: {
    msg: String,
  },
  setup() {
    const members = ref({});

    onMounted(() => {
      axios.get("/").then((res) => {
        console.log(res.data);
      });
      axios
        .get("/members")
        .then((res) => {
          console.log(res.data);
          members.value = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    });

    return {
      members,
    };
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
