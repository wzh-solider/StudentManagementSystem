<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
	<!-- https://codepen.io/danielkvist/pen/LYNVyPL -->
	<head>
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>StudentManagementSystem</title>
		<link rel="stylesheet" href="css/index.css">
	</head>

	<body>
		<div class="container right-panel-active">
			<!-- Sign Up -->
			<div class="container__form container--signup">
				<form action="signUp" method="Post" class="form" id="form1">
					<h2 class="form__title">Sign Up</h2>
					<input type="text" name="username" placeholder="User" class="input"/>
					<input type="email" name="email" placeholder="Email" class="input"/>
					<input type="password" name="password" placeholder="Password" class="input"/>
					<button type="submit" class="btn">Sign Up</button>
				</form>
			</div>

			<!-- Sign In -->
			<div class="container__form container--signin">
				<form action="signIn" method="get" class="form" id="form2">
					<h2 class="form__title">Sign In</h2>
					<input type="email" name="email" placeholder="Email" class="input"/>
					<input type="password" name="password" placeholder="Password" class="input"/>
					<a href="#" class="link">Forgot your password?</a>
					<button type="submit" class="btn">Sign In</button>
				</form>
			</div>

			<!-- Overlay -->
			<div class="container__overlay">
				<div class="overlay">
					<div class="overlay__panel overlay--left">
						<button class="btn" id="signIn">Sign In</button>
					</div>
					<div class="overlay__panel overlay--right">
						<button class="btn" id="signUp">Sign Up</button>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="js/index.js"></script>
</html>
