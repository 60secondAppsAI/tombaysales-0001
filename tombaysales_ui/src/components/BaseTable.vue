<template>
  <div class="content">
    <div class="row">
    </div>
    
  </div>  
</template>

<script>
import Modal from "@/components/Modal";
import BaseButton from "@/components/BaseButton";
import BaseInput from "@/components/Inputs/BaseInput";
import NotificationTemplate from "@/pages/Notifications/NotificationTemplate";

import { Card } from "@/components/index";
import BaseTable from "@/components/BaseTable";

export default {
  components: {
    Card,
    BaseTable,
    Modal,
    BaseButton,
    BaseInput
  },

  data() {
    return {

      table1: {
        title: "Simple Table",
        columns: [...tableColumns],
        data: [...tableData],
      },
      table2: {
        title: "Table on Plain Background",
        columns: [...tableColumns],
        data: [...tableData],
      },
    };
  },

  methods: {
  },

  mounted() {
  }
};
</script>

<style>
.modal-dialog{
  margin-top: -300px;
}
</style>
