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
            <h2>Modifica manuale del database:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.name}</g:link>
                    </li>
                </g:each>
            </ul>
        </div>
    </section>
</div>

</body>
</html>
