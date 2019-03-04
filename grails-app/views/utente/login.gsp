
<asset:stylesheet src="shopTemplate/style__.css"/>
	
<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->



    <!-- Login Form -->
    <g:form name="loginForm" action="autenticaUtente">
      <input type="text" id="login" class="fadeIn second" name="email" placeholder="Email">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="Password">
      <input type="submit" class="fadeIn fourth" value="Accedi">
    </g:form>

    <!-- Remind Passowrd -->

	<div id="formFooter">
	  <g:link class="underlineHover" controller="cliente" action="signup">Registrazione</g:link>
    </div>

  </div>
</div>