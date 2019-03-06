<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        Rivani Wines amministrazione
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation" style="background: #750c4a">
    <a class="navbar-brand" href="/#"><asset:image src="wines-admin-tool-logo-little.png" alt="Grails Logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <g:pageProperty name="page.nav"/>
        </ul>
    </div>

    <nav>
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Utente: ${session.utente.toString()} <span class="caret"></span></a>
            <ul class="dropdown-menu" style="background: #515151">
                <g:link controller="utente" action="logout">
                <li class="dropdown-item" >

                        <i class="fa fa-user"></i>Logout
                    </li></g:link>
                <g:link controller="utente" action="login"><li class="dropdown-item"><i class="fa fa-user"></i>Accedi come altro utente</li></g:link>
            </ul>
        </li>
    </nav>

</nav>



<g:layoutBody/>



<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
