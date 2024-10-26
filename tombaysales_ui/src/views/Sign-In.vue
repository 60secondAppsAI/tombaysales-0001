<template>
	<div class="sign-in">
		<a-row type="flex" :gutter="[24,24]" justify="center" align="middle">
			<!-- Brand Image Column -->
			<a-col :span="24" :md="12" :lg="{span: 12, offset: 0}" :xl="{span: 6, offset: 2}" class="col-form">
				<div class="brand">
					<img src="images/${application.imageFile}"
				</div>
				<h5 class="login-title">Login</h5>
			</a-col>
		</a-row>

		<a-row type="flex" :gutter="[24,24]" justify="center" align="middle">
			<!-- Sign In Form Column -->
			<a-col :span="24" :md="12" :lg="{span: 12, offset: 0}" :xl="{span: 6, offset: 2}" class="col-form">
				<!-- Sign In Form -->
				<a-form
					id="components-form-demo-normal-login"
					:form="form"
					class="login-form"
					@submit="handleSubmit"
					:hideRequiredMark="true"
				>
					<a-form-item class="mb-10" label="" :colon="false">
						<a-input
							v-decorator="[
								'username',
								{ rules: [{ required: true, message: 'Please input your username!' }] },
							]"
							placeholder="Username"
						/>
					</a-form-item>
					<a-form-item class="mb-5" label="" :colon="false">
						<a-input
							v-decorator="[
								'password',
								{ rules: [{ required: true, message: 'Please input your password!' }] },
							]"
							type="password"
							placeholder="Password"
						/>
					</a-form-item>
					<div class="forgot-password">
						<p class="font-semibold text-muted">
							<router-link to="/sign-in">Forgot password?</router-link>
						</p>
					</div>
					<a-form-item>
						<a-button type="primary" block html-type="submit" class="login-form-button">Login</a-button>
					</a-form-item>
				</a-form>
				<!-- / Sign In Form -->
				<p class="font-semibold text-muted">
					Don't have an account? <router-link to="/sign-in">Signup</router-link>
				</p>
			</a-col>
		</a-row>

		<a-row type="flex" :gutter="[24,24]" justify="center" align="middle">
			<!-- Sign In Image Column -->
			<a-col :span="24" :md="12" :lg="12" :xl="12" class="col-img">
				<img src="images/img-signin.jpg" alt="">
			</a-col>
		</a-row>
	</div>
</template>

<script>
import UserService from "../services/UserService";

export default {
	data() {
		return {
			rememberMe: true,
		};
	},
	beforeCreate() {
		this.form = this.$form.createForm(this, { name: 'normal_login' });
	},
	methods: {
		async handleSubmit(e) {
			e.preventDefault();
			this.form.validateFields(async (err, values) => {
				if (!err) {
					console.log('Received values of form: ', values);
					try {
						var response = await UserService.signIn(values);
						const token = response.data.token;
						if (token) {
							this.$router.push({ name: 'Applications' });
							localStorage.setItem('authToken', token);
						} else {
							alert('Incorrect username or password. Please try again.');
						}
					} catch (error) {
						console.log(error);
						if (error.response && error.response.status === 401) {
							alert('Incorrect username or password. Please try again.');
						} else {
							alert('An error occurred. Please try again later.');
						}
					}
				}
			});
		},
	},
};
</script>

<style lang="scss">
body {
	background-color: #ffffff;
}

.brand {
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	width: 100%;
	margin-bottom: 15px;
}

.brand img {
	max-width: 100%;
	height: auto;
}

.login-title {
	text-align: center;
	margin-bottom: 15px;
}

.col-form {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 1px !important; /* Reduce padding to 1px */
}

.login-form {
	width: 150%; /* Make the form 50% wider */
	max-width: 350px;
}

.login-form .ant-form-item {
	width: 100%; /* Ensure the input fields take the full width of the form */
}

.forgot-password {
	text-align: center;
	width: 100%;
}
</style>
