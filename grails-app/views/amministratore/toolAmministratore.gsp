<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>
<body>


<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Rivani Wines - Strumenti amministratore</h1>


        <div id="controllers" role="navigation">
            <h2>Strumenti dipendente:</h2>
            <ul>
                <li class="controller">
                    <g:link controller="dipendente" action="toolDipendente">Strumenti dipendente</g:link>
                </li>
            </ul>
            <h2>Modifica manuale del database:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <g:if test="${c.name != 'Catalogo'}">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
                    </li>
                    </g:if>
                </g:each>
            </ul>


        </div>
    </section>
</div>

</body>
</html>
