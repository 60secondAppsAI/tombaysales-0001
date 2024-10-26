
<script>
import DropDown from "@/components/Dropdown.vue";
import Modal from "@/components/Modal.vue";

export default {
  components: {
    DropDown,
    Modal,
  },
  data() {
    return {
      searchModalVisible: false,
      searchQuery: "",
      showMenu: false,
    };
  },
  methods: {
    toggleSidebar() {
      this.$sidebar.displaySidebar(!this.$sidebar.showSidebar);
    },
    toggleMenu() {
      this.showMenu = !this.showMenu;
    },
  },
  computed: {
    isRTL() {
      return this.$rtl.isRTL;
    },
  },
};
</script>

<style></style>
