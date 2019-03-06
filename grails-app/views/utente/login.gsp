
<asset:stylesheet src="shopTemplate/style__.css"/>
<asset:stylesheet src="shopTemplate/css/bootstrap.min.css"/>
	
<div class="wrapper fadeInDown" style="background-color:#750c4a">
  <div id="formContent">
    <!-- Tabs Titles -->
  <!-- Display Error -->
    <g:if test="${flash.message}">
      <div class="alert alert-info" role="alert">
        ${flash.message}
      </div>
    </g:if>
    <br>



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

<asset:javascript src="jquery-3.3.1.min.js"/>

<asset:javascript src="bootstrap.min.js"/>