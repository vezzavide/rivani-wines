
<asset:stylesheet src="shopTemplate/style__.css"/>
<asset:stylesheet src="shopTemplate/css/bootstrap.min.css"/>
	
<div class="wrapper fadeInDown"  style="background-color:#750c4a">
  <div id="formContent">
    <!-- Tabs Titles -->
    <g:if test="${flash.message}">
      <div class="alert alert-info" role="alert">
        ${flash.message}
      </div>
    </g:if>

    <br>


    <!-- Login Form -->
    <g:form name="signupForm" action="save">
      <input type="text" id="nome" class="fadeIn second" name="nome" placeholder="Nome">
      <input type="text" id="cognome" class="fadeIn second" name="cognome" placeholder="Conome">
      <input type="text" id="indirizzo" class="fadeIn second" name="indirizzo" placeholder="Indirizzo">
      <input type="text" id="e-mail" class="fadeIn second" name="email" placeholder="E-mail">
	  <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
	  
      <input type="submit" class="fadeIn fourth" value="Registrati">
    </g:form>



  </div>
</div>

<asset:javascript src="jquery-3.3.1.min.js"/>

<asset:javascript src="bootstrap.min.js"/>